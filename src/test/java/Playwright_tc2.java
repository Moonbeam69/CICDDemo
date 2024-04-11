import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.*;
import org.junit.jupiter.api.*;
import java.util.regex.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class Playwright_tc2 {

    @Test
    public void tc1_FireFox() {

        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
            BrowserType browserType = playwright.firefox();

            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));
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

            //System.in.read();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void tc1_Chrome() {
        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
            BrowserType browserType = playwright.chromium();

            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));
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

            //System.in.read();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void tc1_Chrome2() {
        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
            BrowserType browserType = playwright.chromium();

            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));
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

            //System.in.read();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void tc1_Chrome3() {
        try (com.microsoft.playwright.Playwright playwright = com.microsoft.playwright.Playwright.create()) {
            BrowserType browserType = playwright.chromium();

            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));
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

            //System.in.read();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
