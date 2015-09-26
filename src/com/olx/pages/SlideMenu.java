package com.olx.pages;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.olx.test.CommonFunctions;

public class SlideMenu {
	CommonFunctions commonFunctions = new CommonFunctions();
	
	private By homeText = By.name("Home");
	private By browseAdText = By.name("Browse Ads");
	private By submitAd = By.name("Submit a Free Ad");
	
	public boolean isHomeOptionPresent(WebDriver wd){
		return commonFunctions.checkIfElementPresent(wd, homeText);
	}
	
	public void clickOnHome(WebDriver wd) throws ParseException {
		commonFunctions.click(wd, homeText, "Home text in sliding Menu");
	}
	
	public void clickOnBrowseAd(WebDriver wd) throws ParseException {
		commonFunctions.click(wd, browseAdText, "On Browse Ad text in sliding menu");
	}
	
	public void clickOnSubmitNewAd(WebDriver wd) throws ParseException {
		commonFunctions.click(wd, submitAd, "Submit new Add button in sliding menu");
	}

}
