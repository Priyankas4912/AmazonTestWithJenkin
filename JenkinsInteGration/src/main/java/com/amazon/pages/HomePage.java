package com.amazon.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.junit.ArrayAsserts;

import com.amazon.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(id="twotabsearchtextbox")
	WebElement fieldKeywords;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(xpath="//span[text()='Redmi']")
	WebElement redmeCheckBox;
	
	@FindBy(xpath="//a[@class='a-link-normal a-text-normal']")
	public List<WebElement> mobileLink;
	public ArrayList<String> mobile;
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchItems()
	{
		System.out.println("in Search Item function");
		fieldKeywords.sendKeys("Mobile");
		
		searchButton.click();
		
		redmeCheckBox.click();
	}
	
	
	public ArrayList<String> getItems()
	{
		mobile=new ArrayList();
		for(int i=0;i<mobileLink.size();i++)
		{
			String name= mobileLink.get(i).getText();
			mobile.add(name);
			
			
		}
		
		return mobile;
	}
	
	
	
	
}
