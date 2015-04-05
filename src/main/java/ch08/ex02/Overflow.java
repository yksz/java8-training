package ch08.ex02;

public class Overflow {

    public static void main(String[] args) {
        try {
            Math.negateExact(Integer.MIN_VALUE);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

}
