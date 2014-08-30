package ch01.ex01_08;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] names = { "Peter", "Paul", "Mary" };

        System.out.println(">> runners1");
        List<Runnable> runners1 = new ArrayList<>();
        for (String name : names)
            runners1.add(() -> System.out.println(name));
        runners1.forEach(runner -> runner.run());

        System.out.println(">> runners2");
        List<Runnable> runners2 = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            runners2.add(() -> System.out.println(name));
        }
        runners2.forEach(runner -> runner.run());
    }

}
