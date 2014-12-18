package ch05.ex09;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId::of)
                .map(now::atZone)
                .filter(zdt -> Math.abs(zdt.getOffset().getTotalSeconds()) < 3600)
                .forEach(System.out::println);
    }

}
