package com.example.demo_lektion;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Tag("e2e")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorE2ETests {
    @LocalServerPort
    int port;

    Playwright playwright;
    Browser browser;

    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    void closeBrowser() {
        browser.close();
        playwright.close();
    }

    private String url(String path) {
        return "http://localhost:" + port + path;
    }

    @Test
    @DisplayName("renders the computed sum on the page")
    void rendersSum() {
        Page page = browser.newPage();
        page.navigate(url("/?a=2&b=3"));
        assertThat(page.locator("#sum")).hasText("5");
    }

    @Test
    @DisplayName("echoes both inputs on the page")
    void echoesInputs() {
        Page page = browser.newPage();
        page.navigate(url("/?a=7&b=11"));
        assertThat(page.locator("#a")).hasText("7");
        assertThat(page.locator("#b")).hasText("11");
    }

    @Test
    @DisplayName("page has the expected heading")
    void hasHeading() {
        Page page = browser.newPage();
        page.navigate(url("/"));
        assertThat(page.locator("h1")).hasText("Calculator");
    }
}
