package com.kpmg.pages;

import com.microsoft.playwright.Page;

public class DashboardPage {
	
private Page page;
	
	public DashboardPage(Page page)
	{
		this.page=page;
		
	}
	
	public String getDashboardHeader( )
	{
		String actualValue=page.locator("//h6[contains(normalize-space(),'Dashb')]").innerText();
		return actualValue;
	}

}
