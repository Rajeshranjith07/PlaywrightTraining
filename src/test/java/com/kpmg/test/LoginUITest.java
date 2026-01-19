package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.kpmg.base.AutomationWrapper;

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

}
