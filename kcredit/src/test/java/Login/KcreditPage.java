package Login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genericUtility.BaseClass1;
import genericUtility.ExcelSheetUtility;
import genericUtility.WebDriverUtility;

public class KcreditPage extends BaseClass1 {
	ExcelSheetUtility eutil = new ExcelSheetUtility();

	public void selectLoanEntry() {
		WebElement loanentry = driver.findElement(By.xpath("//*[text()='start']"));
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toMouseHover(driver, loanentry);
		driver.findElement(By.xpath("//*[text()=' Loan Entry ']")).click();
	}

	public void selectLoanReview() {
		WebElement loanreview = driver.findElement(By.xpath("//*[text()='description']"));
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toMouseHover(driver, loanreview);
		driver.findElement(By.xpath("//*[text()=' Loan Review ']")).click();
	}

	public void selectUploads() {
		WebElement uploads = driver.findElement(By.xpath("//*[text()='file_upload']"));
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toMouseHover(driver, uploads);
		driver.findElement(By.xpath("//*[text()=' Uploads ']")).click();
	}

	public void selectReports() {
		WebElement uploads = driver.findElement(By.xpath("//*[text()='pie_chart_outline']"));
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toMouseHover(driver, uploads);
		driver.findElement(By.xpath("//*[text()=' Reports ']")).click();
	}

	public void ckycUploads() {
		WebElement uploads = driver.findElement(By.xpath("//*[text()='upload_file']"));
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toMouseHover(driver, uploads);
		driver.findElement(By.xpath("//*[text()=' CKYC Uploads ']")).click();
	}

	public void ckycReports() {
		WebElement uploads = driver.findElement(By.xpath("//*[text()='assessment']"));
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toMouseHover(driver, uploads);
		driver.findElement(By.xpath("//*[text()=' CKYC Reports ']")).click();
	}

	public void history() {
		WebElement uploads = driver.findElement(By.xpath("//*[text()='history']"));
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toMouseHover(driver, uploads);
		driver.findElement(By.xpath("//*[text()=' History ']")).click();
	}

	// @Test
	public void searchApplication() throws InterruptedException {
		WebElement searchbar = driver.findElement(By.xpath("//*[contains(@placeholder,'Search by Application ID')]"));
		searchbar.sendKeys("6111000376", Keys.SPACE);
		WebDriverUtility wutil = new WebDriverUtility();
		WebElement searchbutton = driver.findElement(By.xpath("//button[text()='Search']"));
		wutil.visibilityOfElement(driver, searchbutton);
		Thread.sleep(5000);
		searchbutton.click();
	}

	// This method is parked due to the table values are getting changed dinamically
//	public void viewDetailsOfTheApplication() throws InterruptedException {
//		Thread.sleep(4000);
//		WebElement reviewbutton = driver.findElement(By.xpath("(//td[text()=\" CBA1Anandita26 \"]//following-sibling::td[text()=\" 8122244473 \"]//following-sibling::td//child::button//span[1])[1]"));
//		reviewbutton.click();
//	}
	// @Test
	public void loanEntryLoantypedropdown() throws InterruptedException {
		WebDriverUtility wutil = new WebDriverUtility();
		Thread.sleep(5000);
		WebElement laontypedropdown1 = driver
				.findElement(By.xpath("//*[text()='Loan Type']/parent::label/parent::span/parent::div"));
		laontypedropdown1.click();
		WebElement loantypevalues = driver.findElement(
				By.xpath("//div[@role='listbox']//child::mat-option[1]/child::span[contains(text(),'JLG')]"));
		loantypevalues.click();
		Thread.sleep(3000);
	}

	public void loanEntrypartnerDropdown() throws InterruptedException {
		Thread.sleep(3000);
		WebElement partnerdropdown = driver.findElement(By.xpath(
				"//*[text()='Partner']/parent::label/parent::span/preceding-sibling::mat-select/parent::div/parent::div/parent::div"));
		Thread.sleep(3000);
		partnerdropdown.click();
		Thread.sleep(2000);
		WebElement partnersvalue = driver.findElement(By.xpath("//*[@role='listbox']/child::div[2]"));
		String partnername = partnersvalue.getText();
		System.out.println(partnername);
		if (partnername.contains("Samasta")) {
			partnersvalue.click();
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder='Enter search text']")).sendKeys(Keys.TAB);
		Thread.sleep(5000);
	}

	public void loanEntrypartnerDropdown1() throws InterruptedException {
		Thread.sleep(3000);
		WebElement partnerdropdown = driver.findElement(By.xpath(
				"//*[text()='Partner']/parent::label/parent::span/preceding-sibling::mat-select/parent::div/parent::div/parent::div"));
		Thread.sleep(3000);
		partnerdropdown.click();
		List<WebElement> partnerids = driver.findElements(By.xpath("//*[@class='options-container ng-tns-c83-18']"));
		System.out.println(partnerids);
		for (WebElement partnerid : partnerids) {
			if (partnerid.equals("sonata")) {
				partnerid.click();
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder='Enter search text']")).sendKeys(Keys.TAB);
		Thread.sleep(5000);
	}
//		WebElement partnernameSearch = driver.findElement(By.xpath("//*[@role='listbox']/child::mat-form-field"));
//		partnernameSearch.sendKeys("sonata");
//		wutil.implicitWait(driver);
//		WebElement selectpartners = driver.findElement(By.xpath("//div[@class='options-container ng-tns-c83-7']/child::mat-option[1]"));
//		//wutil.clickElementWithJsExecutor(driver, selectpartners);
//		selectpartners.click();
	// Thread.sleep(3000);
}
