package ch05.ex08;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId::of)
                .map(now::atZone)
                .forEach(System.out::println);
    }

}
