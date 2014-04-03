package com.rationalcoding.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Util class for selenium functions
 * @author yarlagadda
 *
 */
public class SeleniumUtils {
	
	private static WebDriver webdriver;
	
	public static WebDriver getWebDriver(){
		if(webdriver == null){
			webdriver = new FirefoxDriver();
		}
		return webdriver;
	}

}
