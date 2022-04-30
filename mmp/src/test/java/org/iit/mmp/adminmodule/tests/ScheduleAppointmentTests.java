package org.iit.mmp.adminmodule.tests;

import java.io.IOException;
import java.util.HashMap;

import org.iit.mmp.adminmodule.pages.AdminHomePage;
import org.iit.mmp.adminmodule.pages.AdminPortalPage;
import org.iit.mmp.base.TestBase;
import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.iit.mmp.utility.Utility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScheduleAppointmentTests  extends TestBase{
	
	HelperClass helperObj;
	ScheduleAppointmentPage SAPage;
	
	String filePath = System.getProperty("user.dir")+"\\data\\loginTestData.xls";
	
	@Test( description="US_004 Schedule Appointment",groups={"US_004","regression","sanity","patientmodule"})
	public void validateAppointmentDetails() throws Exception, IOException {
		
		instantiateDriver();
		helperObj=new HelperClass(driver);
		helperObj.launchApplicationURL("adminmodule");
		helperObj.captureScreenshot("US_001_LaunchApplication");
		helperObj.adminLogin();
		helperObj.captureScreenshot("US_002_verifyValidLogin");
		helperObj.moduleNavigation("Patients");
		
		AdminPortalPage adminPortalPage=new AdminPortalPage(driver);
		helperObj.moduleNavigation("Patients");
		adminPortalPage.searchforPatient("UserTest");
		AdminHomePage adminhomePage=new AdminHomePage(driver);
		adminhomePage.clickOnCreateVisit();
		helperObj.captureScreenshot("US003_clickOnCreateVisit");
		SAPage = new ScheduleAppointmentPage(driver);
		 
		HashMap<String,String> hMap=SAPage.selectDoctor("adminmodule");
		helperObj.launchApplicationURL("adminmodule");
		helperObj.moduleNavigation("HOME");
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(SAPage.validateAppointmentDetailsinHomePage(hMap),"");

	}

	@DataProvider (name="testData")
	public String [][] logiData() throws Exception, IOException{

		String [][] loginData = Utility.readXls(filePath);
		return loginData;
	}

	

}
