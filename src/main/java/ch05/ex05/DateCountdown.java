package ch05.ex05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateCountdown {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("usage: <year> <month> <day of month>");
            System.exit(1);
        }
        int year = Integer.valueOf(args[0]);
        int month = Integer.valueOf(args[1]);
        int dayOfMonth = Integer.valueOf(args[2]);
        LocalDate birthday = LocalDate.of(year, month, dayOfMonth);
        LocalDate today = LocalDate.now();
        System.out.println(birthday.until(today, ChronoUnit.DAYS));
    }

}
