package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static String browser;
	static String url; 
	static WebDriver driver;
	public static void readConfiguration() {
		
		Properties prp = new Properties();
		
		try {
			InputStream iS = new FileInputStream("src\\main\\java\\config\\config.properties");
			prp.load(iS);
			browser = prp.getProperty("browser");
			url = prp.getProperty("url");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	public static WebDriver abc() {
		readConfiguration();
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
		}
	
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
	
	
}
