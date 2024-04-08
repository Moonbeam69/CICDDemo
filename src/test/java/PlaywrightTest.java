import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.regex.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class PlaywrightTest {

    @Test
    public void runthistest() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));
            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate("https://playwright.dev");

            // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
            System.out.println(page.title());

            page.locator("//html/body/div/div[2]/header/div/div/a").click();
            assertThat(page).hasTitle("Installation | Playwright");

            System.in.read();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
