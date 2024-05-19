package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class leavePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public leavePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
    }
    
    private By userName = By.id("login_username");
    private By passwordElement = By.id("login_password");
    private By button = By.cssSelector("[type='submit']");
    private By swithToEmployee = By.xpath("//*[text()='Switch to employee']");
    private By myRequest = By.xpath("//*[text()='My Requests']");
    private By openMyRequest = By.xpath("//*[text()='My Requests']/parent::span/span[1]");
    private By newRequest = By.xpath("//*[text()='New request']");
    private By createButton = By.xpath("//*[text()='Create']");
    private By leaveButton = By.xpath("//*[text()='My Leaves']");
    private By leaveType = By.cssSelector(".ant-select-show-arrow");
    private By leaveCalendar = By.cssSelector(".ant-picker");
    private By leaveFrom = By.cssSelector("[title='2024-05-22']");
    private By leaveEnd = By.cssSelector("[title='2024-05-29']");
    private By leaveList = By.xpath("//div[contains(@class,'rc-virtual-list')]//div[contains(@class,'ant-select-item-option-content')]");
    private By describtion = By.id("description");
    private By swithToManager = By.xpath("//*[text()='Switch to manager']");
    private By myTask = By.xpath("//*[text()='My Tasks']");
    private By leaveRequest = By.xpath("//*[text()='Leave Requests']");
    private By leaves = By.xpath("//*[text()='Cierra Test name Thompson']//ancestor::a");
    
    public void enterUsername(String username) {
    	waitforElement(userName);
        driver.findElement(userName).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordElement).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(button).click();
    }
    
    public void clickElement(By element) {
    	driver.findElement(element).click();
    }
   
    public void waitforElement(By element) {
    	  WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
          
    }
   
    public void clickMyRequest() {
    	waitforElement(myRequest);
    	clickElement(openMyRequest);
    }
   
    public void switchToEmployee() {
    	waitforElement(swithToEmployee);
    	clickElement(swithToEmployee);
    }
    
    public void clickNewRequest() {
    	waitforElement(newRequest);
    	clickElement(newRequest);
    }
    
    public void clickMyLeaveRequest() {
    	waitforElement(leaveButton);
    	clickElement(leaveButton);
    	clickNewRequest();
    }
    
    public void enterLeaveform(String leavetype) throws InterruptedException {
    	waitforElement(leaveType);
    	Thread.sleep(6000);
    	clickElement(leaveType);
    	List<WebElement> lstLeaveType = driver.findElements(leaveList);
    	for(int i =0;i<lstLeaveType.size();i++) {
    		System.out.println(lstLeaveType.get(i).getText());
    		if(lstLeaveType.get(i).getText().equals(leavetype)) {
    			lstLeaveType.get(i).click();
    			break;
    		}
    	}
    	clickElement(leaveCalendar);
    	Thread.sleep(6000);
    	clickElement(leaveFrom);
    	clickElement(leaveEnd);
    	driver.findElement(describtion).sendKeys("Compensatory leave");
    	clickElement(button);
    }
    
    public void swithcToManager() {
    	waitforElement(swithToManager);
    	clickElement(swithToManager);
    	clickElement(myTask);
    	clickElement(leaveRequest);
    	clickElement(leaves);
    }
    public void managerApproval() {
    	clickElement(leaves);
    }
}
