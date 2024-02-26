package lesson2.webElementMethods;

import lesson2.DriverSetUpV2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUpV2.setUpDriver();
        driver.get("https://www.guinnessworldrecords.com/search?term=%2A");
        WebElement searchField = driver.findElement(By.id("search-term"));
        WebElement searchButton = driver.findElement(By.id("search-button"));

        searchField.sendKeys("Handstand");
        Thread.sleep(1500);
        searchField.clear();
        Thread.sleep(1500);
        searchField.sendKeys(" Another keys");
        searchButton.click();

        System.out.println("========GET FROM ELEMENT++++++++");
        searchButton = driver.findElement(By.id("search-button"));
        System.out.println("Text from element:" + searchButton.getText());
        System.out.println("Tag name is: " + searchButton.getTagName());
        System.out.println("Value of class attribute: " + searchButton.getAttribute("class"));
        System.out.println("Css value is: " + searchButton.getCssValue("line-height"));
        driver.quit();
    }
}
