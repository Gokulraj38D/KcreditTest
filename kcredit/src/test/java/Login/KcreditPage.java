package Login;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import genericUtility.BaseClass1;
import genericUtility.ExcelSheetUtility;
import genericUtility.WebDriverUtility;

public class KcreditPage extends BaseClass1 {
	ExcelSheetUtility eutil = new ExcelSheetUtility();
	WebDriverUtility wutil = new WebDriverUtility();


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

	public void selectReports() throws InterruptedException {
		Thread.sleep(5000);
		WebElement uploads = driver.findElement(By.xpath("//*[text()='pie_chart_outline']"));
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toMouseHover(driver, uploads);
		driver.findElement(By.xpath("//*[text()=' Reports ']")).click();
		Thread.sleep(3000);
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
	public void searchApplication() throws InterruptedException, IOException {
		String mobilenumber = eutil.toGetDataFromExcelSheet("loandetails", 1, 0);
		String partneloanid = eutil.toGetDataFromExcelSheet("loandetails", 1, 1);
		String partnercustomerid = eutil.toGetDataFromExcelSheet("loandetails", 1, 2);
		System.out.println(mobilenumber);
		WebElement searchbar = driver.findElement(By.xpath("//*[contains(@placeholder,'Search by Application ID')]"));
		searchbar.sendKeys(mobilenumber, Keys.SPACE);
		WebDriverUtility wutil = new WebDriverUtility();
		WebElement searchbutton = driver.findElement(By.xpath("//button[text()='Search']"));
		wutil.visibilityOfElement(driver, searchbutton);
		Thread.sleep(5000);
		searchbutton.click();
	}
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

	public void loanEntrypartnerDropdown1() throws InterruptedException, IOException {
		String partnername = eutil.toGetDataFromExcelSheet("partners", 4, 0);
		Thread.sleep(3000);
		WebElement partnerdropdown = driver.findElement(By.xpath(
				"//*[text()='Partner']/parent::label/parent::span/preceding-sibling::mat-select/parent::div/parent::div/parent::div"));
		Thread.sleep(3000);
		partnerdropdown.click();
		 WebElement partnerid = driver.findElement(By.xpath("//*[text()='"+partnername+"']"));
		System.out.println(partnerid);
		partnerid.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder='Enter search text']")).sendKeys(Keys.TAB);
		Thread.sleep(5000);
	}
	
	public void missingDetails() throws IOException, InterruptedException {
		Thread.sleep(5000);
		String mobilenumber = eutil.toGetDataFromExcelSheet("loandetails", 1, 0);
		String partneloanid = eutil.toGetDataFromExcelSheet("loandetails", 1, 1);
		String partnercustomerid = eutil.toGetDataFromExcelSheet("loandetails", 1, 2);
		WebElement missingdetailslink = driver.findElement(By.xpath("//*[text()=' "+partneloanid+" ']//following-sibling::td[text()=' "+mobilenumber+" ']/following-sibling::td[text()=' "+partnercustomerid+" ']//following-sibling::td/child::span[text()='Missing Details']"));
		missingdetailslink.click();
		Thread.sleep(2000);
		List<WebElement> missingrequireddata = driver.findElements(By.xpath("//div[text()='Reason for incomplete']/parent::div//following-sibling::div[1]"));
		for(WebElement data:missingrequireddata) {
			String missingdata = data.getText();
			System.out.println("missing required datas are :" +missingdata);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()=' Copy ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Cancel']")).click();
		Thread.sleep(5000);
	}
	
	public void generateApprovalMISreport() throws Exception {
		Thread.sleep(5000);
		//select porpose as internal/External (Expected: should choose External)
		driver.findElement(By.xpath("//*[text()='Purpose']/parent::label/parent::span//parent::div/parent::div")).click();
		driver.findElement(By.xpath("//*[text()='External']")).click();
		
		//select report section
		WebElement reporttype = driver.findElement(By.xpath("//*[@formcontrolname='reportType']"));
		reporttype.click();
		driver.findElement(By.xpath("//span[text()='Approval']")).click();
		Thread.sleep(5000);
		reporttype.sendKeys(Keys.TAB);
		
		//select partners
		String partnername = eutil.toGetDataFromExcelSheet("partners", 4, 0);
		WebElement partner = driver.findElement(By.xpath("//mat-select[@ng-reflect-name='partners']"));
		partner.click();
		System.out.println("partnername :"+partner.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='"+partnername+"']")).click();
		partner.sendKeys(Keys.TAB);
		
		//Select Customer type
		WebElement customertype = driver.findElement(By.xpath("//mat-select[@formcontrolname='customerType']"));
		customertype.click();
		driver.findElement(By.xpath("//span[text()='JLG']")).click();
		customertype.sendKeys(Keys.TAB);
		
		//select Start date
		WebElement startdate = driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[1]"));
		startdate.click();
		driver.findElement(By.xpath("//button[@aria-label='29 March 2024']")).click();
		//select End date
		WebElement enddate = driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[2]"));
		enddate.click();
		driver.findElement(By.xpath("//button[@aria-label='29 March 2024']")).click();
		Thread.sleep(3000);
		
		//CLick Generate report button.
		WebElement generatebutton = driver.findElement(By.xpath("//span[text()=' Generate Report ']"));
		generatebutton.click();
		Thread.sleep(3000);
	}
}
