package ch01.ex11;

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
    // [Error] The type Impl1 must implement the inherited abstract method J.f1()
    public void f1() { System.out.println("Impl1"); }
    // [Error] The default method f2() inherited from I conflicts with another method inherited from J
    public void f2() { System.out.println("Impl1"); }
    // [Error] The type Impl1 must implement the inherited abstract method J.f3()
    public void f3() { System.out.println("Impl1"); }
    // [Error] Duplicate default methods named f4 with the parameters () and () are inherited from the types J and I
    public void f4() { System.out.println("Impl1"); }
}

class S {
    public void f1() { System.out.println("S"); }
    public void f2() { System.out.println("S"); }
    public void f3() { System.out.println("S"); }
}

class Impl2 extends S implements I {}
