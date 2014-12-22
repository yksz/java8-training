package ch05.ex12;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {

    private final List<Appointment> appointments;

    public Scheduler() {
        appointments = new ArrayList<>();
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        if (appointment != null)
            appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        if (appointment != null)
            appointments.remove(appointment);
    }

    public void notifyAppointments(Duration when) {
        notifyAppointments(when, ZonedDateTime.now());
    }

    public void notifyAppointments(Duration when, ZonedDateTime currentDateTime) {
        for (Appointment appointment : appointments) {
            if (appointment.hasNotified())
                continue;
            ZonedDateTime notifyingDateTime = appointment.getDateTime().minus(when);
            if (notifyingDateTime.isEqual(currentDateTime)
                    || notifyingDateTime.isAfter(currentDateTime)) {
                System.out.println(appointment);
                appointment.setHasNotified(true);
            }
        }
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        ZoneId appointmentZoneId = ZoneId.of("America/New_York"); // -05:00
        ZonedDateTime appointmentDateTime = ZonedDateTime.of(
                LocalDateTime.of(now, LocalTime.of(10, 0)), appointmentZoneId);
        Appointment appointment = new Appointment(appointmentDateTime, "Telephone meeting");
        ZoneId currentZoneId = ZoneId.of("Europe/Berlin"); // +01:00
        ZonedDateTime currentDateTime = ZonedDateTime.of(
                LocalDateTime.of(now, LocalTime.of(15, 0)), currentZoneId);
        Duration when = Duration.of(1, ChronoUnit.HOURS);

        Scheduler scheduler = new Scheduler();
        scheduler.addAppointment(appointment);
        scheduler.notifyAppointments(when, currentDateTime);
    }

}
