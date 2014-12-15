package ch03.ex01

import java.util.logging.Level
import java.util.logging.Logger

import spock.lang.Specification

class LoggersSpec extends Specification {

    Logger logger

    def setup() {
        logger = Logger.getLogger('test')
    }

    def "test 'logIf' when trigger is true"() {
        setup:
        def msg = 'eval'
        def out = []

        when:
        Loggers.logIf(logger, Level.INFO, { true }, { out << msg; msg })

        then:
        out == [msg]
    }

    def "test 'logIf' when trigger is false"() {
        setup:
        def msg = 'eval'
        def out = []

        when:
        Loggers.logIf(logger, Level.INFO, { false }, { out << msg; msg })

        then:
        out == []
    }

}
