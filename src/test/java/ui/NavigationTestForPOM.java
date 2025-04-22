package ui;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import pageObjects.NavigationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageObjects.HomePage.BASE_URL;

@Feature("POM")
public class NavigationTestForPOM extends BaseTestForPOM {
    @Test
    void openNavigationFormTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();
        WebElement title = navigationPage.getTitle();
        String navFormUrl = navigationPage.getUrl();
        navigationPage.clickNextButton();
        Thread.sleep(2000);

        assertEquals(BASE_URL + navFormUrl, currentUrl);
        assertEquals("Navigation example", title.getText());
    }
}
