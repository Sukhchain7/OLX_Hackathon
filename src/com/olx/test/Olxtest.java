package com.olx.test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.olx.pages.SlideMenu;
import com.olx.pages.SubmitAdPage;

public class Olxtest {
	WebDriver webDriver;
	CommonFunctions commonFunction = new CommonFunctions();
	SlideMenu sildeMenu = new SlideMenu();
	SubmitAdPage submitAd = new SubmitAdPage();
	
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
//	public void HomeLoaded(){
//		sildeMenu.isHomeOptionPresent(webDriver);
//	}
	
	@Test
	public void PostingTest(){
		sildeMenu.clickOnHome(webDriver);
		sildeMenu.clickOnSubmitNewAd(webDriver);
		String[] Categoris = {"Vehicles", "Scooters", "Bajaj"};
		submitAd.enterAdDetails(webDriver, "Title", Categoris, "I want to sell", "Banglore", "test", "test@mn.i", "xxxxxxxxxx");
	}
	

}
