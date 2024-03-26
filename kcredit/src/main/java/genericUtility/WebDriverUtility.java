package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility  {
	
	Actions action = null;

	/**
	 * This method will maximize a browser
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void explicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void visibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void handleDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void handleDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void handleDropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void toDoubleClick(WebDriver driver) {
		action = new Actions(driver);
		action.doubleClick().perform();
	}

	public void toDoubleClickOnElement(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void toRightClick(WebDriver driver) {
		action = new Actions(driver);
		action.contextClick().perform();
	}

	public void toRightClickOnElement(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void toMouseHover(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void toClickAndHold(WebDriver driver) {
		action = new Actions(driver);
		action.clickAndHold().perform();
	}

	public void toClickAndHoldElement(WebDriver driver, WebElement element) {
		action = new Actions(driver);
		action.clickAndHold(element).perform();
	}

	public void toHandleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void toHandleFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	public void toHandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void toSwitchBackToFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void toSwitchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// Popup Methods handling
	public void toSwitchToAlertAndAcceptIt(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public String toSwitchToAlertAndGetText(WebDriver driver) {
		String alerttext = driver.switchTo().alert().getText();
		return alerttext;
	}

	public void toSwitchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void toSwitchWindow(WebDriver driver, String actualtitle) {
		String parentid = driver.getWindowHandle();
		Set<String> childid = driver.getWindowHandles();
		for (String id : childid) {
			String title = driver.switchTo().window(id).getTitle();
			if (title.contains(actualtitle)) {
				break;
			}
		}
	}
	
	public void toTakeScreenshots(WebDriver driver,String Screenshotname) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File tempfile = ts.getScreenshotAs(OutputType.FILE);
	File perfile=new File("./errorShots/"+Screenshotname+".png");
	FileHandler.copy(tempfile, perfile);	
	}
	
	
	  public void clickElementWithJsExecutor(WebDriver driver,WebElement element) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click()",element);
	  
	  }
	 


}
