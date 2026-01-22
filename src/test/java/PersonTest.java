import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    void testConstructorAndFullName() {
        Person p = new Person("000001", "Bilbo", "Baggins", "Esq.", 1060);
        Assertions.assertEquals("Bilbo Baggins", p.fullName());
    }

    @Test
    void testFormalName() {
        Person p = new Person("000002", "Frodo", "Baggins", "Esq.", 1120);
        Assertions.assertEquals("Esq. Frodo Baggins", p.formalName());
    }

    @Test
    void testToCSV() {
        Person p = new Person("000003", "Samwise", "Gamgee", "Esq.", 1125);
        Assertions.assertEquals("000003,Samwise,Gamgee,Esq.,1125", p.toCSV());
    }

    @Test
    void testEquals() {
        Person p1 = new Person("000004", "Pippin", "Took", "Esq.", 1126);
        Person p2 = new Person("000004", "Peregrin", "Took", "Esq.", 1126);
        assertEquals(p1, p2);
    }
}