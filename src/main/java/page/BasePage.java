package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	
public void waitForTheElement(WebDriver driver, int timeInSec, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

public static int randomNumberGenerator(int theRandomNumber) {
	Random rnd = new Random();
	int randomNumber = rnd.nextInt(theRandomNumber);
	return randomNumber;
}
}
