package lesson2.waiters;

import lesson2.DriverSetUpV2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = DriverSetUpV2.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all"))).click();
        //Username
        //RememberMe
        wait.until(ExpectedConditions.elementToBeSelected(By.id("RememberMe")));
        driver.findElement(By.id("Username")).sendKeys("Example!!!!");
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("Username"),"AQA"));
        driver.findElement(By.id("Password")).sendKeys("Second example!!!!");
    }
}
