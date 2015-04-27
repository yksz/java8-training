package ch09.ex11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Grep {

    static void copy(InputStream in, OutputStream out) throws IOException {
        try (BufferedInputStream bin = new BufferedInputStream(in);
                BufferedOutputStream bout = new BufferedOutputStream(out)) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = bin.read(buf)) != -1)
                bout.write(buf, 0, len);
            bout.flush();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("usage: java Grep <string>");
            System.exit(1);
        }
        String str = args[0];
        String dir = System.getProperty("user.home");
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("grep", "-r", str, dir);
        Process process = builder.start();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        copy(process.getInputStream(), out);
        System.out.println(out);
    }

}
