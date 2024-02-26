package lesson2.webDriverMethods;

import lesson2.DriverSetUpV2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.time.Duration;
import java.util.Set;

public class WindowHandleExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUpV2.setUpDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        Set<String> windowHandles1 = driver.getWindowHandles();
        System.out.println(windowHandles1 + " first Set");

        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> windowHandles2 = driver.getWindowHandles();
        System.out.println(windowHandles2 + " second Set");
        windowHandles2.removeAll(windowHandles1);
        String idOfSecondWindow = windowHandles2.iterator().next();
        driver.switchTo().window(idOfSecondWindow);

        driver.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://uhomki.prom.ua/ua/");
        Thread.sleep(3000);
        driver.quit();

    }
}
