package lesson5.select_tests;

import lesson2.DriverSetUpV2;
import lesson2.DriverSetUpV3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyTestListeners;

import java.util.List;
@Listeners({MyTestListeners.class})
public class SelectExampleTest {
    static WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = DriverSetUpV3.startDriver();
    }
    @AfterClass
    public void close(){
        driver.quit();
    }

    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///C:/Users/anduser/Desktop/additional/Enabled/Select.html");
        Select countries = new Select(driver.findElement(By.id("country")));
        //select
        countries.selectByIndex(3);
        Thread.sleep(1000);
        countries.selectByValue("germany");
        Thread.sleep(1000);
        countries.selectByVisibleText("Индия");
        Thread.sleep(1000);
        //isMultiple
        Select cities = new Select(driver.findElement(By.id("cities")));
        System.out.println("Is select countries multiple? " + countries.isMultiple());
        System.out.println("Is select cities multiple? " + cities.isMultiple());
        //Options
        List<WebElement> countriesList = countries.getOptions();
        for(WebElement country: countriesList){
            System.out.print(country.getText() + ", ") ;
        }
        System.out.println();
        List<WebElement> citiesList = cities.getOptions();
        for(WebElement city: citiesList){
            System.out.print(city.getText() + ", ") ;
        }

        cities.selectByVisibleText("Калькутта");
        Thread.sleep(1000);
        cities.selectByVisibleText("Бангалор");
        Thread.sleep(1000);
        cities.selectByVisibleText("Мумбаи");
        Thread.sleep(1000);
        cities.deselectByVisibleText("Бангалор");
        Thread.sleep(1000);
        Assert.assertEquals(cities.getAllSelectedOptions().size(), 3);
    }
}
