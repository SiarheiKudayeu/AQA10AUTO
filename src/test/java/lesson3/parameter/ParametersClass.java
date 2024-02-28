package lesson3.parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParametersClass {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void preconditions(String browser) {
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        }
    }

    @AfterClass
    public void postConditions(){
        driver.quit();
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
    }
}
