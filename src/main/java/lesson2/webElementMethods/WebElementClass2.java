package lesson2.webElementMethods;

import lesson2.DriverSetUpV2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementClass2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUpV2.setUpDriver();
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

        System.out.println("========GET FROM ELEMENT++++++++");
        WebElement registerButton = driver.findElement(By.id("SubmitCreate"));
        System.out.println("Text from element: " + registerButton.getText());
        System.out.println("Tag name is: " + registerButton.getTagName());
        System.out.println("Value of class attribute: " + registerButton.getAttribute("class"));
        System.out.println("Css value is: " + registerButton.getCssValue("font-size"));

        System.out.println("=============Coordinates================");
        System.out.println("Location is " + registerButton.getLocation());
        System.out.println("X coordinate is " + registerButton.getLocation().x);
        System.out.println("Y coordinate is " + registerButton.getLocation().y);

        System.out.println("=============Size================");
        System.out.println("Size is " + registerButton.getSize());
        System.out.println("width size is " + registerButton.getSize().width);
        System.out.println("height size is " + registerButton.getSize().height);


        System.out.println("========is????===========");
        driver.get("https://www.guinnessworldrecords.com/Account/Login?ReturnUrl=%2faccount");
        Thread.sleep(5000);
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        } catch (NoSuchElementException e){
            System.out.println("Cookies is not displayed!!!");
        }
        WebElement checkBox = driver.findElement(By.id("RememberMe"));
        System.out.println("checkBox.isDisplayed() " + checkBox.isDisplayed());
        System.out.println("checkBox.isEnabled() " + checkBox.isEnabled());
        System.out.println("checkBox.isSelected() " + checkBox.isSelected());
        checkBox.click();
        System.out.println("==============After selection!!!======================");
        System.out.println("checkBox.isDisplayed() " + checkBox.isDisplayed());
        System.out.println("checkBox.isEnabled() " + checkBox.isEnabled());
        System.out.println("checkBox.isSelected() " + checkBox.isSelected());
        driver.quit();
    }
}
