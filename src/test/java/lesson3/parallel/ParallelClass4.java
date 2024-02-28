package lesson3.parallel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelClass4 {

    @Test
    public void a(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }

    @Test
    public void b(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }

    @Test
    public void c(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }

    @Test
    public void d(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }

    @Test
    public void e(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }

    @Test
    public void f(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://andersenlab.com/");
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen", "title is not correct!!!");
        driver.quit();
    }
}
