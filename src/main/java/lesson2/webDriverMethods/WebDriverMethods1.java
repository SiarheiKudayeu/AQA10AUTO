package lesson2.webDriverMethods;

import lesson2.DriverSetUpV2;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WebDriverMethods1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUpV2.setUpDriver();

        //manage()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //get()
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");

        //findElement()
        driver.findElement(By.id("search-term")).sendKeys("Handstand push ups");
        Thread.sleep(1500);

        //findElements()
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        Thread.sleep(1500);
        List<WebElement> webElementList = driver.findElements(By.cssSelector(".columned.block.block-4-12 a"));
        for (WebElement element : webElementList) {
            System.out.println(element.getText());
        }
        System.out.println("===================");

        //getTitle(), getPageSource(), getPageSource()
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("===================");
        //System.out.println(driver.getPageSource());

        //getCookies()
        Set<Cookie> cookies = driver.manage().getCookies();
        //driver.manage().addCookie("");
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
        System.out.println("==========");
        System.out.println("All count of cookies " + cookies.size());
        System.out.println("Separate cookie " + cookies.toArray()[2]);

        //navigate()
        System.out.println("==========");
        driver.navigate().to("http://www.automationpractice.pl/index.php");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("========== \nafter navigate back");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println("========== \nafter navigate forward");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().refresh();
        Thread.sleep(1500);
        //quit()
        driver.quit();
    }
}
