package moduleThreeStone;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "John", "Smith", "1234567890", "123 Elm St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("002", "Jane", "Doe", "0987654321", "456 Oak Rd");
        service.addContact(contact);
        service.deleteContact("002");
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("002"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("003", "Mike", "Tyson", "1112223333", "789 Pine Ln");
        service.addContact(contact);
        service.updateFirstName("003", "Bob");
        service.updateLastName("003", "Lee");
        service.updatePhone("003", "4445556666");
        service.updateAddress("003", "999 Maple Ave");

        assertEquals("Bob", contact.getFirstName());
        assertEquals("Lee", contact.getLastName());
        assertEquals("4445556666", contact.getPhone());
        assertEquals("999 Maple Ave", contact.getAddress());
    }
}
