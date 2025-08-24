package moduleThreeStone;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContact() {
        Contact contact = new Contact("001", "John", "Smith", "1234567890", "123 Elm St");
        assertEquals("001", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elm St", contact.getAddress());
    }

    @Test
    public void testNullIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Smith", "1234567890", "123 Elm St");
        });
    }

    @Test
    public void testLongFirstNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "TooLongFirstName", "Smith", "1234567890", "123 Elm St");
        });
    }
}
