package KcreditPageReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	// constructor
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement usernameTextField;
	
	@FindBy(id="password")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//span[text()='Forgot Password?']")
	private WebElement forgotPassword;
	
	@FindBy(xpath="//mat-icon[text()='visibility_off']")
	private WebElement eyeIcon;

	public WebElement getEyeIcon() {
		return eyeIcon;
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getForgotPassword() {
		return forgotPassword;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	
}
