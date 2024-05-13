import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.*;
import org.junit.jupiter.api.*;

import java.util.regex.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

@UsePlaywright
class Playwright1Test {

    static BrowserType browserType;
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(MyApp.class);
    
    @BeforeAll
    static void setup() {
        String browser = System.getProperty("browser");
        com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create();

        switch (browser) {
            case "chrome":
                browserType = playwright.chromium();
                break;
            case "firefox":
                browserType = playwright.firefox();
                break;
            case "safari":
                browserType = playwright.webkit();
                break;
            default:
                logger.info("No browser configured with " + browser);
        }
    }

    @Test
    void tc1_Navigation(TestInfo testInfo) {
        long startTime = System.currentTimeMillis();

        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
            BrowserType browserType = playwright.firefox();

            try(Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true))) {
                BrowserContext context = browser.newContext();

                Page page = context.newPage();
                page.navigate("https://playwright.dev");

                //AxeResults accessibilityScanResults = new AxeBuilder(page).analyze();
                //assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations());

//            for (Rule r : accessibilityScanResults.getViolations()) {
//                logger.info("===");
//                logger.info(r.toString());
//            }

                // Expect a title "to contain" a substring.
                assertThat(page).hasTitle(Pattern.compile("Playwright"));
                logger.info(page.title());

                page.locator("//html/body/div/div[2]/header/div/div/a").click();
                assertThat(page).hasTitle("Installation | Playwright");
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void tc2_Navigation(TestInfo testInfo) {

        long startTime = System.currentTimeMillis();

        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
            BrowserType browserType = playwright.chromium();

            try(Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true))) {
                BrowserContext context = browser.newContext();

                Page page = context.newPage();
                page.navigate("https://playwright.dev");

                //AxeResults accessibilityScanResults = new AxeBuilder(page).analyze();
                //assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations());

//            for (Rule r : accessibilityScanResults.getViolations()) {
//                logger.info("===");
//                logger.info(r.toString());
//            }

                // Expect a title "to contain" a substring.
                assertThat(page).hasTitle(Pattern.compile("Playwright"));
                logger.info(page.title());

                page.locator("//html/body/div/div[2]/header/div/div/a").click();
                assertThat(page).hasTitle("Installation | Playwright");
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void tc3_Navigation(TestInfo testInfo) {
        long startTime = System.currentTimeMillis();

        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
            BrowserType browserType = playwright.chromium();

            try(Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true))) {
                BrowserContext context = browser.newContext();

                Page page = context.newPage();
                page.navigate("https://playwright.dev");

                //AxeResults accessibilityScanResults = new AxeBuilder(page).analyze();
                //assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations());

//            for (Rule r : accessibilityScanResults.getViolations()) {
//                logger.info("===");
//                logger.info(r.toString());
//            }

                // Expect a title "to contain" a substring.
                assertThat(page).hasTitle(Pattern.compile("Playwright"));
                logger.info(page.title());

                page.locator("//html/body/div/div[2]/header/div/div/a").click();
                assertThat(page).hasTitle("Installation | Playwright");
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void tc4_Navigation(TestInfo testInfo) {

        long startTime = System.currentTimeMillis();

        try(Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true))) {
            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate("https://playwright.dev");

            //AxeResults accessibilityScanResults = new AxeBuilder(page).analyze();
            //assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations());

//            for (Rule r : accessibilityScanResults.getViolations()) {
//                logger.info("===");
//                logger.info(r.toString());
//            }

            // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
            logger.info(page.title());

            page.locator("//html/body/div/div[2]/header/div/div/a").click();
            assertThat(page).hasTitle("Installation | Playwright");


            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
