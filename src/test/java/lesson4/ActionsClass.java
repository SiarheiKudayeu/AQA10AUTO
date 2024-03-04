package lesson4;

import lesson2.DriverSetUpV2;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsClass {
    public enum Links {
        INVITE, CONSULTANT, STANDARD
    }

    static void openLinkFromMainPage(Links links, WebDriver driver) {
        Actions actions = new Actions(driver);
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/records/\"]")));
        By locator = null;
        switch (links) {
            case INVITE ->
                    locator = By.xpath("(//a[@href=\"/records/the-application-process/invite-an-adjudicator\"])[1]");
            case CONSULTANT -> locator = By.xpath("(//a[@href=\"/records/the-application-process/consultancy\"])[1]");
            case STANDARD ->
                    locator = By.xpath("(//a[@href=\"/records/the-application-process/standard-applications\"])[1]");
        }
        actions
                .moveToElement(driver.findElement(By.xpath("//a[@href=\"/records/\"]")))
                .moveToElement(driver.findElement(By.xpath("//a[@href=\"/records/apply-to-set-or-break-a-record/\"]")))
                .click(driver.findElement(locator))
                .build().perform();
    }

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @BeforeMethod
    public void startDriver() {
        driver = DriverSetUpV2.setUpDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void hoverMouse() throws InterruptedException {
        openLinkFromMainPage(Links.INVITE, driver);
        Thread.sleep(3000);
        openLinkFromMainPage(Links.CONSULTANT, driver);
        Thread.sleep(3000);
        openLinkFromMainPage(Links.STANDARD, driver);
        Thread.sleep(3000);
    }

    @Test
    public void keyUpAndDownTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/records/\"]")));
        actions
                .moveToElement(driver.findElement(By.xpath("//a[@href=\"/records/\"]")))
                .moveToElement(driver.findElement(By.xpath("//a[@href=\"/records/apply-to-set-or-break-a-record/\"]")))
                .keyDown(Keys.CONTROL)
                .click(driver.findElement(By.xpath("(//a[@href=\"/records/the-application-process/standard-applications\"])[1]")))
                .keyUp(Keys.CONTROL)
                .build().perform();
        Thread.sleep(6000);
    }

    @Test
    public void dragNDrop() throws InterruptedException {
        driver.get("https://www.signesduquotidien.org/ouverture/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-btn"))).click();
        Thread.sleep(3000);
        actions
                .clickAndHold(driver.findElement(By.id("option2")))
                .pause(Duration.ofSeconds(3))
                .moveToElement(driver.findElement(By.id("menu-btn")))
                .release()
                .build().perform();
        Thread.sleep(3000);
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-btn"))).click();
        Thread.sleep(3000);
        actions
                .dragAndDrop(driver.findElement(By.id("option2")), driver.findElement(By.id("menu-btn")) ).perform();
        Thread.sleep(3000);
    }

    @Test
    public void alertExampleTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick=\"jsAlert()\"]"))).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You successfully clicked an alert");

        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");

        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = "Text!";
        alert.sendKeys(text);
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: " + text);
    }

    @Test
    public void doubleAndContext() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        //Thread.sleep(2000);
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gdpr-consent-notice")));
        driver.switchTo().frame("gdpr-consent-notice");*/
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("gdpr-consent-notice")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save"))).click();
        driver.switchTo().defaultContent();

        actions
                .contextClick(driver.findElement(By.cssSelector(".context-menu-one.btn-neutral"))).perform();
        driver.findElement(By.xpath("//span[text()='Quit']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();

        actions
                .doubleClick(driver.findElement(By.xpath("//button[@ondblclick=\"myFunction()\"]"))).perform();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void javaScriptExecutor() throws InterruptedException {
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll
        js.executeScript("window.scrollBy(0, 500)");

        //getTitle,getUrl
        String title = (String) js.executeScript("return document.title;");
        String url = (String) js.executeScript("return document.URL;");
        System.out.println("Title is "+ title);
        System.out.println("Url is " + url);

        //scroll to element
        WebElement element =driver.findElement(By.xpath("(//a[@href=\"/search/applicationrecordsearch?term=%2A&contentType=record\"])[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);

        //click
        js.executeScript("arguments[0].click();", element);
        Thread.sleep(3000);

        System.out.println(driver.getTitle());
    }

}
