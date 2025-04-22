package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTests extends BaseTest{
    @Test
    void openHomePageTest() {
        String actualTitle = driver.getTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

    @Test
    void openWebFormTest() {
        driver.findElement(By.xpath("//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'web-form')]")).click();
        //h1[@class = 'display-6' and text() = 'Web form']
        // webFormLink.click();
        String webFormUrl = "web-form.html";

        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title.getText());

    }

    @Test
    void openAllLinks() throws InterruptedException {
        int qtyLinks = 0;
        List<WebElement> chapters = driver.findElements(By.cssSelector("h5.card-title"));
        for (WebElement chapter : chapters) {
            List<WebElement> links = chapter.findElements(By.xpath("./../a"));
            qtyLinks += links.size();
            System.out.println(chapter.getText());
            for (WebElement link : links) {
                System.out.println(link.getText());
                link.click();
                //Thread.sleep(1000);
                driver.navigate().back();
            }
        }

        assertEquals(6, chapters.size());
        assertEquals(27, qtyLinks);
    }

    @Test
    void clasesTest() {
        List<WebElement> links = driver.findElements(By.cssSelector(".btn.btn-outline-primary.mb-2"));
        assertEquals(27, links.size());
    }

}
