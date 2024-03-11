package lesson5_pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ContactUsPage {
    static final Logger logger = LoggerFactory.getLogger(ContactUsPage.class);

    private static class Strings{
        private static final String orderId = "123456";
        private static final String correctMail = "mail@mail.mail";
        private static final String message = "message";
        private static final String failedAlertMessage = "Invalid email address.";
        private static final String successAlertMessage = "Your message has been successfully sent to our team.";


    }
    private WebDriver driver;
    private WebDriverWait wait;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_contact")
    private static WebElement select;

    @FindBy(id = "email")
    private static WebElement email;

    @FindBy(id = "id_order")
    private static WebElement id_order;

    @FindBy(id = "message")
    private static WebElement message;

    @FindBy(id = "submitMessage")
    private static WebElement submitMessage;

    @FindBy(css= ".alert.alert-success")
    private static WebElement successResult;

    @FindBy(xpath= "//div[@class='alert alert-danger']//li")
    private static WebElement failedResult;


    public ContactUsPage openMainPage(){
        driver.get("http://www.automationpractice.pl/index.php?controller=contact");
        return this;
    }

    public enum SubjectHeader{
        WEBMASTER, CUSTOM
    }
@Step("I try to select value from header element")
    public ContactUsPage selectSubject(SubjectHeader header){
        Select select1 = new Select(select);
        logger.info("I try to select value from header element");
        switch (header){
            case WEBMASTER -> select1.selectByVisibleText("Webmaster");
            case CUSTOM -> select1.selectByVisibleText("Customer service");
        }
        return this;
    }
    @Step("entering valid mail")
    public ContactUsPage enterValidMail(){
        logger.info("entering valid mail to element" + email.toString());
        email.sendKeys(Strings.correctMail);
        return this;
    }
    @Step("entering order ID")
    public ContactUsPage enterOrderId(){
        id_order.sendKeys(Strings.orderId);
        return this;
    }
    @Step("entering valid message")
    public ContactUsPage enterMessagae(){
        message.sendKeys(Strings.message);
        return this;
    }

    public String getSuccessResultMessage(){
        wait.until(ExpectedConditions.visibilityOf(successResult));
        logger.info("Getting success message from element" + successResult.toString());
        return successResult.getText();
    }
    public String getFailedResultMessage(){
        wait.until(ExpectedConditions.visibilityOf(failedResult));
        logger.info("Getting  message from element" + failedResult.toString());
        return failedResult.getText();
    }

    public String getSuccessMessage(){
        return Strings.successAlertMessage;
    }

    public String getFailedMessage(){
        return Strings.failedAlertMessage;
    }

    public ContactUsPage sendMessage(){
        submitMessage.click();
        return this;
    }



}
