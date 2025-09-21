package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.config.Config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.functions.ExpectedCondition;

public class BaseTest {
	
	public static Properties prop;
	
	@BeforeTest
	public void setUp() throws InterruptedException, IOException {
					
		DesiredCapabilities cap = new DesiredCapabilities();	
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		prop.load(fis); 
		
		String AndroidAppPackageName = prop.getProperty("AndroidAppPackageName");
		String AndroidAppActivityName = prop.getProperty("AndroidAppActivityName");
		String AutomationName = prop.getProperty("AndroidAppAutomationName");
		String URL = prop.getProperty("URL");
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:deviceName", "emulator-5554");
		cap.setCapability("appium:automationName", AutomationName);
		cap.setCapability("appium:appPackage", AndroidAppPackageName);
		cap.setCapability("appium:appActivity", AndroidAppActivityName);
	
			
		
		URL url = new URL(URL);
		
		Config.driver = new AppiumDriver(url,cap);
		
		System.out.println("application started..");
		Thread.sleep(6000);
	}
	
	public void waitVisibilityOfElement(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void click(WebElement element) {
		waitVisibilityOfElement(element);
		element.click();
	}
	
	public void sendKeys(WebElement element, String txt) {
		waitVisibilityOfElement(element);
		element.sendKeys(txt);
	}
	
	public String getAttribute(WebElement element, String attribute) {
		waitVisibilityOfElement(element);
		
		return element.getAttribute(attribute);
	}
}
