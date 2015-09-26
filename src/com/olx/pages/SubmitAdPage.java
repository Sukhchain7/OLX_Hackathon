package com.olx.pages;

import io.appium.java_client.android.AndroidDriver;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.olx.test.CommonFunctions;

public class SubmitAdPage {
	
	CommonFunctions commonFunctions = new CommonFunctions();
	
	private By adTitleField = By.name("Ad Title (min. 15 chars)");
	private By chooseCategoryField = By.name("Choose category");
	private By descriptionField = By.name("Description (min. 20 chars)");
	private By locationField = By.name("Location");
	private By nameField = By.name("Name");
	private By emailAddressField = By.name("Email address");
	private By phoneNumberField = By.name("Phone number");
	private By submitButtonField = By.name("Submit Ad");
	

	public void enterAdDetails(AndroidDriver<?> aD, WebDriver wd, String title, String[] Category, String description, String location , String name, String email, String phoneNumber ) throws ParseException {
		commonFunctions.enterValue(wd, adTitleField, title);
		commonFunctions.click(wd, chooseCategoryField, "category text on Submit ad page");
		for(int i=0; i<=Category.length; i++)
		{
			commonFunctions.click(wd, By.name(Category[i]), Category[i]+" Category not found");
		}
		for(int i=0; i<=Category.length; i++)
		{
			commonFunctions.navigateUp(wd);
		}
		commonFunctions.scrollToElementInLowerPage(aD, descriptionField);
		commonFunctions.enterValue(wd, descriptionField, description);
		commonFunctions.scrollToElementInLowerPage(aD, locationField);
		commonFunctions.click(wd, locationField, "Location option on Submit ad page");
		commonFunctions.scrollToElementInLowerPage(aD, By.name(location));
		commonFunctions.click(wd, By.name(location), location+ " under locations");
		commonFunctions.scrollToElementInLowerPage(aD, nameField);
		commonFunctions.enterValue(wd, nameField, name);
		commonFunctions.scrollToElementInLowerPage(aD, emailAddressField);
		commonFunctions.enterValue(wd, emailAddressField, email);
		commonFunctions.scrollToElementInLowerPage(aD, phoneNumberField);
		commonFunctions.enterValue(wd, phoneNumberField, phoneNumber);
		commonFunctions.scrollToElementInLowerPage(aD, submitButtonField);
		commonFunctions.click(wd, submitButtonField, "Submit button on Submit ad page");
		
	}
}
