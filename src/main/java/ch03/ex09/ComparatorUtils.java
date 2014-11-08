package ch03.ex09;

import java.lang.reflect.Field;
import java.util.Comparator;

public class ComparatorUtils {

    @SuppressWarnings("unchecked")
    public static Comparator<Object> lexicographicComparator(String... fieldNames) {
        if (fieldNames == null)
            throw new NullPointerException("fieldNames must not be null");

        return (obj1, obj2) -> {
            for (String fieldName : fieldNames) {
                Object field1 = getField(obj1, fieldName);
                Object field2 = getField(obj2, fieldName);
                int result = ((Comparable<Object>) field1).compareTo(field2);
                if (result != 0)
                    return result;
            }
            return 0;
        };
    }

    @SuppressWarnings("unchecked")
    private static <T> T getField(Object obj, String fieldName) {
        Class<?> clazz = obj.getClass();
        Field field;
        try {
            field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
