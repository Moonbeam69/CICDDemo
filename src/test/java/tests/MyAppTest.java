package tests;

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
        System.out.println("Unit Test #1");
        // debug: System.out.println("testinfo: " + testInfo.getTestMethod().get().getName());

        assertEquals(1, 1);
    }

    @Test
    public void SecondAppDumbTest() {
        System.out.println("Unit Test #2");
        assertEquals(1, 1);
    }

    @Test
    public void ThirdAppDumbTest() {
        System.out.println("Unit Test #3");
        assertEquals(1, 1);
    }

    @Test
    public void FourthAppDumbTest() {
        System.out.println("Unit Test #4");
        assertEquals(1, 1);
    }
}
