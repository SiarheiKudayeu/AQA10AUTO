package utils;

import io.qameta.allure.Attachment;
import lesson2.DriverSetUpV3;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyAllureListeners implements ITestListener {
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenShot(byte[] screenShot){
        return screenShot;
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " started!!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShot(((TakesScreenshot)DriverSetUpV3.startDriver()).getScreenshotAs(OutputType.BYTES));
    }

}
