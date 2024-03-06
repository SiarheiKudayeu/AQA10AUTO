package lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetUpV3 {
    private static WebDriver driver;

    private static WebDriver setUpDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver getInstance() {
        if (driver == null) {
            try {
                driver = setUpDriver();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return driver;
    }

    public static WebDriver startDriver(){
        driver = getInstance();
        return driver;
    }
}
