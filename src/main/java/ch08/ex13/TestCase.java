package ch08.ex13;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Repeatable(TestCases.class)
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface TestCase {
    int[] params();
    int expected();
}
