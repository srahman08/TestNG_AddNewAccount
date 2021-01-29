package test;

import javax.security.auth.login.AccountException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.HomePageValidation;
import page.LogInPage;
import util.BrowserFactory;
import util.ExcelReaderClass;

@Test
public class loginTest {
	WebDriver driver;
	ExcelReaderClass excelRead = new ExcelReaderClass("src\\main\\java\\data\\New_Account_Data.xlsx");
	String userName = excelRead.getCellData("LoginInfo", "UserName", 2);
	String password = excelRead.getCellData("LoginInfo", "Password", 2);

	public void userLogInScenario() {

		driver = BrowserFactory.abc();

		LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
		logInPage.enterUserName(userName);
		logInPage.enterPassword(password);
		logInPage.clickToSignin();
		/*
		 * HomePageValidation homePageValidation = PageFactory.initElements(driver,
		 * HomePageValidation.class); homePageValidation.pageValidation();
		 */
		BrowserFactory browserFactory = PageFactory.initElements(driver, BrowserFactory.class);
		browserFactory.tearDown();
	}

}
