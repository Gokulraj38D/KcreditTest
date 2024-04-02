package genericUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import KcreditPageReposatory.Login;
import KcreditPageReposatory.OverviewPage;

public class BaseClass1 {
	PropertiesFileUtility putil = new PropertiesFileUtility();
	ExcelSheetUtility eutil = new ExcelSheetUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	JavascriptExecutor js=(JavascriptExecutor)driver;

	@BeforeClass
	public void beforeClassConfiguration() throws IOException {
		String browser = putil.toGetDataFromPropertiesFile("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
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
		Login login = new Login(driver);
		login.getUsernameTextField().sendKeys(username);
		login.getPasswordTextField().sendKeys(password);
		login.getLoginbutton().click();
	}

	@AfterMethod
	public void afterMethodConfiguration() throws InterruptedException {	
		Thread.sleep(3000);		
		WebElement logout = driver.findElement(By.xpath("//img[@src='../../../assets/images/dashboard/profile.svg']"));
		wutil.explicitWait(driver, logout);
		logout.click();
		driver.findElement(By.xpath("//*[text()=' Logout ']")).click();
	}

//	@AfterClass
//	public void afterClassConfiguration() {
//		driver.close();
//	}

}
