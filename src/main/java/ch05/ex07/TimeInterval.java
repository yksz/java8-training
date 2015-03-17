package ch05.ex07;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class TimeInterval {

    private final LocalDateTime beginingDateTime;
    private final LocalDateTime endingDateTime;

    public TimeInterval(LocalDate date, LocalTime beginingTime, LocalTime endingTime) {
        Objects.requireNonNull(date, "date must not be null");
        Objects.requireNonNull(beginingTime, "beginingTime must not be null");
        Objects.requireNonNull(endingTime, "endingTime must not be null");
        if (beginingTime.equals(endingTime))
            throw new IllegalArgumentException("beginingTime must not equal to");
        if (beginingTime.isAfter(endingTime))
            throw new IllegalArgumentException("beginingTime must not be after endingTime");

        beginingDateTime = LocalDateTime.of(date, beginingTime);
        endingDateTime = LocalDateTime.of(date, endingTime);
    }

    public boolean conflicts(TimeInterval other) {
        return this.beginingDateTime.isBefore(other.endingDateTime)
                && this.endingDateTime.isAfter(other.beginingDateTime);
    }

}
