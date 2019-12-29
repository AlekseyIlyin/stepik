import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});

        try {
            System.out.println(readAsString(byteArrayInputStream, Charset.forName("ASCII")));
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        ArrayList bytes = new ArrayList();

        int byteFromStream;
        while((byteFromStream = inputStream.read()) != -1) {
            bytes.add((byte)byteFromStream);
        }

        return String.valueOf(charset.encode(Arrays.toString(bytes.toArray())));
    }
}
