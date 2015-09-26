package com.olx.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

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
			wd.findElement(element).click();
			return true;
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void click(WebDriver wd, By element) {
		try {
			wd.findElement(element).click();
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void navigateUp(WebDriver wd) {
		By navigate = By.name("Navigate up");
		click(wd, navigate);
	}

}
