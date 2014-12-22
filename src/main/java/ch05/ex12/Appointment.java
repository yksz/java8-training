package ch05.ex12;

import java.time.ZonedDateTime;

public class Appointment {

    private final ZonedDateTime dateTime;
    private String message;
    private boolean hasNotified;

    public Appointment(ZonedDateTime dateTime, String message) {
        this.dateTime = dateTime;
        this.message = message;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean hasNotified() {
        return hasNotified;
    }

    public void setHasNotified(boolean hasNotified) {
        this.hasNotified = hasNotified;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Appointment [dateTime=");
        builder.append(dateTime);
        builder.append(", message=");
        builder.append(message);
        builder.append("]");
        return builder.toString();
    }

}
