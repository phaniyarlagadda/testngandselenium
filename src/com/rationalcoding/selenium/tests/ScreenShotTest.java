package com.rationalcoding.selenium.tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.rationalcoding.selenium.utils.SeleniumTestsDebugListener;
import com.rationalcoding.selenium.utils.SeleniumUtils;

/**
 * Test to demonstrate screenshot functionality
 * @author yarlagadda
 *
 */
@Listeners({SeleniumTestsDebugListener.class})
public class ScreenShotTest {

	private WebDriver webdriver;

	@BeforeTest
	public void setUp() {
		webdriver = SeleniumUtils.getWebDriver();
	}

	@AfterTest
	public void tearDown() {
		webdriver.quit();
	}

	@Test
	public void testWhichFails() throws InterruptedException {
		webdriver.get("http://rationalcoding.blogspot.com");
		// this is to wait for page to load
		// since page loads content dynamically we have sleep
		// in general we have other techniques to wait
		Thread.sleep(2000);
		Assert.fail("This test is failed intentionally to demonstrate screenshot functionality");
	}
}
