package com.kpmg.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	public LoginPage(Page page)
	{
		this.page=page;
		
	}
	public void enterUserName(String username)
	{
		page.locator("//input[@name='username']").fill(username);
	}
	
	public void enterPassword(String password)
	{
		page.locator("//input[@name='password']").fill(password);
	}
	
	public void clickOnLogin( )
	{
		page.locator("//button[contains(normalize-space(),'Login')]").click();
	}
	
	public String getInvalidErrorMessage( )
	{
		 String InvalidError=page.locator("//p[text()='Invalid credentials']").innerText();
		 return InvalidError;
	}
	


}
