package appointment;

import java.util.Date;

public class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentID, Date appointmentDate, String description) {
        if (appointmentID == null) throw new IllegalArgumentException("id null");
        if (appointmentID.length() > 10) throw new IllegalArgumentException("id too long");

        if (appointmentDate == null) throw new IllegalArgumentException("date null");
        if (appointmentDate.before(new Date())) throw new IllegalArgumentException("date in past");

        if (description == null) throw new IllegalArgumentException("desc null");
        if (description.length() > 50) throw new IllegalArgumentException("desc too long");

        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) throw new IllegalArgumentException("date null");
        if (appointmentDate.before(new Date())) throw new IllegalArgumentException("date in past");
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        if (description == null) throw new IllegalArgumentException("desc null");
        if (description.length() > 50) throw new IllegalArgumentException("desc too long");
        this.description = description;
    }
}
