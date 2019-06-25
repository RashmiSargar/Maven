package com.CRM.VisionIT.Screenshot.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.VisionIT.Pages.Login_Page;
import com.CRM.VisionIT.TestBase.Base_class;

import junit.framework.Assert;

public class Login_Test_Page extends Base_class
{
	static Login_Page loginpage;

	@BeforeMethod
	public void setup()
	{
		startBrowser(prop.getProperty("browsername"),prop.getProperty("url"));

		loginpage=new Login_Page();
	}

	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void verify_LoginPAge_Title()
	{
		String actualPageTitle=loginpage.Loginpage_title();
		System.out.println(actualPageTitle);
		String expectedPagetitle="CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals("Title of the Page doesn't match",actualPageTitle, expectedPagetitle);
	}

	@Test(priority=2)
	public void Verify_Login_Page()
	{
		loginpage.VerifyloginPage(prop.getProperty("username"),prop.getProperty("pass"));
	}

	@AfterMethod

	public void teardown()
	{
		driver.quit();
	}
}


