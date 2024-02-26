package lesson1;

import org.openqa.selenium.By;

public class TestLocators {
    public static void main(String[] args) {
        By locator = By.id("globe");
        By locator1 = By.name("Username");
        By locator2 = By.className("");
        By locator3 = By.linkText("HALL OF FAME");
        By locator4 = By.partialLinkText("OF FAME");
        By locator5 = By.cssSelector(".secondary_menu_wrapper div div.columned.block.block-4-12 [href*='apply']");
        By locator6 = By.xpath("//button[@id='search-button']");
    }
}
