package PlaywrightTests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.*;
import org.junit.jupiter.api.*;

import java.util.regex.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;
import static org.junit.jupiter.api.Assertions.*;

@UsePlaywright
class Playwright_tc1 {

    static BrowserType browserType;

    @BeforeAll
    static void setup() {
        String browser = System.getProperty("browser");
        com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create();

        switch (browser) {
            case "chrome":
                BrowserType browserType = playwright.chromium();
                break;
            case "firefox":
                assertTrue(1==1);
                break;
            case "safari":
                assertTrue(1==1);
                break;
        }
    }
//    @Test
    void tc1_FireFox() {

        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
            BrowserType browserType = playwright.firefox();
            System.out.println("Hello world");

            try(Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true))) {
                BrowserContext context = browser.newContext();

                Page page = context.newPage();
                page.navigate("https://playwright.dev");

                //AxeResults accessibilityScanResults = new AxeBuilder(page).analyze();
                //assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations());

//            for (Rule r : accessibilityScanResults.getViolations()) {
//                System.out.println("===");
//                System.out.println(r.toString());
//            }

                // Expect a title "to contain" a substring.
                assertThat(page).hasTitle(Pattern.compile("Playwright"));
                System.out.println(page.title());

                page.locator("//html/body/div/div[2]/header/div/div/a").click();
                assertThat(page).hasTitle("Installation | Playwright");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
    void tc1_Chrome() {
        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
            BrowserType browserType = playwright.chromium();

            try(Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true))) {
                BrowserContext context = browser.newContext();

                Page page = context.newPage();
                page.navigate("https://playwright.dev");

                //AxeResults accessibilityScanResults = new AxeBuilder(page).analyze();
                //assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations());

//            for (Rule r : accessibilityScanResults.getViolations()) {
//                System.out.println("===");
//                System.out.println(r.toString());
//            }

                // Expect a title "to contain" a substring.
                assertThat(page).hasTitle(Pattern.compile("Playwright"));
                System.out.println(page.title());

                page.locator("//html/body/div/div[2]/header/div/div/a").click();
                assertThat(page).hasTitle("Installation | Playwright");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
    void tc1_Chrome2() {
        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
            BrowserType browserType = playwright.chromium();

            try(Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true))) {
                BrowserContext context = browser.newContext();

                Page page = context.newPage();
                page.navigate("https://playwright.dev");

                //AxeResults accessibilityScanResults = new AxeBuilder(page).analyze();
                //assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations());

//            for (Rule r : accessibilityScanResults.getViolations()) {
//                System.out.println("===");
//                System.out.println(r.toString());
//            }

                // Expect a title "to contain" a substring.
                assertThat(page).hasTitle(Pattern.compile("Playwright"));
                System.out.println(page.title());

                page.locator("//html/body/div/div[2]/header/div/div/a").click();
                assertThat(page).hasTitle("Installation | Playwright");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
    void tc1_Chrome3() {
        //com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create();
        //    BrowserType browserType = playwright.chromium();

            try(Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true))) {
                BrowserContext context = browser.newContext();

                Page page = context.newPage();
                page.navigate("https://playwright.dev");

                //AxeResults accessibilityScanResults = new AxeBuilder(page).analyze();
                //assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations());

//            for (Rule r : accessibilityScanResults.getViolations()) {
//                System.out.println("===");
//                System.out.println(r.toString());
//            }

                // Expect a title "to contain" a substring.
                assertThat(page).hasTitle(Pattern.compile("Playwright"));
                System.out.println(page.title());

                page.locator("//html/body/div/div[2]/header/div/div/a").click();
                assertThat(page).hasTitle("Installation | Playwright");
            }


    }
}
