package ch05.ex05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1999, 1, 1);
        LocalDate today = LocalDate.now();
        System.out.println(birthday.until(today, ChronoUnit.DAYS));
    }

}
