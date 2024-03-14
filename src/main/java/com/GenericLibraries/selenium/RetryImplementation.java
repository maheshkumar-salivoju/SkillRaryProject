package com.GenericLibraries.selenium;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author mahes
 */

public class RetryImplementation implements IRetryAnalyzer{
	int maxRetries = 3;
	int count;
	@Override
	public boolean retry(ITestResult result) {
		if (count < maxRetries) {
			count++;
			return true;
		}
		return false;
	}
}
