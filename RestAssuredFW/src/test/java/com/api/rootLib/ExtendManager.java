package com.api.rootLib;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendManager {
	private static ExtentReports extent;
	private static String reportFileName="Test-Execution-Report"+".html";
	public static ExtentReports getInstance() {
		if(extent==null)
			createInstance();
		return extent;
	}
	//create an extent report instance
	private static ExtentReports createInstance() {
		Date d=new Date();
		String currentTime=d.toString();
		currentTime=currentTime.replaceAll(" ", "").replaceAll(":","");
		reportFileName=	reportFileName+currentTime;
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("./TestReport/test-report"+currentTime+".html");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setEncoding("uft-8");
		htmlReporter.config().setReportName(reportFileName);
		htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd.yyyy,hh:mm a'('ZZZ')'");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		//set environmental details
		extent.setSystemInfo("OS","Windows");
		extent.setSystemInfo("AUT", "Sushma");
		
		return extent;
		
	}
	}


