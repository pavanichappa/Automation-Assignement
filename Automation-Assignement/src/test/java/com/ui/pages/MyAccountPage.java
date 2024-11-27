package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class MyAccountPage extends BrowserUtility {
	
	private static final By USER_NAME = By.xpath("//a[@title = \"View my customer account\"]/span");
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public MyAccountPage(Browser browser) {
		super(browser);
	}
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {
		logger.info("Checking user profile name");
		return getVisibleText(USER_NAME);
		
	}

}
