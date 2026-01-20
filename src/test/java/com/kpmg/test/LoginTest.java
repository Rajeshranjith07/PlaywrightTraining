package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;

public class LoginTest extends AutomationWrapper {
	
	@Test
	public void validLoginTest()
	{
		page.locator("//input[@name='username']").fill("Admin");
		page.locator("//input[@name='password']").fill("admin123");
		page.locator("//button[contains(normalize-space(),'Login')]").click();
		
	    String header=page.locator("//h6[contains(normalize-space(),'Dashb')]").innerText();
	    Assert.assertEquals(header, "Dashboard");
	
	}
	
	@Test
	public void invalidLoginTest()
	{
		page.locator("//input[@name='username']").fill("Admin");
		page.locator("//input[@name='password']").fill("admin7");
		page.locator("//button[contains(normalize-space(),'Login')]").click();
		
	    String InvalidError=page.locator("//p[text()='Invalid credentials']").innerText();
	    Assert.assertEquals(InvalidError, "Invalid credentials");
	
	}

}
