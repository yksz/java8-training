package ch03.ex02

import java.util.concurrent.locks.ReentrantLock

import spock.lang.Specification

class ReentrantLocksSpec extends Specification {

    ReentrantLock lock

    def setup() {
        lock = new ReentrantLock();
    }

    def "test withLock"() {
        setup:
        def wasLocked = false

        when:
        ReentrantLocks.withLock(lock, { wasLocked = lock.isLocked() } )

        then:
        wasLocked == true

        and:
        lock.isLocked() == false
    }

    def "test withLock when a exception is thrown"() {
        setup:
        def wasLocked = false

        when:
        ReentrantLocks.withLock(lock, { throw new Exception() } )

        then:
        thrown Exception

        and:
        lock.isLocked() == false
    }

}
