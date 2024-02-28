package lesson3.parallel;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson2.DriverSetUpV2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParallelClass5 {
    WebDriver driver;

    @BeforeSuite
    public void beforeMethod() {
        driver = DriverSetUpV2.setUpDriver();
    }

    @Test
    public void a() {
        driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }

    @Test
    public void b() {
        driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }

    @Test
    public void c() {
        driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }

    @Test
    public void d() {
        driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }

    @Test
    public void e() {
        driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }

    @Test
    public void f() {
        driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }

    @AfterSuite
    public void afterMethod() {
        driver.quit();
    }
}
