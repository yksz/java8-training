package ch08.ex13;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface TestCases {
    TestCase[] value();
}
