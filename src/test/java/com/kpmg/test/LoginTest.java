package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.kpmg.utilities.DataSource;

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
	
	@Test(dataProviderClass = DataSource.class,dataProvider = "invalidLoginData")
	public void invalidLoginTest(String username, String password, String expectedError)
	{
		page.locator("//input[@name='username']").fill(username);
		page.locator("//input[@name='password']").fill(password);
		page.locator("//button[contains(normalize-space(),'Login')]").click();
		
	    String InvalidError=page.locator("//p[text()='Invalid credentials']").innerText();
	    Assert.assertEquals(InvalidError, expectedError);
	
	}

}
