package testingHelpers.appiumHelpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;




public abstract class MyCapabilities {

	private DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public DesiredCapabilities getDesiredCapabilities(){
		return capabilities;
	}
	
	public MyCapabilities(){
	}
	
	
	public abstract AppiumDriver<? extends WebElement> CreateDriver();
	
	public void setCapability(String key, String value){
		capabilities.setCapability(key, value);
	}

	public void setCapability(String key, boolean value){
		capabilities.setCapability(key, value);
	}

	public void setCapability(String key, int value){
		capabilities.setCapability(key, value);
	}

	public void setCapability(String key, Object value){
		capabilities.setCapability(key, value);
	}
	
	public void devideName(String value){
		setCapability("deviceName", value);
	}
	
	public void platformVersion(String value){
		setCapability("platformVersion", value);
	}
	
	public void app(String value){
		setCapability("app", value);
	}
	
	
	public void automationName(String value){
		this.setCapability("automationName", value);
	}
	
	
	
	public void platformName(String value){
		this.setCapability("platformName", value);
	}
	
	
	
	public void browserName(String value){
		this.setCapability("browserName", value);
	}
	
	
	
	public void newCommandTimeout(int value){
		this.setCapability("newCommandTimeout", value);
	}
	
	
	public void language(String value){
		this.setCapability("language", value);
	}
	
	
	
	public void locale(String value){
		this.setCapability("locale", value);
	}
	
	
	public void udid(String value){
		this.setCapability("udid", value);
	}
	
	
	public void orientation(String value){
		this.setCapability("orientation", value);
	}
	
	
	public void autoWebview(boolean value){
		this.setCapability("autoWebview", value);
	}
	
	
	public void noReset(boolean value){
		this.setCapability("noReset", value);
	}
	
	
	public void fullReset(boolean value){
		this.setCapability("fullReset", value);
	}
	
	public void unicodeKeyboard(boolean value){
		this.setCapability("unicodeKeyboard", value);
	}
	
	public void resetKeyboard(boolean value){
		this.setCapability("resetKeyboard", value);
	}
	
}
