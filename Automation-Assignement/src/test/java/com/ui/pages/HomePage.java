package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

import static com.utility.JsonUtility.*;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser browser, Boolean isHeadLess) {
		super(browser, isHeadLess);
		// goToWebsite(readProperty(QA, "URL"));//use either properties or Json to read
		// the environments.
		// We have implemented both ways for learning purpose
		goToWebsite(readJson(QA).getUrl());

	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(readJson(QA).getUrl());
	}

	private static final By SIGNIN_LINK = By.linkText("Sign in");

	public LoginPage clickSignIn() {
		logger.info("Performing click action to go to Login Page");
		clickOn(SIGNIN_LINK);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public void quit() {
		exit();
		
	}
}
