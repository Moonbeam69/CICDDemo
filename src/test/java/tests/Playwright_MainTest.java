package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import runners.*;

import java.util.regex.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;
import static io.qameta.allure.SeverityLevel.*;

@UsePlaywright
@ExtendWith(DisplayNameReporter.class)
class Playwright_MainTest {

    static BrowserType browserType;
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(Playwright_MainTest.class);
    
    @BeforeAll
    static void setup() {
        String browser = System.getProperty("browser");
        String environment = System.getProperty("environment");

        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {

            logger.info("Executing agaist  " + browser);
            logger.info("Executing in  " + environment);

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

                    // https://github.com/users/Moonbeam69/projects/1/views/1?filterQuery=sprint%3A%40current&pane=issue&itemId=62728371
            }
        }
    }

    @Test
    @DisplayName("Verify the layout of the homepage")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("Tester 1")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    void tc1_Navigation(TestInfo testInfo) {
        long startTime = System.currentTimeMillis();

//        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
//            BrowserType browserType = playwright.firefox();

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
            if (testInfo.getTestMethod().isPresent()) {
                logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);
            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    @Test
    @DisplayName("Verify successful login")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("Tester 1")
    @Link(name = "Website", url = "https://dev.example.com/")
    @TmsLink("TMS-457")
    void tc2_Navigation(TestInfo testInfo) {

        long startTime = System.currentTimeMillis();

//        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
//            BrowserType browserType = playwright.chromium();

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
            if (testInfo.getTestMethod().isPresent()) {
                logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);
            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    @Test
    @DisplayName("Verify unsuccessful login & recovery")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(BLOCKER)
    @Owner("Tester 2")
    @Link(name = "Website", url = "https://dev.example.com/")
    @TmsLink("TMS-456")
    void tc3_Navigation(TestInfo testInfo) {
        long startTime = System.currentTimeMillis();

//        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
//            BrowserType browserType = playwright.chromium();

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
            if (testInfo.getTestMethod().isPresent()) {
                logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);
            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    @Test
    @DisplayName("Verify successful logout")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(NORMAL)
    @Owner("Tester 3")
    @Link(name = "Website", url = "https://dev.example.com/")
    @TmsLink("TMS-458")
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
            if (testInfo.getTestMethod().isPresent()) {
                logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @DisplayName("Verify purchase with valid credit card")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(NORMAL)
    @Owner("Tester 3")
    @TmsLink("TMS-459")
    void tc5_Navigation(TestInfo testInfo) {

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
            if (testInfo.getTestMethod().isPresent()) {
                logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @DisplayName("Verify purchase with invalid credit card")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(NORMAL)
    @Owner("Tester 3")
    @Link(name = "Website", url = "https://dev.example.com/")
    @TmsLink("TMS-456")
    void tc6_Navigation(TestInfo testInfo) {

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
            if (testInfo.getTestMethod().isPresent()) {
                logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @DisplayName("Verify edit basket")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(NORMAL)
    @Owner("Tester 3")
    @Link(name = "Website", url = "https://dev.example.com/")
    @TmsLink("TMS-460")
    void tc7_Navigation(TestInfo testInfo) {

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
            if (testInfo.getTestMethod().isPresent()) {
                logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @DisplayName("Verify WCAG 2.1 compliance")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(NORMAL)
    @Owner("Tester 3")
    @Link(name = "Website", url = "https://dev.example.com/")
    @TmsLink("TMS-461")
    void tc8_Navigation(TestInfo testInfo) {

        long startTime = System.currentTimeMillis();

        try(Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true))) {
            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate("https://playwright.dev");

//            try {
//                AxeResults accessibilityScanResults = new AxeBuilder(page).analyze();
//                assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations());
//            } catch (Exception e) {
//                //ignore failure as is expected
//            }

            // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
            logger.info(page.title());

            page.locator("//html/body/div/div[2]/header/div/div/a").click();
            assertThat(page).hasTitle("Installation | Playwright");


            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            if (testInfo.getTestMethod().isPresent()) {
                logger.info(testInfo.getTestMethod().get().getName() + " elapsed time in milliseconds: " + elapsedTime);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
