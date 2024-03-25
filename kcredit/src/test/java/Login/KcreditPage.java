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
	WebDriverUtility wutil;
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
	
	public void viewDetailsOfTheApplication() throws InterruptedException {
		Thread.sleep(4000);
		WebElement reviewbutton = driver.findElement(By.xpath("(//td[text()=\" CBA1Anandita26 \"]//following-sibling::td[text()=\" 8122244473 \"]//following-sibling::td//child::button//span[1])[1]"));
		reviewbutton.click();
	}

}
