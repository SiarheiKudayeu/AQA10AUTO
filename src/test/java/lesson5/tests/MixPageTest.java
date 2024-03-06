package lesson5.tests;

import lesson2.DriverSetUpV3;
import lesson5_pages.MixPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyTestListeners;

@Listeners({MyTestListeners.class})
public class MixPageTest {
    private static WebDriver driver;
    private static MixPage mixPage;

    @BeforeClass
    public void setUp(){
        driver = DriverSetUpV3.startDriver();
        mixPage = new MixPage(driver);
        mixPage.openMainPage();
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test
    public void tryDragNDrop(){
        mixPage
                .refreshMainPage()
                .dragNDrop(MixPage.Symbols.ROCKET)
                .dragNDrop(MixPage.Symbols.BALOON)
                .pause(3);
        Assert.assertTrue(true);
    }

    @Test
    public void checkClickerButtonFunction(){
        int countOfClicks = 5;
        mixPage
                .refreshMainPage()
                .clickOnCounterButton(countOfClicks);
        Assert.assertEquals(mixPage.returnNumberOfClicks(), countOfClicks, "Clicker button not work!!!");
    }
    @Test
    public void generateRandomAnimalByName(){
        String randomAnimal = "Кенгуру";
        Assert.assertEquals(mixPage
                        .refreshMainPage()
                        .returnSymbolOfAnimalByInsertingNameAndClickingRandom(randomAnimal),
                "\uD83E\uDD98");
    }
}
