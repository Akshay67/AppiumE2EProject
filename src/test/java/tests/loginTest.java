package tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPageObject;
import resources.BaseTest;

public class loginTest extends BaseTest {
	
	LoginPageObject lpo;
	
	@BeforeMethod
	public void BeforeMethod() {
	
		lpo = new LoginPageObject();
	
	}
	
	@Test
	public void enterUsernameOnly() {
		lpo.enter_user_name("Standard_user");
		lpo.click_on_login_btn();
	}
}
