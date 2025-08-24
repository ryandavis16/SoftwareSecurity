package appointment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentTest {

    private Date future(int days) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, days);
        return c.getTime();
    }

    @Test
    void makesGoodAppointment() {
        Date d = future(1);
        Appointment a = new Appointment("ID1", d, "checkup");
        assertEquals("ID1", a.getAppointmentID());
        assertEquals("checkup", a.getDescription());
        assertEquals(d, a.getAppointmentDate());
    }

    @Test
    void badId() {
        Date d = future(1);
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, d, "ok"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("01234567890", d, "ok"));
    }

    @Test
    void badDate() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("ID2", null, "ok"));

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -1);
        Date past = c.getTime();
        assertThrows(IllegalArgumentException.class, () -> new Appointment("ID3", past, "ok"));
    }

    @Test
    void badDesc() {
        Date d = future(1);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("ID4", d, null));
        String longOne = "x".repeat(51);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("ID5", d, longOne));
    }

    @Test
    void canChangeDateAndDesc() {
        Appointment a = new Appointment("ID6", future(2), "hi");
        a.setDescription("new");
        assertEquals("new", a.getDescription());

        Date later = future(5);
        a.setAppointmentDate(later);
        assertEquals(later, a.getAppointmentDate());
    }
}
