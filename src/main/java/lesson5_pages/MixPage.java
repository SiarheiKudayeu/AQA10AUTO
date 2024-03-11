package lesson5_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MixPage {
    private WebDriver driver;

    public MixPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static class Locators {
        private final static By star = By.id("star");
    }

    public enum Symbols {
        STAR, APPLE, BALOON, ROCKET, PIZZA
    }

    @FindBy(id = "star")
    private static WebElement star;
    @FindBy(id = "baloon")
    private static WebElement baloon;
    @FindBy(id = "apple")
    private static WebElement apple;
    @FindBy(id = "rocket")
    private static WebElement rocket;
    @FindBy(id = "pizza")
    private static WebElement pizza;
    @FindBy(id = "dragArea2")
    private static WebElement dragArea2;
    @FindBy(id = "select")
    private static WebElement select;
    @FindBy(id = "doubleClickButton")
    private static WebElement doubleClickButton;
    @FindBy(id = "contextClickButton")
    private static WebElement contextClickButton;
    @FindBy(id = "clickCounterButton")
    private static WebElement clickCounterButton;
    @FindBy(id = "clickCounter")
    private static WebElement clickCounter;
    @FindBy(id = "generateAnimalButton")
    private static WebElement generateAnimalButton;
    @FindBy(id = "randomAnimal")
    private static WebElement randomAnimal;

    public MixPage openMainPage() {
        driver.get("file:///C:/Users/anduser/Desktop/additional/Enabled/MixId.html");
        return this;
    }
    public MixPage refreshMainPage() {
        driver.navigate().refresh();
        return this;
    }

    public MixPage dragNDrop(Symbols symbols) {
        Actions actions = new Actions(driver);
        WebElement sourceElement = null;
        switch (symbols) {
            case STAR -> sourceElement = star;
            case APPLE -> sourceElement = apple;
            case BALOON -> sourceElement = baloon;
            case PIZZA -> sourceElement = pizza;
            case ROCKET -> sourceElement = rocket;
        }
        actions.dragAndDrop(sourceElement, dragArea2).perform();
        return this;
    }

    public MixPage pause(int countOdSeconds) {
        try {
            Thread.sleep(1000L * countOdSeconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return this;
    }

    public void clickOnCounterButton(int countOfClicks){
        for (int i= 0; i < countOfClicks; i++ ){
            clickCounterButton.click();
        }
    }

    public int returnNumberOfClicks(){
        return Integer.parseInt(clickCounter.getText());
    }

    public String returnSymbolOfAnimalByInsertingNameAndClickingRandom(String nameOfAnimal){
        while (!(randomAnimal.getText().contains(nameOfAnimal))){
            generateAnimalButton.click();
        }
        return randomAnimal.getText().split("\\s")[1];
    }


}
