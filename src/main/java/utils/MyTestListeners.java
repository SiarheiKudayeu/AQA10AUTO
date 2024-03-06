package utils;

import lesson2.DriverSetUpV3;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyTestListeners implements ITestListener {

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
        System.out.println("Test with name " + result.getMethod().getMethodName() + " started!!!");
    }

    @Override
    public void onTestFailure(org.testng.ITestResult result) {
        makeScreenshot(result.getMethod().getMethodName());
    }

}
