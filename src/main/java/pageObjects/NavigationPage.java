package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationPage extends BasePage {
    private static final String NAV_FORM_URL = "navigation1.html";

    private WebElement nextButton = driver.findElement(By.linkText("Next"));

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get subpage Url")
    public String getUrl() {
        return NAV_FORM_URL;
    }

    @Step("Click next")
    public void clickNextButton() {
        nextButton.click();
    }
}
