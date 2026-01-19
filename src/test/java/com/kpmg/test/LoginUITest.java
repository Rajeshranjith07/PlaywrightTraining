package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class LoginUITest {
	Playwright playwright;
	Page page;
	
	@BeforeMethod
	public void setup() {
		playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
		BrowserContext context = browser.newContext(); // kind of profile in browser
		page = context.newPage(); // tab 1
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@AfterMethod
	public void teardown() {
		playwright.close();
	}

	
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
