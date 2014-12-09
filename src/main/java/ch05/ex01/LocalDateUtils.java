package ch05.ex01;

import java.time.LocalDate;

public class LocalDateUtils {

    public static LocalDate getProgrammersDay(int year) {
        return LocalDate.ofYearDay(year, 256);
    }

}
