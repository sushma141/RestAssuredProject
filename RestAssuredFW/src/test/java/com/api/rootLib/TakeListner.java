package com.api.rootLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TakeListner implements ITestListener {
public void onStart(ITestContext Context) {
		System.out.println("*** TestSuite"+Context.getName()+"started***");	
	}
	
	public void onFinish(ITestContext Context) {
		
		System.out.println("*** TestSuite"+Context.getName()+"ending***");	
		ExtentTestManager.endTest();
		ExtendManager.getInstance().flush();
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result ) {
	System.out.println("*** Test failed but within percentage %"+result.getMethod().getMethodName());
		
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("***Test execution"+result.getMethod().getMethodName()+"failed---");
		ExtentTestManager.getTest().log(Status.FAIL,"TestFailed");	
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("***Test execution"+result.getMethod().getMethodName()+"skipped---");
		ExtentTestManager.getTest().log(Status.SKIP,"Testskipped");		
	}

	public void onTestStart(ITestResult result) {
	
		System.out.println("***Running test method"+result.getMethod().getMethodName()+"-----");
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("***executed"+result.getMethod().getMethodName()+"-----");
		ExtentTestManager.getTest().log(Status.PASS,"TestPassed");
	}

}
