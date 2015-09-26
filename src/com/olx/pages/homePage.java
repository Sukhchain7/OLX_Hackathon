package com.olx.pages;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.olx.test.CommonFunctions;

public class homePage {
	CommonFunctions commonFunctions = new CommonFunctions();
	
	private By submitAd = By.name("Submit a Free Ad");
	
	public boolean issubmitAdPresent(WebDriver wd){
		return commonFunctions.checkIfElementPresent(wd, submitAd);
	}

	public void clickOnSubmitNewAd(WebDriver wd) throws ParseException {
		commonFunctions.click(wd, submitAd, "Submit new Add button in sliding menu");
	}

}

