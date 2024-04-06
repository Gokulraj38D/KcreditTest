package Login;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JScrollBar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import genericUtility.BaseClass1;
import genericUtility.ExcelSheetUtility;
import genericUtility.IconstantUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class KcreditPage extends BaseClass1 {
	ExcelSheetUtility eutil = new ExcelSheetUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	JavaUtility jutil = new JavaUtility();

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

	public String searchApplication() throws InterruptedException, IOException {
		String mobilenumber = eutil.toGetDataFromExcelSheet("loandetails", 5, 0);
		String partneloanid = eutil.toGetDataFromExcelSheet("loandetails", 5, 1);
		String partnercustomerid = eutil.toGetDataFromExcelSheet("loandetails", 5, 2);
		System.out.println(mobilenumber);
		WebElement searchbar = driver.findElement(By.xpath("//*[contains(@placeholder,'Search by Application ID')]"));
		searchbar.sendKeys(mobilenumber, Keys.SPACE);
		WebDriverUtility wutil = new WebDriverUtility();
		WebElement searchbutton = driver.findElement(By.xpath("//button[text()='Search']"));
		wutil.visibilityOfElement(driver, searchbutton);
		Thread.sleep(5000);
		searchbutton.click();
		Thread.sleep(5000);
		return partneloanid;

	}

	public void toCheckApplicationinLoanEnrty(String loanid) throws InterruptedException, IOException {
		int count = 120;
		int clickcount = 0;
		boolean flag = true;
		while (flag) {
			try {
				WebElement partnerloanid = driver.findElement(By.xpath("//td[text()=' " + loanid + " '][1]"));
				// System.out.println("partnerloanid : " + partnerloanid);
				WebElement incompletebutton = driver
						.findElement(By.xpath("//span[text()=' Incomplete ']/parent::span"));
				incompletebutton.click();
				Thread.sleep(1000);
				clickcount++;
				System.out.println("clickcount : " + clickcount);
				if (clickcount > count) {
					System.out.println("Please check missing documents/Please check schedular timings");
				}
				break;
			} catch (Exception e) {
				System.out.println("Application not found");
				flag = false;
			}
		}

	}

	public void loanEntryLoantypedropdown(String loantype) throws InterruptedException {
		WebDriverUtility wutil = new WebDriverUtility();
		Thread.sleep(5000);
		WebElement laontypedropdown1 = driver
				.findElement(By.xpath("//*[text()='Loan Type']/parent::label/parent::span/parent::div"));
		laontypedropdown1.click();
		WebElement loantypevalues = driver.findElement(By.xpath(
				"//div[@role='listbox']//child::mat-option[1]/child::span[contains(text(),'" + loantype + "')]"));
		loantypevalues.click();
		Thread.sleep(3000);
	}

	public void loanEntrypartnerDropdown1() throws InterruptedException, IOException {
		String partnername = eutil.toGetDataFromExcelSheet("partners", 4, 0);
		Thread.sleep(1000);
		WebElement partnerdropdown = driver.findElement(By.xpath(
				"//*[text()='Partner']/parent::label/parent::span/preceding-sibling::mat-select/parent::div/parent::div/parent::div"));
		Thread.sleep(2000);
		partnerdropdown.click();
		WebElement partnerid = driver.findElement(By.xpath("//*[text()='" + partnername + "']"));
		System.out.println(partnerid);
		partnerid.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@placeholder='Enter search text']")).sendKeys(Keys.TAB);
		Thread.sleep(4000);
	}

	public void missingDetails() throws IOException, InterruptedException {
		Thread.sleep(5000);
		String mobilenumber = eutil.toGetDataFromExcelSheet("loandetails", 3, 0);
		String partneloanid = eutil.toGetDataFromExcelSheet("loandetails", 3, 1);
		String partnercustomerid = eutil.toGetDataFromExcelSheet("loandetails", 3, 2);
		WebElement missingdetailslink = driver.findElement(By.xpath("//*[text()=' " + partneloanid
				+ " ']//following-sibling::td[text()=' " + mobilenumber + " ']/following-sibling::td[text()=' "
				+ partnercustomerid + " ']//following-sibling::td/child::span[text()='Missing Details']"));
		missingdetailslink.click();
		Thread.sleep(2000);
		List<WebElement> missingrequireddata = driver
				.findElements(By.xpath("//div[text()='Reason for incomplete']/parent::div//following-sibling::div[1]"));
		for (WebElement data : missingrequireddata) {
			String missingdata = data.getText();
			System.out.println("missing required datas are :" + missingdata);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()=' Copy ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Cancel']")).click();
		Thread.sleep(5000);
	}

	public void generateApprovalMISreport() throws Exception {
		Thread.sleep(5000);
		// select porpose as internal/External (Expected: should choose External)
		driver.findElement(By.xpath("//*[text()='Purpose']/parent::label/parent::span//parent::div/parent::div"))
				.click();
		driver.findElement(By.xpath("//*[text()='External']")).click();

		// select report section
		WebElement reporttype = driver.findElement(By.xpath("//*[@formcontrolname='reportType']"));
		reporttype.click();
		driver.findElement(By.xpath("//span[text()='Approval']")).click();
		Thread.sleep(2000);
		reporttype.sendKeys(Keys.TAB);

		// select partners
		String partnername = eutil.toGetDataFromExcelSheet("partners", 4, 0);
		WebElement partner = driver.findElement(By.xpath("//mat-select[@ng-reflect-name='partners']"));
		partner.click();
		System.out.println("partnername :" + partnername);
		driver.findElement(By.xpath("//span[text()='" + partnername + "']")).click();
		partner.sendKeys(Keys.TAB);

		// Select Customer type
		WebElement customertype = driver.findElement(By.xpath("//mat-select[@formcontrolname='customerType']"));
		customertype.click();
		driver.findElement(By.xpath("//span[text()='JLG']")).click();
		customertype.sendKeys(Keys.TAB);

		// select Start date
		WebElement startdate = driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[1]"));
		startdate.click();
		// driver.findElement(By.xpath("//button[@aria-label='29 March
		// 2024']")).click();
		driver.findElement(By.xpath("//button[@aria-current='date']")).click();
		// select End date
		WebElement enddate = driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[2]"));
		enddate.click();
		// driver.findElement(By.xpath("//button[@aria-label='29 March
		// 2024']")).click();
		driver.findElement(By.xpath("//button[@aria-current='date']")).click();
		Thread.sleep(1000);

		// CLick Generate report button.
		WebElement generatebutton = driver.findElement(By.xpath("//span[text()=' Generate Report ']"));
		generatebutton.click();
		Thread.sleep(3000);
	}

	public void downloadApprovalMISReport(int partnerid, String customertype) throws Exception {
		WebElement downloadamisreport = driver
				.findElement(By.xpath("//td[text()='" + partnerid + "']/following-sibling::td[text()='" + customertype
						+ "']/parent::tr//child::div//child::span/child::span[text()='download_for_offline']"));
		downloadamisreport.click();
	}

	public void MoveDownloadedFileToProjectDirectory() throws InterruptedException, IOException {
//		String currentdateandtime = jutil.dateandtime();
//		System.out.println(currentdateandtime);
//		//GenerateApprovalReport_13_Success_JLG_20240403172554.xls
//		//20240403172556
//		String temppath = IconstantUtility.documentdocunloadpath + currentdateandtime + ".xls";
//		String permenantpath = IconstantUtility.documentmovedpath;
//		File sourceFile = new File(temppath);
//		File destinationFile = new File(permenantpath);
//		try {
//			// Copy file using Files.copy() method
//			Path sourcePath = Paths.get(sourceFile.getAbsolutePath());
//			Path destinationPath = Paths.get(destinationFile.getAbsolutePath());
//			Files.copy(sourcePath, destinationPath);
//			// Print confirmation message
//			System.out.println("File copied successfully.");
//		} catch (IOException e) {
//			// Handle exception if file copy fails
//			e.printStackTrace();
//		}
		String downloadFilepath = (System.getProperty("user.dir") + "\\download");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("approvalReport", downloadFilepath);
		options.setExperimentalOption("prefs", prefs);
	}

	public void loanReviewPendingReview() throws InterruptedException, IOException {
		Thread.sleep(3000);
		String mobilenumber = eutil.toGetDataFromExcelSheet("loandetails", 5, 0);
		String partneloanid = eutil.toGetDataFromExcelSheet("loandetails", 5, 1);
		String partnercustomerid = eutil.toGetDataFromExcelSheet("loandetails", 5, 2);
		driver.findElement(By.xpath("(//span[text()=' Loan Review ']/parent::span)[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()=' Pending ']/parent::span")).click();
		Thread.sleep(3000);
		WebElement reviewbutton = driver.findElement(By.xpath("//*[text()=' " + partneloanid
				+ " ']//following-sibling::td[@ng-reflect-ng-switch='buttonWithNotification']//child::span[text()='Review']"));
		wutil.toMouseHover(driver, reviewbutton);
		Thread.sleep(2000);
		reviewbutton.click();
		// verification by using mobilenumber
		String mobilenumberinunderwriting = driver.findElement(By.xpath("(//span[text()='" + mobilenumber + "'])[1]"))
				.getText();
		if (mobilenumber.equals(mobilenumberinunderwriting)) {

		} else {
			System.out.println("Invalid data");
		}
		Thread.sleep(3000);

	}

	public void toAgentInfo() throws InterruptedException {
		Thread.sleep(3000);
		WebElement AgentInfomenubutton = driver.findElement(By.xpath("//button[text()=' Agent Info ']"));
		AgentInfomenubutton.click();
		String AI1 = AgentInfomenubutton.getText();
		Thread.sleep(3000);
		WebElement Agentinfocategoryheading = driver.findElement(By.xpath("//h2[text()=' Agent Info ']"));
		String AI2 = Agentinfocategoryheading.getText();
		Thread.sleep(2000);
		if (AI1.equals(AI2)) {
			String agentinfobranchname = driver.findElement(By.xpath("//label[text()='Branch Name']")).getText();
			System.out.println("Agent info 1st parameter is branch: " + agentinfobranchname);
		} else {
			System.out.println("Something went wrong");
		}
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0);");
		Thread.sleep(2000);

	}

	public void toBasicCustomerInfo() throws InterruptedException, IOException {
		Thread.sleep(2000);
		WebElement basiccustomerinfo = driver.findElement(By.xpath("//button[text()=' Basic Customer Info ']"));
		basiccustomerinfo.click();
		String BCI1 = basiccustomerinfo.getText();
		Thread.sleep(3000);
		WebElement basiccustomerinfoheading = driver.findElement(By.xpath("//div[text()='Basic Customer Info']"));
		String BCI2 = basiccustomerinfoheading.getText();
		Thread.sleep(2000);
		// Edit Gender
		WebElement BasicCustomerInfoEdit = driver
				.findElement(By.xpath("//div[text()='Basic Customer Info']/parent::div//child::span[text()='Edit']"));
		BasicCustomerInfoEdit.click();
		driver.findElement(By.name("gender2")).click();
		Thread.sleep(2000);
		WebElement genderlist = driver.findElement(By.xpath("//span[text()=' Transgender ']"));
		genderlist.click();
		WebElement BasicCustomerSavebutton = driver
				.findElement(By.xpath("//div[text()='Basic Customer Info']/parent::div//span[text()='Save']"));
		BasicCustomerSavebutton.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0);");
		Thread.sleep(2000);
	}

	public void reworkApplication() throws InterruptedException {
		wutil.toScrollBottomOfthePage(driver);
		Thread.sleep(2000);
		WebElement evaluateButton = driver
				.findElement(By.xpath("//span[text()=' Evaluate Application']/parent::button[@id='reject']"));
		evaluateButton.click();
		Thread.sleep(1000);
		String confirmationpopup = driver.findElement(By.xpath("//h4[text()='Confirmation']")).getText();
		System.out.println(confirmationpopup);
		WebElement reworkbutton = driver.findElement(By.xpath(
				"//mat-radio-group[@name='rejectionTypeSelect']//child::mat-radio-button[@ng-reflect-value='retry']"));
		reworkbutton.click();
		Thread.sleep(3000);
		WebElement categoryOfReasonDropdown = driver
				.findElement(By.xpath("//mat-placeholder[text()='Category of Reasons']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", categoryOfReasonDropdown);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Loan Application related discrepancies ']")).click();
		Thread.sleep(2000);
		WebElement rejectreason = driver
				.findElement(By.xpath("//textarea[@id='mat-input-0' or @name='rejectionReason']"));
		rejectreason.sendKeys("Kyc data not available");
		driver.findElement(By.xpath("//span[text()='Resubmit Loan Documents']")).click();
		WebElement evaluate = driver.findElement(By.xpath("//span[text()='Yes,Evaluate']/parent::span/parent::button"));
		if (evaluate.isEnabled()) {
			evaluate.click();
		} else {
			System.out.println("Evaluate is not enabled");
		}

	}
	public void finalRejectApplication() throws InterruptedException {
		wutil.toScrollBottomOfthePage(driver);
		Thread.sleep(2000);
		WebElement evaluateButton = driver
				.findElement(By.xpath("//span[text()=' Evaluate Application']/parent::button[@id='reject']"));
		evaluateButton.click();
		Thread.sleep(1000);
		String confirmationpopup = driver.findElement(By.xpath("//h4[text()='Confirmation']")).getText();
		System.out.println(confirmationpopup);
		WebElement reworkbutton = driver.findElement(By.xpath(
				"//mat-radio-group[@name='rejectionTypeSelect']/child::span[2]//child::span[text()='Final Reject']"));
		reworkbutton.click();
		Thread.sleep(3000);
		WebElement categoryOfReasonDropdown = driver
				.findElement(By.xpath("//mat-placeholder[text()='Category of Reasons']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", categoryOfReasonDropdown);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Loan Application related discrepancies ']")).click();
		Thread.sleep(2000);
		WebElement rejectreason = driver
				.findElement(By.xpath("//textarea[@id='mat-input-0' or @name='rejectionReason']"));
		rejectreason.sendKeys("Kyc data not available");
//		driver.findElement(By.xpath("//span[text()='Resubmit Loan Documents']")).click();
//		WebElement evaluate = driver.findElement(By.xpath("//span[text()='Yes,Evaluate']/parent::span/parent::button"));
//		if (evaluate.isEnabled()) {
//			evaluate.click();
//		} else {
//			System.out.println("Evaluate is not enabled");
//		}

	}

	public void approveApplication() throws InterruptedException {
		wutil.toScrollBottomOfthePage(driver);
		Thread.sleep(2000);
		WebElement ApproveButton = driver.findElement(
				By.xpath("//span[text()=' Approve Application']/parent::button[@id='conditionalapprove']"));
		ApproveButton.click();
		Thread.sleep(1000);
		String confirmationpopup = driver.findElement(By.xpath("//h4[text()='Confirmation']")).getText();
		System.out.println(confirmationpopup);
		WebElement commentbox = driver.findElement(By.xpath("//textarea[@ng-reflect-name='comment']"));
		commentbox.sendKeys("Approved");
		Thread.sleep(3000);
		//WebElement Approvebutton = driver.findElement(By.xpath("//span[text()='Yes, Approve']/parent::button"));
		//Approvebutton.click();
	}

}
