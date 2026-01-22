import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testConstructorAndGetters() {
        Product p = new Product("000001", "Pipeweed", "Long Bottom Leaf", 600.0);
        assertEquals("000001", p.getId());
        assertEquals("Pipeweed", p.getName());
        assertEquals("Long Bottom Leaf", p.getDesc());
        assertEquals(600.0, p.getCost());
    }

    @Test
    void testSetters() {
        Product p = new Product("000001", "Pipeweed", "Long Bottom Leaf", 600.0);
        p.setName("Lembas");
        p.setDesc("Elven Bread");
        p.setCost(200.0);
        assertEquals("Lembas", p.getName());
        assertEquals("Elven Bread", p.getDesc());
        assertEquals(200.0, p.getCost());
    }

    @Test
    void testToCSV_JSON_XML() {
        Product p = new Product("000001", "Pipeweed", "Long Bottom Leaf", 600.0);
        assertEquals("000001,Pipeweed,Long Bottom Leaf,600.00", p.toCSV());
        assertEquals("{\"id\":\"000001\",\"name\":\"Pipeweed\",\"desc\":\"Long Bottom Leaf\",\"cost\":600.00}", p.toJSON());
        assertEquals("<product><id>000001</id><name>Pipeweed</name><desc>Long Bottom Leaf</desc><cost>600.00</cost></product>", p.toXML());
    }

    @Test
    void testEquals() {
        Product p1 = new Product("000001", "Pipeweed", "Long Bottom Leaf", 600.0);
        Product p2 = new Product("000001", "Lembas", "Elven Bread", 200.0);
        Product p3 = new Product("000002", "Mithril", "Elven Armor", 1000.0);
        assertEquals(p1.getId(), p2.getId());
        assertNotEquals(p1.getId(), p3.getId());
    }
}
