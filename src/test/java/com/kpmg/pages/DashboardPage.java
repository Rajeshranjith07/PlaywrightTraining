package com.kpmg.pages;

import com.microsoft.playwright.Page;

public class DashboardPage {
	
private Page page;
private String dashboardHeaderLocator= "//h6[contains(normalize-space(),'Dashb')]"
;	
	public DashboardPage(Page page)
	{
		this.page=page;
		
	}
	
	public String getDashboardHeader( )
	{
		String actualValue=page.locator(dashboardHeaderLocator).innerText();
		return actualValue;
	}

}
