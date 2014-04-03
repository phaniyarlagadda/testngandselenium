package com.rationalcoding.selenium.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * Listener to handle different events of selenium tests
 * @author yarlagadda
 *
 */
public class SeleniumTestsDebugListener implements ITestListener{

	
	@Override
	public void onTestStart(ITestResult result) {
		// nothing to implement
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// dont do anything
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver webdriver = SeleniumUtils.getWebDriver();
		if(webdriver instanceof TakesScreenshot){
			String screenShotFileName = result.getMethod().getMethodName()+".png";
			File screenshotFile = new File(screenShotFileName);
			File capturedFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(capturedFile, screenshotFile);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}else{
			System.out.println("Unable to capture screenshot"+result.getMethod().getMethodName());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// dont do anything
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// dont do anything
		
	}

	@Override
	public void onStart(ITestContext context) {
		// dont do anything
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//dont do anything
		
	}

}
