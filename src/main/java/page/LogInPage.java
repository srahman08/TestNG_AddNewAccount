package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LogInPage extends BasePage{
	
	WebDriver driver;

	
	@FindBy(how = How.XPATH, using = "//input[@id='username']") WebElement USERNAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='password']") WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//button[@type='submit']") WebElement SIGNIN_FIELD;
	
	
	public void enterUserName(String userName) {
		
		USERNAME_FIELD.sendKeys(userName);
		
	}
	
	public void enterPassword(String password) {
		PASSWORD_FIELD.sendKeys(password);
	}
	
	public void clickToSignin() {
		
		SIGNIN_FIELD.click();
		
	}
	
	

	
	
	
	
	
	
	
	

}
