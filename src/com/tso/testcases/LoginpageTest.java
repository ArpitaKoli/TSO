package com.tso.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.BasicConfigurationFactory.BasicConfiguration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tso.pageobjects.Loginpage;
import com.tso.pageobjects.Taskspage;
import com.tso.pageobjects.TimeTrackpage;
import com.tso.setup.Basepage;


public class LoginpageTest extends Basepage
{
	Loginpage loginpage;
	TimeTrackpage timetrackpage;
	Taskspage taskpage;
	
	@Test
	public void loginTest() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		loginpage=new Loginpage(driver);
		wait.until(ExpectedConditions.titleContains("actiTIME - Login"));
		timetrackpage=loginpage.login("admin", "manager");
		//TimeTrackpage t=new TimeTrackpage(driver);
		wait.until(ExpectedConditions.titleContains("actiTIME - Enter Time-Track"));
		Assert.assertEquals("actiTIME - Enter Time-Track", timetrackpage.gettitle());
		Assert.assertTrue(timetrackpage.verifylogoutlink());
		timetrackpage.logout();	
	}
}
//hub