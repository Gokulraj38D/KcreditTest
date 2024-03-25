package KcreditPageReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar {

	// cponstructor
	public SideBar(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),' Loan Entry ')]") 
	private WebElement LoanEntryMenubutton;
	
	@FindBy(xpath="//span[text()='description']")
	private WebElement LoanReviewMenuButton;
	
	@FindBy(xpath="//span[text()='file_upload']")
	private WebElement FileUploadMenuButton;
	
	@FindBy(xpath="//span[text()='pie_chart_outline']")
	private WebElement ReportswMenuButton;
	
	@FindBy(xpath="//span[contains(text(),'start')]")
	private WebElement loanEntryicon;

	public WebElement getLoanEntryicon() {
		return loanEntryicon;
	}

	public WebElement getLoanEntryMenubutton() {
		return LoanEntryMenubutton;
	}

	public WebElement getLoanReviewMenuButton() {
		return LoanReviewMenuButton;
	}

	public WebElement getFileUploadMenuButton() {
		return FileUploadMenuButton;
	}

	public WebElement getReportswMenuButton() {
		return ReportswMenuButton;
	}
	

}
