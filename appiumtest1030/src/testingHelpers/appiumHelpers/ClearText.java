package testingHelpers.appiumHelpers;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;


public class ClearText {
	
	
	public static void clearPassword(AndroidElement element, int pwdLength, AndroidDriver<?> driver){
		String text = element.getAttribute("text");
		System.out.println(text);
		element.click();
		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_MOVE_END);
		
		for (int i = 0; i < pwdLength; i++){
			driver.pressKeyCode(AndroidKeyCode.DEL);
		}
	}
	
	
	public static void clearPassword(AndroidElement element, AndroidDriver<?> driver){
		clearPassword(element, 20, driver);
	}
}
