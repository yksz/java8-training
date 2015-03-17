package ch09.ex02;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class TryWithResources {

    public static void main(String[] args) throws Exception {
        Exception ex = null;
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get("/usr/share/dict/words"));
            out = new PrintWriter("/tmp/out.txt");
            while (in.hasNext())
                out.println(in.next().toLowerCase());
        } catch (Exception e) {
            ex = e;
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (Exception e1) {
                if (ex != null)
                    ex.addSuppressed(e1);
                else
                    ex = e1;
            }
            try {
                if (out != null)
                    out.close();
            } catch (Exception e2) {
                if (ex != null)
                    ex.addSuppressed(e2);
                else
                    ex = e2;
            }
            if (ex != null)
                throw ex;
        }
    }

}
