import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyAppTest {
    static String environment;

    @BeforeAll
    public static void setup() {
        environment = System.getProperty("environment");
    }
    @Test
    public void FirstAppDumbTest(TestInfo testInfo) {
        System.out.println("FirstAppDumbTest in " + environment);
        // debug: System.out.println("testinfo: " + testInfo.getTestMethod().get().getName());

        assertEquals(1, 1);
    }

    @Test
    public void SecondAppDumbTest() {
        System.out.println("SecondAppDumbTest in " + environment);
        assertEquals(1, 1);
    }

    @Test
    public void ThirdAppDumbTest() {
        System.out.println("ThirdAppDumbTest in " + environment);
        assertEquals(1, 1);
    }

    @Test
    public void FourthAppDumbTest() {
        System.out.println("FourthAppDumbTest in " + environment);
        assertEquals(1, 1);
    }
}
