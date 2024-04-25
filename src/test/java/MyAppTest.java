import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyAppTest {
    static String environment;

    @BeforeAll
    public static void setup() {
        environment = System.getProperty("environment");
    }
    @Test
    public void FirstAppDumbTest() {
        System.out.println(environment + ": ");
        assertEquals(1, 1);
    }

    @Test
    public void SecondAppDumbTest() {
        assertEquals(1, 1);

    }

    @Test
    public void ThirdAppDumbTest() {
        assertEquals(1, 1);
    }

    @Test
    public void FourthAppDumbTest() {

        assertEquals(1, 1);
    }
}
