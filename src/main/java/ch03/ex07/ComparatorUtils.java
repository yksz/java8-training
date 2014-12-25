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
        boolean isCaseSensitive = condition.contains(Condition.CASE_SENSITIVE);
        boolean isSpaceSensitive = condition.contains(Condition.SPACE_SENSTIVE);
        return (str1, str2) -> {
            if (isSpaceSensitive) {
                str1 = str1.replaceAll("\\s", "");
                str2 = str2.replaceAll("\\s", "");
            }
            int order = 1;
            if (isReverseOrder) {
                order = -1;
            }
            if (isCaseSensitive) {
                return str1.compareTo(str2) * order;
            } else {
                return str1.compareToIgnoreCase(str2) * order;
            }
        };
    }

}
