package ch08.ex07;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsFirst;
import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;

import java.util.Arrays;
import java.util.Comparator;

public class Order {

    public static void main(String[] args) {
        Integer[] unsorted = { 1, 3, null, 2 };

        Integer[] expected = unsorted.clone();
        Comparator<Integer> comparator = nullsFirst(naturalOrder());
        Arrays.sort(expected, comparator.reversed());

        Integer[] actual = unsorted.clone();
        Arrays.sort(actual, nullsLast(reverseOrder()));

        assert Arrays.equals(expected, actual);
    }

}
