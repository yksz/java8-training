package ch05.ex07

import java.time.LocalDate
import java.time.LocalTime

import spock.lang.Specification
import spock.lang.Unroll

class TimeIntervalSpec extends Specification {

    static def interval = { d, b, e -> new TimeInterval(d, b, e) }
    static def time = { h, m -> LocalTime.of(h, m) }

    def "test 'constructor' when each argument is null"() {
        when:
        new TimeInterval(null, time(10, 0), time(11, 0))

        then:
        thrown(NullPointerException)

        when:
        new TimeInterval(LocalDate.now(), null, time(11, 0))

        then:
        thrown(NullPointerException)

        when:
        new TimeInterval(LocalDate.now(), time(10, 0), null)

        then:
        thrown(NullPointerException)
    }

    def "test 'constructor' when beginingTime equals endingTime"() {
        when:
        new TimeInterval(LocalDate.now(), time(10, 0), time(10, 0))

        then:
        thrown(IllegalArgumentException)
    }

    def "test 'constructor' when beginingTime is after endingTime"() {
        when:
        new TimeInterval(LocalDate.now(), time(10, 0), time(9, 0))

        then:
        thrown(IllegalArgumentException)
    }

    @Unroll
    def "test 'conflicts' between #b1-#e1 and #b2-#e2"() {
        def date = LocalDate.now()

        expect:
        interval(date, b1, e1).conflicts(interval(date, b2, e2)) == result

        where:
        b1          | e1          | b2           | e2           || result
        time(10, 0) | time(11, 0) | time(10, 0)  | time(11, 00) || true
        time(10, 0) | time(11, 0) | time(10, 0)  | time(10, 30) || true
        time(10, 0) | time(11, 0) | time(10, 30) | time(11, 00) || true
        time(10, 0) | time(11, 0) | time(9, 0)   | time(10, 0)  || false
        time(10, 0) | time(11, 0) | time(11, 0)  | time(12, 0)  || false
    }

}
