package KcreditPageReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
	
	//constructor
	public OverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSignoutbutton() {
		return signoutbutton;
	}

	public WebElement getHelpButton() {
		return helpButton;
	}

	@FindBy (xpath="//button[text()=' Logout ']")
	private WebElement signoutbutton;
	
	@FindBy (xpath="//button[text()=' Help ']")
	private WebElement helpButton;
	
	@FindBy (xpath="//mat-icon[text()='arrow_drop_down']")
	private WebElement logoutmenubutton;

	public WebElement getLogoutmenubutton() {
		return logoutmenubutton;
	}
	
	
	
	

}
