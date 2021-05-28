package com.amazon.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	
	ArrayList<String> listOfMobile;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initializeBrowser();
		
		homepage=new HomePage();
		
		homepage.searchItems();
		
	}
	
	@Test
	public void testSearchResult()
	{
		listOfMobile=homepage.getItems();
		
		System.out.println("size " + listOfMobile.size());
		
		for(String mobileName : listOfMobile)
		{ System.out.println(mobileName);
			Assert.assertTrue((mobileName.toLowerCase()).contains("redmi"));
		
		}
		
	}

}
