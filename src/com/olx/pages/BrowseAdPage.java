package com.olx.pages;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.olx.test.CommonFunctions;

public class BrowseAdPage {
	
CommonFunctions commonFunctions = new CommonFunctions();
	
	private By allCategoriesText = By.name("");
	private By firstAd = By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.ListView[1]/android.widget.LinearLayout[2]");
	
	public void clickOnFirstAd(WebDriver wd) throws ParseException {
		commonFunctions.click(wd, firstAd, "Ads on browse ad page ");
	}
	

}
