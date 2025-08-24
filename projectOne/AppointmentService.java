package appointment;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class AppointmentService {
    private Map<String, Appointment> data = new HashMap<>();

    public void addAppointment(Appointment a) {
        if (a == null) throw new IllegalArgumentException("null appt");
        String id = a.getAppointmentID();
        if (data.containsKey(id)) throw new IllegalArgumentException("duplicate id");
        data.put(id, a);
    }

    public void addAppointment(String id, Date date, String desc) {
        Appointment a = new Appointment(id, date, desc);
        addAppointment(a);
    }

    public void deleteAppointment(String id) {
        if (id == null) throw new IllegalArgumentException("null id");
        Appointment removed = data.remove(id);
        if (removed == null) throw new NoSuchElementException("not found");
    }

    public Appointment getAppointment(String id) {
        return data.get(id);
    }

    public int size() {
        return data.size();
    }
}
