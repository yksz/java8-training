package ch03.ex07;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class ComparatorUtils {

    public static Comparator<String> comparatorGenerator(Set<Condition> condition) {
        if (condition == null) {
            condition = Collections.emptySet();
        }
        boolean isReverseOrder = condition.contains(Condition.REVERSE_ORDER);
        boolean isCaseInsensitive = condition.contains(Condition.CASE_INSENSITIVE);
        boolean isWhitespaceExclusion = condition.contains(Condition.WHITESPACE_EXCLUSION);
        return (str1, str2) -> {
            if (isWhitespaceExclusion) {
                str1 = str1.trim();
                str2 = str2.trim();
            }
            int order = 1;
            if (isReverseOrder) {
                order = -1;
            }
            if (isCaseInsensitive) {
                return str1.compareToIgnoreCase(str2) * order;
            } else {
                return str1.compareTo(str2) * order;
            }
        };
    }

}
