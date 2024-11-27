package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.constants.Browser.*;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class LoginPage extends BrowserUtility {

	private static final By EMAIL_TEXTBOX = By.id("email");
	private static final By PASSWORD_TEXTBOX = By.id("passwd");
	private static final By SIGNIN_BUTTON = By.id("SubmitLogin");
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public LoginPage(Browser browser) {
		super(browser);
	}

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage clickSignInButton(String email, String password) {
		logger.info("Entering user credentials to sign in to user Myaccount Page");
		enterText(EMAIL_TEXTBOX, email);
		enterText(PASSWORD_TEXTBOX, password);
		clickOn(SIGNIN_BUTTON);
		
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}

}
