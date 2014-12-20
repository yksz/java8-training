package ch05.ex10

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

import spock.lang.Specification

class ZonedDateTimeUtilsSpec extends Specification {

    def "test 'calculateArrivalTime'"() {
        def date = LocalDate.now()
        def departureZoneId = ZoneId.of("America/Los_Angeles"); // -08:00
        def arrivalZoneId = ZoneId.of("Europe/Berlin"); // +01:00
        def departureTime = ZonedDateTime.of(
                LocalDateTime.of(date, LocalTime.of(3, 5)), departureZoneId)
        def flightTime = Duration.of(650L, ChronoUnit.MINUTES);
        def arrivalTime = ZonedDateTime.of(
                LocalDateTime.of(date, LocalTime.of(22, 55)), arrivalZoneId)

        expect:
        ZonedDateTimeUtils.calculateArrivalTime(departureTime, flightTime, arrivalZoneId) == arrivalTime
    }

    def "test 'calculateArrivalTime' when each argument is null"() {
        def zonedDateTime = ZonedDateTime.now()
        def duration = Duration.ofHours(1)
        def zoneId = ZoneId.systemDefault()

        when:
        ZonedDateTimeUtils.calculateArrivalTime(null, duration, zoneId)

        then:
        thrown(NullPointerException)

        when:
        ZonedDateTimeUtils.calculateArrivalTime(zonedDateTime, null, zoneId)

        then:
        thrown(NullPointerException)

        when:
        ZonedDateTimeUtils.calculateArrivalTime(zonedDateTime, duration, null)

        then:
        thrown(NullPointerException)
    }

}
