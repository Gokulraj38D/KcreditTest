package KcreditPageReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgotpassword {
	
	// constructor
	
	public Forgotpassword(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="email")
	private WebElement forgotPasswordEmial;
	
	@FindBy(xpath="//span[text()='Reset Password']")
	private WebElement resetPasswordButton;
	
	
}
