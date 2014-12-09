package ch05.ex01

import java.time.LocalDate

import spock.lang.Specification
import spock.lang.Unroll

class LocalDateUtilsSpec extends Specification {

    @Unroll
    def "test getProgrammersDay of #year"() {
        expect:
        LocalDateUtils.getProgrammersDay(year) == LocalDate.of(y, m, d)

        where:
        year || y    | m | d
        2015 || 2015 | 9 | 13
        2016 || 2016 | 9 | 12 // leap year
    }

}
