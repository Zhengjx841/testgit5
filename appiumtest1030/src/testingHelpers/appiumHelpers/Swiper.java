package testingHelpers.appiumHelpers;

import io.appium.java_client.AppiumDriver;


public class Swiper {

	
	public static void toUp(AppiumDriver<?> driver){
		   int width = driver.manage().window().getSize().getWidth();
	        int height = driver.manage().window().getSize().getHeight();
	        
	        driver.swipe(width / 2, height * 2 / 5, width / 2, height / 5, 2000);
	}
	
	
	public static void toDown(AppiumDriver<?> driver){

		   int width = driver.manage().window().getSize().getWidth();
	        int height = driver.manage().window().getSize().getHeight();
	        
	        driver.swipe(width / 2, height  / 5, width / 2, height * 2 / 5, 2000);
	}
	

	public static void toLeft(AppiumDriver<?> driver){

		   int width = driver.manage().window().getSize().getWidth();
	        int height = driver.manage().window().getSize().getHeight();
	        
	        driver.swipe(width / 2, height  * 2  / 5, width / 4, height * 2 / 5, 2000);
	}
	
	
	public static void toRight(AppiumDriver<?> driver){

		   int width = driver.manage().window().getSize().getWidth();
	        int height = driver.manage().window().getSize().getHeight();
	        
	        driver.swipe(width / 2, height  * 2  / 5, width * 3 / 4, height * 2 / 5, 2000);
	}
	
}
