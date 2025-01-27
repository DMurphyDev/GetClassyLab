import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

public class PersonTest {

    @Test
    public void testFields() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1985);
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("12345", person.getID());
        assertEquals("Mr.", person.getTitle());
        assertEquals(1985, person.getYOB());
    }

    @Test
    public void testFullName() {
        Person person = new Person("Jane", "Smith", "67890", "Dr.", 1975);
        assertEquals("Jane Smith", person.fullName());
    }

    @Test
    public void testFormalName() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1985);
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    public void testGetAge() {
        Person person = new Person("Jane", "Doe", "54321", "Ms.", 1990);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        assertEquals(currentYear - 1990, person.getAge());
    }

    @Test
    public void testGetAgeForSpecificYear() {
        Person person = new Person("Mark", "Spencer", "99887", "Prof.", 1965);
        assertEquals(35, person.getAge(2000));
    }

    @Test
    public void testToCSV() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1985);
        assertEquals("John,Doe,12345,Mr.,1985", person.toCSV());
    }

    @Test
    public void testToJSON() {
        Person person = new Person("Jane", "Smith", "67890", "Dr.", 1975);
        assertEquals("{\"firstName\":\"Jane\",\"lastName\":\"Smith\",\"ID\":\"67890\",\"title\":\"Dr.\",\"YOB\":1975}", person.toJSON());
    }

    @Test
    public void testToXML() {
        Person person = new Person("Mark", "Spencer", "99887", "Prof.", 1965);
        assertEquals("<Person><firstName>Mark</firstName><lastName>Spencer</lastName><ID>99887</ID><title>Prof.</title><YOB>1965</YOB></Person>", person.toXML());
    }
}
