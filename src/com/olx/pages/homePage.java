package com.olx.pages;

import io.appium.java_client.android.AndroidDriver;

import java.text.ParseException;
import java.util.Locale.Category;

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
	
	public void NavigateToCategory(AndroidDriver<?> aD, WebDriver wd, String Category, String SubCategory) throws ParseException {
		commonFunctions.scrollToElementInLowerPage(aD, By.name(Category));
		commonFunctions.click(wd, By.name(Category), Category+" category on Home Screen");
		commonFunctions.scrollToElementInLowerPage(aD, By.name(SubCategory));
		commonFunctions.click(wd, By.name(SubCategory), SubCategory + " under" + Category +" on home screen");
	}

}

