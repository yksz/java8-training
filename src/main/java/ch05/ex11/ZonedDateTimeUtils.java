package ch05.ex11;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Objects;

public class ZonedDateTimeUtils {

    public static Duration calculateDuration(
            ZonedDateTime departureTime, ZonedDateTime arrivalTime) {
        Objects.requireNonNull(departureTime, "departureTime must not be null");
        Objects.requireNonNull(arrivalTime, "arrivalTime must not be null");
        return Duration.between(departureTime, arrivalTime);
    }

}
