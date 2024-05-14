package tests;

import com.microsoft.playwright.*;
import runners.*;

import java.util.regex.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

class PlaywrightTest4BrowserStack {

    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(PlaywrightTest4BrowserStack.class);
    

    @PlaywrightTest
    void tc1_Navigation(Browser browser) {
        long startTime = System.currentTimeMillis();

        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.firefox();

            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate("https://playwright.dev");

            // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
            logger.info(page.title());

            page.locator("//html/body/div/div[2]/header/div/div/a").click();
            assertThat(page).hasTitle("Installation | Playwright");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        browser.close();

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        logger.info("Elapsed time in milliseconds: " + elapsedTime);

    }

    @PlaywrightTest
    void tc2_Navigation(Browser browser) {

        long startTime = System.currentTimeMillis();

        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();

            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate("https://playwright.dev");

            // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
            logger.info(page.title());

            page.locator("//html/body/div/div[2]/header/div/div/a").click();
            assertThat(page).hasTitle("Installation | Playwright");

            browser.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        logger.info("Elapsed time in milliseconds: " + elapsedTime);


    }

    @PlaywrightTest
    void tc3_Navigation(Browser browser) {

        long startTime = System.currentTimeMillis();

        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();

            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate("https://playwright.dev");

            // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
            logger.info(page.title());

            page.locator("//html/body/div/div[2]/header/div/div/a").click();
            assertThat(page).hasTitle("Installation | Playwright");

            browser.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        logger.info("Elapsed time in milliseconds: " + elapsedTime);


    }

    @PlaywrightTest
    void tc4_Navigation(Browser browser) {

        long startTime = System.currentTimeMillis();

        try (Playwright playwright = Playwright.create()) {

            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate("https://playwright.dev");

            // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
            logger.info(page.title());

            page.locator("//html/body/div/div[2]/header/div/div/a").click();
            assertThat(page).hasTitle("Installation | Playwright");

            browser.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        logger.info("Elapsed time in milliseconds: " + elapsedTime);

    }
}
