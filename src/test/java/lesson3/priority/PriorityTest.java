package lesson3.priority;

import lesson2.DriverSetUpV2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PriorityTest {

    @Test(priority = 1)
    public void a() {
        WebDriver driver = DriverSetUpV2.setUpDriver();
        driver.get("https://andersenlab.com/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Software Development Company – Andersen"), "title is not correct!!!");
       driver.quit();
    }
    @Test(priority = 2)
    public void b() {
        WebDriver driver = DriverSetUpV2.setUpDriver();
        driver.get("https://andersenlab.com/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Software Development Company – Andersen"), "title is not correct!!!");
         driver.quit();
    }
    @Test
    public void d() {
        WebDriver driver = DriverSetUpV2.setUpDriver();
        driver.get("https://andersenlab.com/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Software Development Company – Andersen"), "title is not correct!!!");
        driver.quit();
    }
    @Test
    public void c() {
        WebDriver driver = DriverSetUpV2.setUpDriver();
        driver.get("https://andersenlab.com/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Software Development Company – Andersen"), "title is not correct!!!");
        driver.quit();
    }

}
