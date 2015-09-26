package com.olx.test;


import io.appium.java_client.android.AndroidDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.seleniumhq.jetty7.util.log.Log;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.WebConsole.Logger;

public class CommonFunctions {
	
	
	public void setCapabilities(WebDriver wd, String OS, String OSversion, String apklocation, String AppPackage) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", OS);
		capabilities.setCapability("platformVersion", OSversion);
		capabilities.setCapability("app", apklocation);
		capabilities.setCapability("appPackage", AppPackage);
		wd = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	public static void copyFileUsingStream(String source, String dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}
	
	public boolean checkIfElementPresent(WebDriver wd, By element) {
		try {
			wd.findElement(element);
			return true;
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static long getCurrentTimeInMS() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "22-01-2015 10:20:56";
		Date date = sdf.parse(dateInString);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return (long) calendar.getTimeInMillis();
	}
	
	@SuppressWarnings("deprecation")
	public void click(WebDriver wd, By element, String elementName) throws ParseException {
		try {
			long beforetime = getCurrentTimeInMS();
			wd.findElement(element).click();
			long afterTime = getCurrentTimeInMS();
			long timetaken = afterTime - beforetime;
			Log.debug("OLX appium","Time taken to load"+elementName+" is "+timetaken +" ms");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.warn("OLX appium", elementName +" not found on ui");
		}
	}
	
	public void enterValue(WebDriver wd, By element, String value) {
		try {
			wd.findElement(element).sendKeys(value);
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startAppium() throws Exception
	{
		//Start the appium server
		CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
		command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.execute(command, resultHandler);
		Thread.sleep(5000); //Wait for appium server to start
	}
	
	public void navigateUp(WebDriver wd) throws ParseException {
		By navigate = By.name("Navigate up");
		click(wd, navigate, "Navigate up button");
		
	}
	
	public  void scrollToElementInLowerPage(AndroidDriver<?> driver,
			By element) {
		Dimension size = driver.manage().window().getSize();
		boolean found = false;
		while (!found) {
			if (checkIfElementPresent(driver, element)) {
				Point locat = driver.findElement(
						element).getLocation();
				int difference = size.getHeight() - locat.getY();
				if (difference <= 0.1 * size.getHeight()) {
					driver.swipe((int) (size.width * 0.5),
							(int) (size.height * 0.8),
							(int) (size.width * 0.5),
							(int) (size.height * 0.6), 2000);
				}
				found = true;
			} else {
				driver.swipe((int) (size.width * 0.5),
						(int) (size.height * 0.8), (int) (size.width * 0.5),
						(int) (size.height * 0.2), 2000);
			}
		}

}
	}

