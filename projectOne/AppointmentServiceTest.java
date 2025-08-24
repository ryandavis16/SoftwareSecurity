package appointment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    private AppointmentService svc;

    private Date future(int days) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, days);
        return c.getTime();
    }

    @BeforeEach
    void setUp() {
        svc = new AppointmentService();
    }

    @Test
    void addWorks() {
        svc.addAppointment("A1", future(1), "x");
        assertNotNull(svc.getAppointment("A1"));
        assertEquals(1, svc.size());
    }

    @Test
    void addDuplicateFails() {
        svc.addAppointment("A2", future(1), "x");
        assertThrows(IllegalArgumentException.class, () ->
                svc.addAppointment("A2", future(2), "y"));
    }

    @Test
    void deleteWorks() {
        svc.addAppointment("A3", future(1), "x");
        svc.deleteAppointment("A3");
        assertNull(svc.getAppointment("A3"));
        assertEquals(0, svc.size());
    }

    @Test
    void deleteMissingFails() {
        assertThrows(NoSuchElementException.class, () -> svc.deleteAppointment("nope"));
    }
}
