package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebFormTest extends BaseTest{
    @Test
    void openWebFormTest() {
        driver.findElement(By.xpath("//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'web-form')]")).click();
        String webFormUrl = "web-form.html";

        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title.getText());

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
