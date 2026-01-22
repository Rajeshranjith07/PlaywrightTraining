package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.kpmg.base.AutomationWrapper;
import com.kpmg.pages.LoginPage;

public class LoginUITest extends AutomationWrapper {
	
	
	@Test
	public void titleTest() {
		System.out.println("Title test");
		String actualTilte = page.title();
		System.out.println(actualTilte);
		Assert.assertEquals(actualTilte, "OrangeHRM");
	}

	
	@Test
	public void headerTest() {
		System.out.println("Header test");
		String headerText = page.locator("//h5").innerText();
		Assert.assertEquals(headerText, "Login");

	}
	
	@Test
	public void placeholderTest() {
		
		LoginPage login=new LoginPage(page);
		
		Assert.assertEquals(login.getUsernamePlaceholder(), "Username");
		Assert.assertEquals(login.getPasswordPlaceholder(), "Password");
				
	}

}
