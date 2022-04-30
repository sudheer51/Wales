package org.iit.mmp.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPortalPage {
	WebDriver driver;
	public AdminPortalPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void searchforPatient(String patientName)
	{
		
		driver.findElement(By.id("search")).sendKeys(patientName);
		driver.findElement(By.xpath("//input[@value='search']")).click();
		driver.findElement(By.linkText(patientName)).click();
	}
	
}
