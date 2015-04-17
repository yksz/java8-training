package ch01.ex04;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

public class FileSort {

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    public static void main(String[] args) throws URISyntaxException {
        File targetDir = new File(getResource("ch01/dir").toURI());

        File[] files = targetDir.listFiles();
        Arrays.sort(files, (first, second) -> {
           if (first.isDirectory() && second.isFile())
               return -1;
           else if (first.isFile() && second.isDirectory())
               return 1;
           else
               return 0;
        });

        String[] expected = new String[] { "dir", "a.txt" };
        assert Arrays.equals(expected, Arrays.stream(files).map(File::getName).toArray());
    }

}
