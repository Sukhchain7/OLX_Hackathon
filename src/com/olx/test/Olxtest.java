package com.olx.test;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.olx.pages.SlideMenu;
import com.olx.pages.SubmitAdPage;
import com.olx.pages.homePage;

public class Olxtest {
	WebDriver webDriver;
	AndroidDriver<?> androidDriver;
	CommonFunctions commonFunction = new CommonFunctions();
	SlideMenu sildeMenu = new SlideMenu();
	SubmitAdPage submitAd = new SubmitAdPage();
	homePage homePage = new homePage();
	
	@BeforeMethod
    public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("app", "/Users/sukhchain/Downloads/Hackathon_App-olxin-release.apk");
		webDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
        //wd.quit();
		//commonFunction.copyFileUsingStream("tmp/appium.log", "olxAppium/logs/appium.log");
    }
	
//	@Test
	public void HomeLoaded() throws ParseException{
		sildeMenu.clickOnHome(webDriver);
		homePage.issubmitAdPresent(webDriver);
	}
	
	@Test
	public void PostingTest() throws ParseException{
		sildeMenu.clickOnHome(webDriver);
		sildeMenu.clickOnSubmitNewAd(webDriver);
		String[] Categoris = {"Vehicles", "Scooters", "Bajaj"};
		submitAd.enterAdDetails(androidDriver, webDriver, "Title", Categoris, "I want to sell", "Banglore", "test", "test@mn.i", "xxxxxxxxxx");
	}
	
	@Test
	public void BrowseAds() throws ParseException{
		sildeMenu.clickOnBrowseAd(webDriver);
		
	}

}
