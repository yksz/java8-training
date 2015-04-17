package ch05.ex02;

import java.time.LocalDate;

public class LocalDateAdder {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2000, 2, 29);
        assert date.plusYears(1).equals(LocalDate.of(2001, 2, 28));
        assert date.plusYears(4).equals(LocalDate.of(2004, 2, 29));
        LocalDate result = date;
        for (int i = 0; i < 4; i++)
            result = result.plusYears(1);
        assert result.equals(LocalDate.of(2004, 2, 28));
    }

}
