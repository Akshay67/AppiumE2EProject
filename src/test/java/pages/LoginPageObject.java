package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.config.Config;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.BaseTest;

public class LoginPageObject extends BaseTest {
	
	public LoginPageObject() {
		
		PageFactory.initElements(new AppiumFieldDecorator(Config.driver), this);
	}
	
	//send key user name
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Username\")")
	private WebElement userNameTextField;
	
	public LoginPageObject enter_user_name(String username) {
		sendKeys(userNameTextField,username);
		return this;
		
	}
	
	//login button
	@AndroidFindBy(accessibility = "test-LOGIN")
	private WebElement loginBtn;
	
	public LoginPageObject click_on_login_btn() {
		click(loginBtn);
		
		return this;
	}
	

}
