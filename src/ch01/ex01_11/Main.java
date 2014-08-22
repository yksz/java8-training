package ch01.ex01_11;

public class Main {

    public static void main(String[] args) {
        Impl1 impl1 = new Impl1();
        impl1.f1();
        impl1.f2();
        impl1.f3();
        impl1.f4();
        impl1.f5();

        Impl2 impl2 = new Impl2();
        impl2.f1();
        impl2.f2();
        impl2.f3();
    }

}

interface I {
    void f1();
    default void f2() { System.out.println("I"); }
    static void f3() { System.out.println("I"); }
    default void f4() { System.out.println("I"); }
    static void f5() { System.out.println("I"); }
    static void f6() { System.out.println("I"); }
}

interface J {
    void f1();
    void f2();
    void f3();
    default void f4() { System.out.println("J"); }
    default void f5() { System.out.println("J"); }
    static void f6() { System.out.println("J"); }
}

class Impl1 implements I, J {
    // Impl1 is not abstract and does not override abstract method f1() in I
    public void f1() { System.out.println("Impl1"); }
    // The default method f2() inherited from Main.I conflicts with another method inherited from Main.J
    public void f2() { System.out.println("Impl1"); }
    // Impl1 is not abstract and does not override abstract method f3() in I
    public void f3() { System.out.println("Impl1"); }
    // Duplicate default methods named f4 with the parameters () and () are inherited from the types Main.J and Main.I
    public void f4() { System.out.println("Impl1"); }
}

class S {
    public void f1() { System.out.println("S"); }
    public void f2() { System.out.println("S"); }
    public void f3() { System.out.println("S"); }
}

class Impl2 extends S implements I {}
