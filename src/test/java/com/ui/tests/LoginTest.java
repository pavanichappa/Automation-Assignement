package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "verify if a valid user is able to login to the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "Login test data provider")
	public void loginTest(User user) {

		Assert.assertEquals(
				homePage.clickSignIn().clickSignInButton(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Jatin Sharma");

	}

	@Test(description = "verify if a valid user is able to login to the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "Login test CSV data provider")
	public void loginCsvTest(User user) {

		Assert.assertEquals(
				homePage.clickSignIn().clickSignInButton(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Jatin Sharma");

	}

	@Test(description = "verify if a valid user is able to login to the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "Login test Excel data provider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {
		
		Assert.assertEquals(
				homePage.clickSignIn().clickSignInButton(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Jatin Sharma1");
		
	}

}
