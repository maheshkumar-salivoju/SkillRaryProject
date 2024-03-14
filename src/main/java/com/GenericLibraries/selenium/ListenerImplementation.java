package com.GenericLibraries.selenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + "Exicution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + "Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriverUtility web =new WebDriverUtility();
		web.takeScreenshot(BaseClass.sdriver, BaseClass.sjutil, result.getMethod().getMethodName());
		System.out.println(result.getMethod().getMethodName()+ "Test Failed");
		System.out.println("Failure occurred due to: " + result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ "Test Skipped");
		System.out.println("Skipped due to : " + result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("********************Test Started******************");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("**************************************Suite Execution Ends*********************************");
	}
	
	

}
