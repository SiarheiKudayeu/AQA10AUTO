package lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetUpV2 {

    public static WebDriver setUpDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =  new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options =  new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        driver.quit();

    }
}
