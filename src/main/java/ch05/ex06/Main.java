package ch05.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate begin = LocalDate.of(1901, 1, 13);
        LocalDate end = LocalDate.of(2000, 12, 13);
        for (LocalDate date = begin; !date.equals(end); date = date.plusMonths(1))
            if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY))
                System.out.println(date);
    }

}
