package ch05.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Cal {

    static void showCalendar(int month, int year) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());
        int dayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();

        StringBuilder sb = new StringBuilder();
        for (int i = DayOfWeek.MONDAY.getValue(); i < dayOfWeek; i++)
            sb.append("   ");
        for (LocalDate date = firstDayOfMonth; !date.equals(lastDayOfMonth); date = date.plusDays(1)) {
            if (date.getDayOfMonth() < 10)
                sb.append(" ");
            sb.append(date.getDayOfMonth());
            sb.append(" ");
            if (date.getDayOfWeek().getValue() == DayOfWeek.SUNDAY.getValue())
                sb.append("\n");
        }
        sb.append(lastDayOfMonth.getDayOfMonth());
        System.out.println(sb);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("usage: java Cal <month> <year>");
            System.exit(1);
        }
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        showCalendar(month, year);
    }

}
