package lesson2.webDriverMethods;

import lesson2.DriverSetUpV2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class RefreshExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUpV2.setUpDriver();
        //manage()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //get()
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");

        //findElement()
        WebElement searchField = driver.findElement(By.id("search-term"));
        searchField.sendKeys("Handstand push ups");
        Thread.sleep(1500);
        driver.navigate().refresh();
        searchField = driver.findElement(By.id("search-term"));
        searchField.sendKeys("Another text");
        Thread.sleep(1500);
        driver.quit();
    }
}
