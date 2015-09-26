package com.olx.pages;

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
	
	public void clickOnHome(WebDriver wd) {
		commonFunctions.click(wd, homeText);
	}
	
	public void clickOnBrowseAd(WebDriver wd) {
		commonFunctions.click(wd, browseAdText);
	}
	
	public void clickOnSubmitNewAd(WebDriver wd) {
		commonFunctions.click(wd, submitAd);
	}

}
