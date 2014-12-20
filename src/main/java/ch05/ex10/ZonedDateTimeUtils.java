package ch05.ex10;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

public class ZonedDateTimeUtils {

    public static ZonedDateTime calculateArrivalTime(
            ZonedDateTime departureTime, Duration flightTime, ZoneId arrivalZoneId) {
        Objects.requireNonNull(departureTime, "departureTime must not be null");
        Objects.requireNonNull(flightTime, "flightTime must not be null");
        Objects.requireNonNull(arrivalZoneId, "arrivalZoneId must not be null");
        return departureTime.plus(flightTime).withZoneSameInstant(arrivalZoneId);
    }

}
