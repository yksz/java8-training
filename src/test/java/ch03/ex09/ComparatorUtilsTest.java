package ch03.ex09;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.Test;

public class ComparatorUtilsTest {

    private static class Man {
        private final String firstname;
        private final String lastname;
        private final Integer age;

        public Man(String firstname, String lastname, Integer age) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.age = age;
        }
    }

    private static class Woman {
        private final String firstname;
        private final String lastname;
        private final Integer age;

        public Woman(String firstname, String lastname, Integer age) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.age = age;
        }
    }

    @Test
    public void testLexicographicComparator() {
        // setup:
        Man man = new Man("John", "Smith", 20);
        Woman woman = new Woman("Jane", "Smith", 20);

        // when:
        Comparator<Object> comp = ComparatorUtils.lexicographicComparator("age", "lastname", "firstname");

        // then:
        assertTrue(comp.compare(man, woman) > 0);
        assertTrue(comp.compare(woman, man) < 0);
        assertTrue(comp.compare(man, man) == 0);
    }

    @Test(expected=NullPointerException.class)
    public void testLexicographicComparatorNull() {
        // when:
        Comparator<Object> comp = ComparatorUtils.lexicographicComparator(null);

        // then:
        comp.compare("", "");
    }

    public void testLexicographicComparatorEmpty() {
        // when:
        Comparator<Object> comp = ComparatorUtils.lexicographicComparator();

        // then:
        assertTrue(comp.compare("", "") == 0);
    }

}
