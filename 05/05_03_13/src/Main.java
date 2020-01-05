import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {

    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        byte[] byteBuffer = new byte[inputStream.available()];
        int byteFromStream;
        int pointer = 0;
        while ((byteFromStream = inputStream.read()) != -1) {
            byteBuffer[pointer++] = (byte) byteFromStream;
        }
        return new String(byteBuffer,charset);
    }
}
