package page;

import java.util.List;
import java.util.Random;

import javax.swing.text.Element;

import org.apache.commons.collections4.map.StaticBucketMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddNewAccount extends BasePage {

	WebDriver driver;
	int randomNumber;

	public AddNewAccount(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Bank & Cash')]")
	WebElement Bank_And_Cash;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Account')]")
	WebElement New_Account;

	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement Account_Title;
	@FindBy(how = How.XPATH, using = "//input[@id='description']")
	WebElement Description;
	@FindBy(how = How.XPATH, using = "//input[@id='balance']")
	WebElement Balance;
	@FindBy(how = How.XPATH, using = "//input[@id='account_number']")
	WebElement Account_Number;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_person']")
	WebElement Contact_Person;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_phone']")
	WebElement Phone_Contact;
	@FindBy(how = How.XPATH, using = "//input[@id='ib_url']")
	WebElement Banking_URL;
	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])[2]")
	WebElement Submit_Button;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Accounts')]")
	WebElement List_Account_Button;
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Manage Accounts')]")
	WebElement Manage_Accounts;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	WebElement OK_To_Delete;

	// @FindBy (how = How.XPATH, using = "(//button[@type='button'])[3]") WebElement
	// OK_To_Delete;
// @FindBy (how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]") WebElement OK_To_Delete;
//	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Cancel')]")
	WebElement CANCEL_BUTTON;

	public void bankAndCashTab() {
		Bank_And_Cash.click();

	}

	public void newAccountTab() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(New_Account));
		// waitForTheElement(driver, 5, New_Account);
		New_Account.click();
	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Accounts')]")
	WebElement Accounts_Header;

	public void accountsPageValidation() {
		waitForTheElement(driver, 5, Accounts_Header);

		Assert.assertEquals(Accounts_Header.getText(), " Accounts ", "Page Not Found !!");
	}

	String accountTitle;

	public void accountTitleName(String newAccountTile) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(Description));
		// Thread.sleep(2000);
		int randomNumber = randomNumberGenerator(99);

		accountTitle = newAccountTile + randomNumber;
		Account_Title.sendKeys(accountTitle);
	}

	public void accountDescription(String accountDesc) {
		int randomNumber = randomNumberGenerator(99);

		Description.sendKeys(accountDesc + randomNumber);
	}

	public void initBalance(CharSequence accountBalance) {

		CharSequence blcCharSequence = "accountBalance";
		int randomNumber = randomNumberGenerator(9999);
		accountBalance = "accountBalance" + randomNumber;
		Balance.sendKeys(accountBalance);
	}

	public void accountNUmber(String accountNumb) {

		int randomNumber = randomNumberGenerator(99);
		accountNumb = accountNumb + randomNumber;
		Account_Number.sendKeys(accountNumb);
	}

	public void contactPersonName(String contactPerson) {
		int randomNumber = randomNumberGenerator(99);
		contactPerson = contactPerson + randomNumber;
		Contact_Person.sendKeys(contactPerson);
	}

	public void phoneNumber(String phoneNumber) {

		int randomNumber = randomNumberGenerator(9999);
		phoneNumber = phoneNumber + randomNumber;
		Phone_Contact.sendKeys(phoneNumber);

	}

	public void bankURL(String bankingURLaddress) {
		Banking_URL.sendKeys(bankingURLaddress);
	}

	public void clickSubmit() {
		Submit_Button.click();

	}

	public void listAccountTab() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(List_Account_Button));
		List_Account_Button.click();
	}
	public void verifyEnteredName() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(Manage_Accounts));

		String before_xpath = "//tbody/descendant::tr[";
		String after_xpath = "]/child::td[1]";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped table-bordered']/tbody/tr"));
		int length = rows.size();
		System.out.println("=============" + length);
		for (int i = length; i > 100; i--) {
			
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			
			System.out.println("===================" + name);
		
			if (name.contains(accountTitle)) {
				System.out.println("entered name exist");
		driver.findElement(By.xpath("//tbody/descendant::tr[" + i + "]/child::td[1]/parent::tr/child::td[3]/child::a[3]")).click();
		break; 		

			}
		}
	}

	public void clickToDelete() {
//		WebDriverWait wait = new WebDriverWait(driver, 3);
//		wait.until(ExpectedConditions.visibilityOf(OK_To_Delete));
		// String alertMsg = driver.switchTo().alert().getText();
		// System.out.println("***********" + alertMsg);
		// driver.switchTo().alert().getText(); //driver.switchTo().alert().accept();
//		WebDriverWait wait = new WebDriverWait(driver, 3);
//		wait.until(ExpectedConditions.elementToBeClickable(OK_To_Delete));
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
		
		  waitForTheElement(driver, 3, OK_To_Delete); 
		  OK_To_Delete.click();
		 
	

	}

	/*
	 * public void clickToCancel() { waitForTheElement(driver,3,CANCEL_BUTTON );
	 * CANCEL_BUTTON.click();
	 * 
	 * }
	 */

}