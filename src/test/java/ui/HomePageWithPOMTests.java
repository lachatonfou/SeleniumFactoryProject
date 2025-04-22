package ui;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("POM")
public class HomePageWithPOMTests extends BaseTestForPOM{
    @Test
    void openHomePageTest() {
        HomePage homePage = new HomePage(driver);

        String actualTitle = homePage.getWebTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }
}
