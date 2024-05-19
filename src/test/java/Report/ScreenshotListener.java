package Report;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ScreenshotListener implements ITestListener{


	    @Override
	    public void onTestFailure(ITestResult result) {
	        Object currentClass = result.getInstance();
	        WebDriver driver = ((pages.BaseTest) currentClass).getDriver(); // Assuming BaseTest contains WebDriver instance

	        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
	        Reporter.log("Screenshot saved at: " + screenshotPath);
	        Reporter.log("<a href='" + screenshotPath + "'> <img src='" + screenshotPath + "' height='100' width='100'/> </a>");
	    }

	    @Override
	    public void onTestStart(ITestResult result) {}
	    @Override
	    public void onTestSuccess(ITestResult result) {}
	    @Override
	    public void onTestSkipped(ITestResult result) {}
	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
	    @Override
	    public void onStart(ITestContext context) {}
	    @Override
	    public void onFinish(ITestContext context) {}

}
