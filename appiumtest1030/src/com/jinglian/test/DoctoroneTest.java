package com.jinglian.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jinglian.TestDoctor;


public class DoctoroneTest extends TestDoctor{
	@Test
	public void test() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cn.kinglian.dc:id/tab_health_manager")));
		driver.findElement(By.id("cn.kinglian.dc:id/tab_health_manager")).click();
	}
}