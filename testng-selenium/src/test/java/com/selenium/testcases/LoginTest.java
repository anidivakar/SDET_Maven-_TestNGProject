package com.selenium.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.keywords.Assertions;
import com.selenium.keywords.Generickeywords;

public class LoginTest extends Generickeywords{
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	static WebDriver driver;
	private Generickeywords keyword;
	public static Logger logger = null;
	Assertions assertion;
	

	@BeforeClass
	public void setUp1() throws IOException {
		LoginTest.logger = Logger.getLogger("LoginTestLogger");
		assertion = new Assertions();
	}


	
	@BeforeClass
	public void setUp2() throws Throwable {
		keyword = new Generickeywords();		
		keyword.launchBrowser("Chrome");
	}
	
		
	@Test
	public void sellerLogin(){
		try{
		keyword.navigate("url");	
		logger.info("User has navigated to the url");
		
		keyword.input(keyword.prop.getProperty("username"),"jacob");
		keyword.input(keyword.prop.getProperty("password"),"jacob");
		
		keyword.click(keyword.prop.getProperty("submit"));
		
		
		boolean loginresult = getObject(keyword.prop.getProperty("sellernewpageobject_xpath")).isDisplayed();
		
		if(loginresult){
			
		Assertions.pass();
		logger.error("Assertion SUCCESS");
		
		}else
		{
			Assertions.fail();	
			logger.error("Assertion FAILED");
		
		}
		}catch(Exception e){
			
			e.printStackTrace();
			logger.fatal("Something went Wrong", e);
		}
	}
	
}
