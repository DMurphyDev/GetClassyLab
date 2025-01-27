import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testFields() {
        Product product = new Product("Laptop", "High-performance laptop", "A123", 1299.99);
        assertEquals("Laptop", product.getName());
        assertEquals("High-performance laptop", product.getDescription());
        assertEquals("A123", product.getID());
        assertEquals(1299.99, product.getCost(), 0.01);
    }

    @Test
    public void testSetters() {
        Product product = new Product("Laptop", "High-performance laptop", "A123", 1299.99);
        product.setName("Desktop");
        product.setDescription("Gaming desktop");
        product.setCost(1999.99);

        assertEquals("Desktop", product.getName());
        assertEquals("Gaming desktop", product.getDescription());
        assertEquals(1999.99, product.getCost(), 0.01);
    }

    @Test
    public void testToCSV() {
        Product product = new Product("Laptop", "High-performance laptop", "A123", 1299.99);
        assertEquals("Laptop,High-performance laptop,A123,1299.99", product.toCSV());
    }

    @Test
    public void testToJSON() {
        Product product = new Product("Phone", "Smartphone with 5G", "B456", 799.99);
        assertEquals("{\"name\":\"Phone\",\"description\":\"Smartphone with 5G\",\"ID\":\"B456\",\"cost\":799.99}", product.toJSON());
    }

    @Test
    public void testToXML() {
        Product product = new Product("Headphones", "Noise-cancelling headphones", "C789", 199.99);
        assertEquals("<Product><name>Headphones</name><description>Noise-cancelling headphones</description><ID>C789</ID><cost>199.99</cost></Product>", product.toXML());
    }
}
