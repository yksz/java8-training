package ch05.ex11

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

import spock.lang.Specification

class ZonedDateTimeUtilsSpec extends Specification {

    def "test 'calculateDuration'"() {
        def date = LocalDate.now()
        def departureZoneId = ZoneId.of("Europe/Berlin"); // +01:00
        def arrivalZoneId = ZoneId.of("America/Los_Angeles"); // -08:00
        def departureTime = ZonedDateTime.of(
                LocalDateTime.of(date, LocalTime.of(14, 5)), departureZoneId)
        def arrivalTime = ZonedDateTime.of(
                LocalDateTime.of(date, LocalTime.of(16, 40)), arrivalZoneId)
        def flightTime = Duration.of(695L, ChronoUnit.MINUTES)

        expect:
        ZonedDateTimeUtils.calculateDuration(departureTime, arrivalTime) == flightTime
    }

    def "test 'calculateDuration' when each argument is null"() {
        def zonedDateTime = ZonedDateTime.now()

        when:
        ZonedDateTimeUtils.calculateDuration(null, zonedDateTime)

        then:
        thrown(NullPointerException)

        when:
        ZonedDateTimeUtils.calculateDuration(zonedDateTime, null)

        then:
        thrown(NullPointerException)
    }

}
