package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import KcreditPageReposatory.Login;

public class BaseClass1 {
	PropertiesFileUtility putil=new PropertiesFileUtility();
	ExcelSheetUtility eutil=new ExcelSheetUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	public WebDriver driver=null;
	
	
	@BeforeClass
	public void beforeClassConfiguration() throws IOException {
		String browser = putil.toGetDataFromPropertiesFile("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		String url = putil.toGetDataFromPropertiesFile("url");
		wutil.maximizeWindow(driver);
		wutil.implicitWait(driver);
		driver.get(url);
	}
	
	@BeforeMethod
	public void beforeMethodConfiguration() throws IOException {
		String username = putil.toGetDataFromPropertiesFile("username");
		String password = putil.toGetDataFromPropertiesFile("password");
		Login login=new Login(driver);
		login.getUsernameTextField().sendKeys(username);
		login.getPasswordTextField().sendKeys(password);
		login.getLoginbutton().click();
	}
	
	@AfterMethod
	public void afterMethodConfiguration() {
		driver.close();
	}
	

}
