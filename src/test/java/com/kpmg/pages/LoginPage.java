package com.kpmg.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	public static void enterUserName(Page page, String username)
	{
		page.locator("//input[@name='username']").fill(username);
	}
	
	public static void enterPassword(Page page, String password)
	{
		page.locator("//input[@name='password']").fill(password);
	}


}
