
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreationValid() {
        Task task = new Task("123", "Test Task", "This is a test task.");
        assertEquals("123", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test task.", task.getDescription());
    }

    @Test
    public void testSetName() {
        Task task = new Task("123", "Test Task", "Desc");
        task.setName("Updated Name");
        assertEquals("Updated Name", task.getName());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task("123", "Test Task", "Desc");
        task.setDescription("Updated Description");
        assertEquals("Updated Description", task.getDescription());
    }

    @Test
    public void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", null, "Desc");
        });
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Name", null);
        });
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name", "Desc");
        });
    }
}
