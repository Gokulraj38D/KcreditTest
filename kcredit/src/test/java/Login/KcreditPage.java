package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericUtility.BaseClass1;
import genericUtility.ExcelSheetUtility;
import genericUtility.WebDriverUtility;

public class KcreditPage extends BaseClass1 {
	ExcelSheetUtility eutil=new ExcelSheetUtility();
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
	//@Test
	public void searchApplication() throws InterruptedException {
		WebElement searchbar = driver.findElement(By.xpath("//*[contains(@placeholder,'Search by Application ID')]"));
		searchbar.sendKeys("6111000376",Keys.SPACE);
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
	//@Test
	public void loanEntryLoantypedropdown() throws InterruptedException {
		WebDriverUtility wutil = new WebDriverUtility();
		Thread.sleep(5000);
		//WebElement laontypedropdown = driver.findElement(By.xpath("//mat-label[text()='Loan Type']"));
		WebElement laontypedropdown1=driver.findElement(By.xpath("//*[text()='Loan Type']/parent::label/parent::span/parent::div"));
		wutil.toMouseHover(driver, laontypedropdown1);
		laontypedropdown1.click();
		WebElement loantypevalues = driver.findElement(By.xpath("//div[@role='listbox']//child::mat-option[1]/child::span[contains(text(),'JLG')]"));
		loantypevalues.click();
		Thread.sleep(3000);
	}
	
	public void loanEntrypartnerDropdown() throws InterruptedException {
		Thread.sleep(3000);
		WebElement partnerdropdown = driver.findElement(By.xpath("//*[text()='Partner']/parent::div/parent::div/parent::mat-select/parent::div/parent::div"));
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toMouseHover(driver, partnerdropdown);
		partnerdropdown.click();
		Thread.sleep(3000);
		WebElement selectpartners = driver.findElement(By.xpath("//div[@class='options-container ng-tns-c83-7']/child::mat-option[1]"));
		//wutil.clickElementWithJsExecutor(driver, selectpartners);
		selectpartners.click();
		Thread.sleep(3000);
	}
	
	

}
