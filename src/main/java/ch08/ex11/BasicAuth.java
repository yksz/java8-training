package ch08.ex11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

public class BasicAuth {

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.out.println("java BasicAuth <url> <username> <password>");
            System.exit(0);
        }
        URL url = new URL(args[0]);
        String username = args[1];
        String password = args[2];

        String original = username + ":" + password;
        String encoded = Base64.getEncoder().encodeToString(original.getBytes());
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("Authorization", "Basic " + encoded);
        connection.connect();
        try (InputStream in = connection.getInputStream(); OutputStream out = System.out) {
            byte[] buf = new byte[8192];
            int len;
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
        }
    }

}
