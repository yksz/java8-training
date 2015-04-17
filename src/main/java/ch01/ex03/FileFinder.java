package ch01.ex03;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

public class FileFinder {

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    public static void main(String[] args) throws URISyntaxException {
        File targetDir = new File(getResource("ch01/dir").toURI());
        String targetExt = "txt"; // エンクロージングスコープからキャプチャされる変数

        String[] files = targetDir.list((dir, name) -> {
            if (new File(name).isDirectory())
                return false;
            int index = name.lastIndexOf(".");
            if (index == -1)
                return false;
            else
                return name.substring(index + 1).equals(targetExt);
        });

        String[] expected = new String[] { "a.txt" };
        assert Arrays.equals(expected, files);
    }

}
