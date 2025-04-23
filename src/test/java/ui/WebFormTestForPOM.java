package ui;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import pageObjects.WebFormPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageObjects.HomePage.BASE_URL;

@Feature("POM")
public class WebFormTestForPOM extends BaseTestForPOM{
    @Test
    void openWebFormTest() {
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPage = homePage.openWebFormPage();
        String currentUrl = webFormPage.getCurrentUrl();
        WebElement title = webFormPage.getTitle();
        String webFormUrl = webFormPage.getUrl();

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title.getText());
    }

    @Test
    void openWebFormTestWithCheck() {
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.checkIsWebPage();
    }

    @Test
    void submitFormTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.submitForm();
        Thread.sleep(3000);
    }

    @Test
    void proverkaTextArea() throws InterruptedException {

        driver.findElement(By.xpath("//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'web-form')]")).click();

        WebElement textArea = driver.findElement(By.name("my-textarea"));
        textArea.sendKeys("uwuwu");
        String enteredValue = textArea.getAttribute("value");
        //Thread.sleep(1000);
        assertEquals("uwuwu", enteredValue);

        WebElement textAreaLabel = driver.findElement(By.xpath("//label[normalize-space(.)='Textarea']"));
        String textAreaText = textAreaLabel.getText();
        assertEquals("Textarea", textAreaText);

    }

    @Test
    void proverkaDisabledInput() throws InterruptedException {

        driver.findElement(By.xpath("//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'web-form')]")).click();

        WebElement disabledInput = driver.findElement(By.name("my-disabled"));
        Assertions.assertFalse(disabledInput.isEnabled());
        Assertions.assertThrows(ElementNotInteractableException.class, () -> disabledInput.sendKeys("test"));

        String placeholderText = disabledInput.getAttribute("placeholder");
        //Thread.sleep(1000);
        assertEquals("Disabled input", placeholderText);

        WebElement disabledInputLabel = driver.findElement(By.xpath("//label[normalize-space(.)='Disabled input']"));
        String disabledInputText = disabledInputLabel.getText();
        assertEquals("Disabled input", disabledInputText);

    }
}
