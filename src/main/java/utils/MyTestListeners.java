package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.TmsLink;
import lesson2.DriverSetUpV3;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class MyTestListeners implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshort(byte[] screenshot) {
        return screenshot;
    }

    private static void makeScreenshot(String method){
        File screenshotFile = ((TakesScreenshot)DriverSetUpV3.startDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("./target/screenshots/" + method + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void onTestStart(ITestResult result) {
        TmsLink tmsLinkAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TmsLink.class);
        if (tmsLinkAnnotation != null) {
            String testRailLink = "https://resterruster32wis.testrail.io/index.php?/cases/view/" + tmsLinkAnnotation.value(); // Здесь нужно реализовать генерацию ссылки на TestRail
            Allure.getLifecycle().updateTestCase(testResult -> testResult.setDescription("TestRail Link: " + testRailLink));
        }
    }


    @Override
    public void onTestFailure(ITestResult result) {
        //makeScreenshot(result.getMethod().getMethodName());
        saveScreenshort(((TakesScreenshot)DriverSetUpV3.startDriver()).getScreenshotAs(OutputType.BYTES));
    }

}
