package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageObjects.HomePage.BASE_URL;

public class WebFormPage extends BasePage {
    private static final String WEB_FORM_URL = "web-form.html";

    //locators
    WebElement submitButton = driver.findElement(By.xpath("//button[@type = 'submit']"));

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get subpage Url")
    public String getUrl() {
        return WEB_FORM_URL;
    }

    @Step("Submit form")
    public void submitForm() {
        submitButton.click();
    }

    @Step("Check that page is web form")
    public void checkIsWebPage() {
        assertEquals(BASE_URL + getUrl(), getCurrentUrl());
        assertEquals("Web form", getTitle().getText());
    }
}
