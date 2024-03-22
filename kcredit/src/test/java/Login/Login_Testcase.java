package Login;

import java.io.IOException;

import org.testng.annotations.Test;

import KcreditPageReposatory.Login;
import genericUtility.BaseClass1;
import genericUtility.ExcelSheetUtility;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;

public class Login_Testcase extends BaseClass1 {

	PropertiesFileUtility putil = new PropertiesFileUtility();
	ExcelSheetUtility eutil = new ExcelSheetUtility();
	WebDriverUtility wutil = new WebDriverUtility();

	@Test(priority = 1)
	public void Login_TC_001() throws IOException {
		String UsernameValidLogin = eutil.toGetDataFromExcelSheet("LOGINCRDS", 1, 0);
		String PasswordValidLogin = eutil.toGetDataFromExcelSheet("LOGINCRDS", 1, 1);
		Login login = new Login(driver);
		login.getUsernameTextField().sendKeys(UsernameValidLogin);
		login.getPasswordTextField().sendKeys(PasswordValidLogin);
		login.getLoginbutton().click();
	}

	@Test(priority = 2)
	public void Login_TC_002() throws IOException {
		BaseClass1 bs = new BaseClass1();
		bs.beforeClassConfiguration();
		String UsernameInvalidLogin1 = eutil.toGetDataFromExcelSheet("LOGINCREDS", 2, 0);
		String PasswordInvalidLogin1 = eutil.toGetDataFromExcelSheet("LOGINCREDS", 2, 1);
		Login login = new Login(driver);
		login.getUsernameTextField().sendKeys(UsernameInvalidLogin1);
		login.getPasswordTextField().sendKeys(PasswordInvalidLogin1);
		login.getLoginbutton().click();
	}

	@Test(priority = 3)
	public void Login_TC_003() throws IOException {
		BaseClass1 bs = new BaseClass1();
		bs.beforeClassConfiguration();
		String UsernameInvalidLogin2 = eutil.toGetDataFromExcelSheet("LOGINCRDS", 3, 0);
		String PasswordInvalidLogin2 = eutil.toGetDataFromExcelSheet("LOGINCRDS", 3, 1);
		Login login = new Login(driver);
		login.getUsernameTextField().sendKeys(UsernameInvalidLogin2);
		login.getPasswordTextField().sendKeys(PasswordInvalidLogin2);
		login.getLoginbutton().click();
	}
}
