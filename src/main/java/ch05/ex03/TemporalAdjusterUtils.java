package ch05.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

public class TemporalAdjusterUtils {

    public static TemporalAdjuster next(Predicate<LocalDate> condition) {
        return temporal -> {
            LocalDate date = (LocalDate) temporal;
            do {
                date = date.plusDays(1);
            } while (!condition.test(date));
            return date;
        };
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2014, 12, 12);
        LocalDate date = today.with(next(w -> w.getDayOfWeek().getValue() < 6));
        System.out.println(date);
    }

}
