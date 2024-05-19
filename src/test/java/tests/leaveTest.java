package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.TestListener;
import pages.BaseTest;
import pages.leavePage;

@Listeners(Report.ScreenshotListener.class)
public class leaveTest extends BaseTest {
	private leavePage lpage;

	 

	    @Test
	    public void testExample() throws InterruptedException {
	    	lpage = new leavePage(driver);
	        // Test logic using Selenium WebDriver
	        driver.get("https://env-staging.connecthr.ae/login");
	        driver.manage().window().maximize();
	        // Add your test steps here
	        lpage.enterUsername("qatester@fthcapital.com");
	        lpage.enterPassword("Test@123");
	        lpage.clickLoginButton();
	        lpage.switchToEmployee();
	        lpage.clickMyRequest();
	        lpage.clickMyLeaveRequest();
	        lpage.enterLeaveform("Study leave");
	    }
@AfterClass
public void tearDown() {
	driver.quit();
}

}
