package org.iit.mmp.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminHomePage {
	WebDriver driver;
	public AdminHomePage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void clickOnCreateVisit()
	{
		driver.findElement(By.xpath("//input[@value='Create Visit']")).click();
		
	}
}
