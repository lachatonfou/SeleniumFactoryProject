package ui.selenide;

import org.junit.jupiter.api.BeforeEach;
import selenide.pages.HomePage;
import selenide.pages.WebFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static pageObjects.HomePage.BASE_URL;
import static com.codeborne.selenide.Condition.value;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelenideTests {

    HomePage homePage;

    @BeforeEach
    void setup() {
        homePage = new HomePage();
    }

    @Test
    void openHomePageTest() {
        //HomePage homePage = new HomePage();
        homePage.open();

        assertEquals(BASE_URL, homePage.getCurrentUrl());
        //assertEquals(BASE_URL, url());
    }

    @Test
    void openWebFormPageTest() {
        //HomePage homePage = new HomePage();
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        assertEquals(BASE_URL + webFormPage.getWebFormExpectedUrl(), webFormPage.getCurrentUrl());
        assertEquals("Hands-On Selenium WebDriver with Java", webFormPage.getWebTitle());
    }

    @Test
    void readonlyTextTest() {
        //HomePage homePage = new HomePage();
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.getReadonlyInput().shouldHave(value("Readonly input"));
    }
}
