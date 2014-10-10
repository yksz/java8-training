package ch03.ex03

import spock.lang.Specification

class AssertionSpec extends Specification {

    def "test asserts when a condition is true"() {
        when:
        Assertion.setEnabled(true)

        and:
        def a = 'a'
        Assertion.asserts({ a != null }, { 'a is null' })

        then:
        notThrown AssertionError
    }

    def "test asserts when a condition is false"() {
        when:
        Assertion.setEnabled(true)

        and:
        def a
        Assertion.asserts({ a != null }, { 'a is null' })

        then:
        AssertionError error = thrown()
        error.message == 'a is null'
    }

    def "test asserts when the assertion is disabled"() {
        when:
        Assertion.setEnabled(false)

        and:
        Assertion.asserts({ false }, {})

        then:
        notThrown AssertionError
    }

}
