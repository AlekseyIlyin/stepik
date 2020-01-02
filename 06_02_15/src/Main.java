import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // + for debug
        InputStream standartIO = System.in;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1 2 3 4 5 6 7".getBytes());
        System.setIn(byteArrayInputStream);
        // - for debug

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] line = reader.readLine().split(" ");
            int i = line.length;
            LinkedList<String> buff = new LinkedList<>();
            for (int j = 1; j < i; ++j) {
                if ((j & 1) != 0) {
                    buff.addFirst(line[j]);
                }
            }
            buff.forEach(e -> System.out.print(e + " "));
        } catch (IOException e) {

        } catch (NullPointerException e) {

        }

        // + for debug
        System.setIn(standartIO);
        // - for debug

    }
}