package testingHelpers.appiumHelpers;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.appium.java_client.AppiumDriver;
import testingHelpers.util.Action;
import testingHelpers.util.Common;


public abstract class BaseTestCase {


	protected abstract String getAppFileName();
	
	
	protected AppiumDriver<?> driver;
	
	
	@Before
	public void setUp() throws Exception {
		MyCapabilities capabilities = new AndroidCapabilities();
		capabilities.app(Common.getAppPath(this.getAppFileName()));
		driver = capabilities.CreateDriver();
		Action.SetDriver(driver);
	}

	@After
	public void tearDown() throws Exception {
		
		driver.closeApp();
		driver.quit();
	}

	@Test
	public abstract void test();
	


}
