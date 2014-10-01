package ch01.ex01_02;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

public class Main {

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    public static void main(String[] args) throws URISyntaxException {
        File targetDir = new File(getResource("ch01/dir").toURI());

        File[] dirs1 = targetDir.listFiles(file -> file.isDirectory());
        File[] dirs2 = targetDir.listFiles(File::isDirectory);

        String[] expected = new String[] { "dir" };
        assert Arrays.equals(expected, Arrays.stream(dirs1).map(File::getName).toArray());
        assert Arrays.equals(expected, Arrays.stream(dirs2).map(File::getName).toArray());
    }

}
