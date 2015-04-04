package ch08.ex09;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Converter {

    public static Stream<String> toStream(Scanner scanner) {
        Iterator<String> iter = new Iterator<String>() {
            String nextLine = null;

            @Override
            public boolean hasNext() {
                if (nextLine != null) {
                    return true;
                } else {
                    try {
                        nextLine = scanner.nextLine();
                        return true;
                    } catch (NoSuchElementException e) {
                        return false;
                    }
                }
            }

            @Override
            public String next() {
                if (nextLine != null || hasNext()) {
                    String line = nextLine;
                    nextLine = null;
                    return line;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    public static void main(String[] args) {
        String[] expected = { "line1", "line2", "line3" };
        String source = String.join("\n", expected);
        Scanner scanner = new Scanner(source);
        assert Arrays.equals(expected, toStream(scanner).toArray());
        scanner.close();
    }

}
