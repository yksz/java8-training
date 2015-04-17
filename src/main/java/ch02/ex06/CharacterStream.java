package ch02.ex06;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterStream {

    static Stream<Character> characterStream(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }

    public static void main(String[] args) {
        Character[] expected = new Character[] { 'H', 'e', 'l', 'l', 'o' };
        assert Arrays.equals(expected, characterStream("Hello").toArray());
    }

}
