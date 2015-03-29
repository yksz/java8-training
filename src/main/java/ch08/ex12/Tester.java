package ch08.ex12;

import java.lang.reflect.Method;

public class Tester {

    static void test(TestCase testCase, Class<?> clazz, Method method) throws Exception {
        int[] params = testCase.params();
        int expected = testCase.expected();
        Object obj = clazz.newInstance();
        Object result = method.invoke(obj, (Object[]) toIntegerArray(params));
        assertTrue("FAILED: " + method, result.equals(expected));
    }

    static Integer[] toIntegerArray(int[] intArray) {
        Integer[] integerArray = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++)
            integerArray[i] = intArray[i];
        return integerArray;
    }

    static void assertTrue(String message, boolean condition) {
        if (!condition)
            System.err.println(message);
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ch08.ex12.Calculator");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            TestCase testCase = method.getAnnotation(TestCase.class);
            if (testCase != null)
                test(testCase, clazz, method);
        }
    }

}
