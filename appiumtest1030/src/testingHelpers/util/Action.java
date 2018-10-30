package testingHelpers.util;

import java.util.HashMap;

import org.openqa.selenium.remote.RemoteWebDriver;




public abstract class Action {

	protected static RemoteWebDriver driver;
	
	
	public static void SetDriver(RemoteWebDriver driver){
		Action.driver = driver;
	}
	
	
	protected static HashMap<String, Object> context = new HashMap<String, Object>();
	
	
	
	public void setParam(String name, Object value){
		context.put(name, value);
	}
	
	
	public String getParam(String name){
		return context.get(name).toString();
	}
	
	
	public abstract void perform();
	
	
}
