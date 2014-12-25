package ch03.ex07;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class ComparatorUtilsTest {

    @Test
    public void testComparatorGeneratorDefault() {
        // setup:
        String[] actual = new String[] { "apple", "orange", "Apple", " grape" };

        // when:
        Arrays.sort(actual, ComparatorUtils.comparatorGenerator(null));

        // then:
        String[] expected = new String[] { " grape", "apple", "Apple", "orange" };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparatorGeneratorReverseOrder() {
        // setup:
        String[] actual = new String[] { "apple", "orange", "Apple", " grape" };

        // when:
        Set<Condition> condition = new TreeSet<>();
        condition.add(Condition.REVERSE_ORDER);
        Arrays.sort(actual, ComparatorUtils.comparatorGenerator(condition));

        // then:
        String[] expected = new String[] { "orange", "apple", "Apple", " grape" };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparatorGeneratorCaseSensitive() {
        // setup:
        String[] actual = new String[] { "apple", "orange", "Apple", " grape" };

        // when:
        Set<Condition> condition = new TreeSet<>();
        condition.add(Condition.CASE_SENSITIVE);
        Arrays.sort(actual, ComparatorUtils.comparatorGenerator(condition));

        // then:
        String[] expected = new String[] { " grape", "Apple", "apple", "orange" };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparatorGeneratorSpaceSensitive() {
        // setup:
        String[] actual = new String[] { "apple", "orange", "Apple", " grape" };

        // when:
        Set<Condition> condition = new TreeSet<>();
        condition.add(Condition.SPACE_SENSTIVE);
        Arrays.sort(actual, ComparatorUtils.comparatorGenerator(condition));

        // then:
        String[] expected = new String[] { "apple", "Apple", " grape", "orange" };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparatorGeneratorReverseOrderAndCaseSensitive() {
        // setup:
        String[] actual = new String[] { "Apple", "orange", "apple", " grape" };

        // when:
        Set<Condition> condition = new TreeSet<>();
        condition.add(Condition.REVERSE_ORDER);
        condition.add(Condition.CASE_SENSITIVE);
        Arrays.sort(actual, ComparatorUtils.comparatorGenerator(condition));

        // then:
        String[] expected = new String[] { "orange", "apple", "Apple", " grape" };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparatorGeneratorReverseOrderAndSpaceSensitive() {
        // setup:
        String[] actual = new String[] { "apple", "orange", "Apple", " grape" };

        // when:
        Set<Condition> condition = new TreeSet<>();
        condition.add(Condition.REVERSE_ORDER);
        condition.add(Condition.SPACE_SENSTIVE);
        Arrays.sort(actual, ComparatorUtils.comparatorGenerator(condition));

        // then:
        String[] expected = new String[] { "orange", " grape", "apple", "Apple" };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparatorGeneratorCaseSensitiveAndSpaceSensitive() {
        // setup:
        String[] actual = new String[] { "apple", "orange", "Apple", " grape" };

        // when:
        Set<Condition> condition = new TreeSet<>();
        condition.add(Condition.CASE_SENSITIVE);
        condition.add(Condition.SPACE_SENSTIVE);
        Arrays.sort(actual, ComparatorUtils.comparatorGenerator(condition));

        // then:
        String[] expected = new String[] { "Apple", "apple", " grape", "orange" };
        assertArrayEquals(expected, actual);
    }

}
