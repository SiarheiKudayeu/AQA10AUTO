package lesson3.dataProvider;

import lesson2.DriverSetUpV2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderClass {
    @Test(dataProvider = "loginParameters" )
    public void loginTest(String email, int password){
        WebDriver driver = DriverSetUpV2.setUpDriver();
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(String.valueOf(password));
        driver.findElement(By.id("SubmitLogin")).click();
        By errorLocator = By.cssSelector(".alert.alert-danger p");
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator)).getText();
        String errorText = driver.findElement(errorLocator).getText();
        Assert.assertTrue(errorText.contains("error"));
        driver.quit();
    }

    @DataProvider(name= "loginParameters")
    public Object[][] createData(){
        return new Object[][]{
                {"email1", 33223}, {"email2", 332244}, {"email3", 3443}
        };
    }
}
