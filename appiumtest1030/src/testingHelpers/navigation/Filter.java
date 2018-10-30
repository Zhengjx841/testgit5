package testingHelpers.navigation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Filter {

	
	private FilterType filterType;
	

	private String value;

	public Filter(FilterType ft, String value){
		this.filterType = ft;
		this.value = value;
	}
	
	
	public WebElement filterElement(WebDriver driver){
		try {
			Method filterMethod = RemoteWebDriver.class.getDeclaredMethod(
					"findElement", String.class, String.class
					);
			filterMethod.setAccessible(true);
			return (WebElement) filterMethod.invoke((RemoteWebDriver)driver, filterType.getDescription(), value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	
	public List<WebElement> filterElements(WebDriver driver){		
		try {
			Method filterMethod = RemoteWebDriver.class.getDeclaredMethod(
					"findElements", String.class, String.class
					);
			filterMethod.setAccessible(true);
			return (List<WebElement>) filterMethod.invoke((RemoteWebDriver)driver, filterType.getDescription(), value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
//	private By getBy(){
//		switch (filterType) {
//		case ById:
//			return By.id(value);
//		case ByLinkText:
//			return By.linkText(value);
//		case ByPartialLinkText:
//			return By.partialLinkText(value);
//		case ByTagName:
//			return By.tagName(value);
//		case ByName:
//			return By.name(value);
//		case ByClassName:
//			return By.className(value);
//		case ByCssSelector:
//			return By.cssSelector(value);
//		case ByXPath:
//			return By.xpath(value);
//		case ByAccessibilityId:
//			
//		default:
//			return null;
//		}
//	}
	
}
