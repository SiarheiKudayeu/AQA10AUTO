package lesson5.tests;

import io.qameta.allure.*;
import lesson2.DriverSetUpV3;
import lesson5_pages.ContactUsPage;
import lesson5_pages.MixPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyAllureListeners;

@Listeners({MyAllureListeners.class})
public class ContactUsPageTest {
    private static WebDriver driver;
    private static ContactUsPage contactUsPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUpV3.startDriver();
        contactUsPage = new ContactUsPage(driver);
    }

    @AfterClass
    public void stop() {
        driver.quit();
    }

    @Test
    @Description("This is a positive sending message test")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sending message function testing")
    @TmsLink("https://resterruster32wis.testrail.io/index.php?/cases/view/5")
    public void positiveSendMessage() {
        contactUsPage
                .openMainPage()
                .selectSubject(ContactUsPage.SubjectHeader.WEBMASTER)
                .enterValidMail()
                .enterMessagae()
                .enterOrderId()
                .sendMessage();
        Assert.assertEquals(contactUsPage.getSuccessResultMessage(), contactUsPage.getSuccessMessage());
    }

    @Test
    @Description("This is a negative sending message test")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Sending message function testing")
    @Story("Any text about logic from user point of view!!!")
    public void negativeSendMessage() {
        contactUsPage
                .openMainPage()
                .selectSubject(ContactUsPage.SubjectHeader.WEBMASTER)
                .enterMessagae()
                .enterOrderId()
                .sendMessage();
        Assert.assertEquals(contactUsPage.getFailedResultMessage(), contactUsPage.getFailedMessage());
    }

    @Test
    @Description("This is a negative sending message test 2")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Sending message function testing")
    @Story("Any text about logic from user point of view!!!")
    public void negativeSendMessage2() {
        contactUsPage
                .openMainPage()
                .selectSubject(ContactUsPage.SubjectHeader.WEBMASTER)
                .enterMessagae()
                .enterOrderId()
                .sendMessage();
        Assert.assertEquals(contactUsPage.getFailedResultMessage(), contactUsPage.getSuccessMessage());
    }
}
