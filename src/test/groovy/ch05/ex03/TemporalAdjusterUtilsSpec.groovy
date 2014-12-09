package ch05.ex03

import java.time.LocalDate

import spock.lang.Specification
import spock.lang.Unroll

class TemporalAdjusterUtilsSpec extends Specification {

    @Unroll
    def "test next of #y1-#m1-#d1"() {
        def next = TemporalAdjusterUtils.&next
        def adjuster = { w -> w.getDayOfWeek().getValue() < 6 }

        expect:
        LocalDate.of(y1, m1, d1).with(next(adjuster)) == LocalDate.of(y2, m2, d2)

        where:
        y1   | m1 | d1 || y2   | m2 | d2
        2015 |  1 |  1 || 2015 |  1 |  2
        2015 |  1 |  3 || 2015 |  1 |  5 // weekend
    }

}
