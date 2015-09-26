package com.olx.pages;

import java.lang.reflect.Array;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.olx.test.CommonFunctions;
import com.thoughtworks.selenium.webdriven.commands.Click;

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
	

	public void enterAdDetails(WebDriver wd, String title, String[] Category, String description, String location , String name, String email, String phoneNumber ) {
		commonFunctions.enterValue(wd, adTitleField, title);
		commonFunctions.click(wd, chooseCategoryField);
		for(int i=0; i<=Category.length; i++)
		{
			commonFunctions.click(wd, By.name(Category[i]));
		}
		for(int i=0; i<=Category.length; i++)
		{
			commonFunctions.navigateUp(wd);
		}
		commonFunctions.enterValue(wd, descriptionField, description);
		commonFunctions.enterValue(wd, nameField, name);
		commonFunctions.enterValue(wd, emailAddressField, email);
		commonFunctions.enterValue(wd, phoneNumberField, phoneNumber);
		
	}
}
