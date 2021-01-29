package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class HomePageValidation extends BasePage {
	
	WebDriver driver;

	public  HomePageValidation(WebDriver driver) {
	this.driver = driver;
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Welcome Techfios')]") WebElement Welcome_Techfios;
	
	public void pageValidation() {
		
		waitForTheElement(driver,5, Welcome_Techfios);
		
		Assert.assertEquals(Welcome_Techfios.getText(), "Welcome Techfios", "Page Not Found !!");
		//Assert.assertEquals(actual, expected, message);
		
	}

}
