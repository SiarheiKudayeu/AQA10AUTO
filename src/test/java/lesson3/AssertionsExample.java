package lesson3;

import lesson2.DriverSetUpV2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AssertionsExample {

    WebDriver driver;
    @BeforeClass
    public void beforeMethod(){
        driver = DriverSetUpV2.setUpDriver();
    }

    @Test
    public void checkWebSiteTitle(){
        driver.get("https://andersenlab.com/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Software Development Company – Andersen"), "title is not correct!!!");
        Assert.assertFalse(driver.getTitle().equals("Software Development Com4pany – Andersen"));
        By cookieButton = By.xpath("//button[text()='Accept all cookies']");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(cookieButton));
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Accept all cookies']")).isDisplayed());
        Assert.assertEquals(driver.findElement(cookieButton).getText(), "Accept all cookies");
        Assert.assertNotEquals(driver.findElement(cookieButton).getText(), "Accept al3l cookies");
        Assert.assertNotNull(null);
    }

    @Test
    public void checkWebSiteTitle2(){
        driver.get("https://andersenlab.com/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Software Development Company – Andersen"), "title is not correct!!!");
        Assert.assertFalse(driver.getTitle().equals("Software Development Com4pany – Andersen"));
        By cookieButton = By.xpath("//button[text()='Accept all cookies']");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(cookieButton));
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Accept all cookies']")).isDisplayed());
        Assert.assertEquals(driver.findElement(cookieButton).getText(), "Accept all cookies");
        Assert.assertNotEquals(driver.findElement(cookieButton).getText(), "Accept al3l cookies");
    }

    @AfterClass
    public void afterMethod(){
        driver.quit();
    }

}
