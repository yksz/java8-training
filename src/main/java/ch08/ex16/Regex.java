package ch08.ex16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Regex {

    static class Address {
        private String city;
        private String state;
        private String zipCode;

        public Address(String city, String state, String zipCode) {
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
        }

        public String toString() {
            return city + ", " + state + " " + zipCode;
        }
    }

    static List<Address> parseAddress(List<String> strs) {
        String regex = "(?<city>[\\p{L} ]+),\\s*(?<state>[A-Z]{2})\\s+(?<zipCode>(\\d{5})|(\\d{5}-\\d{4}))";
        Pattern pattern = Pattern.compile(regex);

        List<Address> addresses = new ArrayList<Address>();
        for (String str : strs) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                String city = matcher.group("city");
                String state = matcher.group("state");
                String zipCode = matcher.group("zipCode");
                addresses.add(new Address(city, state, zipCode));
            }
        }
        return addresses;
    }

    public static void main(String[] args) {
        Address[] expected = { new Address("Minneapolis", "MN", "55416"),
                               new Address("Chicago", "IL", "60644-9998") };
        List<String> strs = Arrays.stream(expected).map(Address::toString).collect(Collectors.toList());
        List<Address> actual = parseAddress(strs);
        assert expected.length == actual.size();
        for (int i = 0; i < expected.length; i++) {
            assert expected[i].city.equals(actual.get(i).city);
            assert expected[i].state.equals(actual.get(i).state);
            assert expected[i].zipCode.equals(actual.get(i).zipCode);
        }
    }

}
