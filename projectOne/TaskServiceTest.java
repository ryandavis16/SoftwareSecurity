
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService service;

    @BeforeEach
    public void setUp() {
        service = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("1", "Task1", "Description1");
        service.addTask(task);
        assertEquals(task, service.getTask("1"));
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("2", "Task2", "Description2");
        service.addTask(task);
        service.deleteTask("2");
        assertNull(service.getTask("2"));
    }

    @Test
    public void testUpdateTaskName() {
        Task task = new Task("3", "Task3", "Description3");
        service.addTask(task);
        service.updateTaskName("3", "Updated");
        assertEquals("Updated", service.getTask("3").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        Task task = new Task("4", "Task4", "Description4");
        service.addTask(task);
        service.updateTaskDescription("4", "New Description");
        assertEquals("New Description", service.getTask("4").getDescription());
    }

    @Test
    public void testAddDuplicateTaskId() {
        Task task1 = new Task("5", "Task5", "Desc");
        Task task2 = new Task("5", "Task5", "Desc");
        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }
}
