package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddNewAccount;
import page.LogInPage;
import util.BrowserFactory;
import util.ExcelReaderClass;

public class AddNewAccountTest  {

	WebDriver driver;

	ExcelReaderClass excelRead = new ExcelReaderClass("src\\main\\java\\data\\New_Account_Data.xlsx");
	String userName = excelRead.getCellData("LoginInfo", "UserName", 2);
	String password = excelRead.getCellData("LoginInfo", "Password", 2);
	String accountTile = excelRead.getCellData("NewAccountInfo", "Account Title", 2);
	String accountDesc = excelRead.getCellData("NewAccountInfo", "Description", 2);
	String accountBalance = excelRead.getCellData("NewAccountInfo", "Initial Balance", 2);
	String accountNumb = excelRead.getCellData("NewAccountInfo", "Account Number", 2);
	String contactPerson = excelRead.getCellData("NewAccountInfo", "Contact Person", 2);
	String phoneNumber = excelRead.getCellData("NewAccountInfo", "Phone", 2);
	String bankingURLaddress = excelRead.getCellData("NewAccountInfo", "Internet Banking URL", 2);
	

	@Test
	public void userLogInScenario() throws InterruptedException {

		driver = BrowserFactory.abc();

		LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
		logInPage.enterUserName(userName);
		logInPage.enterPassword(password);
		logInPage.clickToSignin();

		AddNewAccount addNewAccount = PageFactory.initElements(driver, AddNewAccount.class);
		addNewAccount.bankAndCashTab();
		addNewAccount.newAccountTab();
		// addNewAccount.accountsPageValidation();

		addNewAccount.accountTitleName(accountTile);
		addNewAccount.accountDescription(accountDesc);
		addNewAccount.initBalance(accountBalance);
		addNewAccount.accountNUmber(accountNumb);
		addNewAccount.contactPersonName(contactPerson);
		addNewAccount.phoneNumber(phoneNumber);
		addNewAccount.bankURL(bankingURLaddress);
		addNewAccount.clickSubmit();
		
		addNewAccount.listAccountTab();
		addNewAccount.verifyEnteredName();
		Thread.sleep(2000);
		addNewAccount.clickToDelete();
		
		//addNewAccount.clickToCancel();
	}
}