package com.nagp.config;

import java.net.InetAddress;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport {
	public static ExtentReports extent;
	public static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	private static String filePath = "./extentreport.html";

	private static InetAddress ip;

	/**
	 * @author sanjeet.pandit
	 * @return
	 */
	public static ExtentReports GetExtent() {
		if (extent != null)
			return extent; // avoid creating new instance of html file
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter());
		return extent;
	}

	/**
	 * @author sanjeet.pandit
	 * @return
	 */
	private static ExtentHtmlReporter getHtmlReporter() {
		try {
			ip = InetAddress.getLocalHost();

			htmlReporter = new ExtentHtmlReporter(filePath);

			htmlReporter.config().setDocumentTitle("Recon automation report");
			htmlReporter.config().setReportName("Build_");

			htmlReporter.config().setReportName("Build_");
			htmlReporter.config().setTheme(Theme.STANDARD);

			extent.setSystemInfo("OS", System.getProperty("os.name").toUpperCase());
			extent.setSystemInfo("Host Name", ip.getHostName());
			extent.setSystemInfo("IP ", ip.toString());
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Environment", "QA");

			return htmlReporter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return htmlReporter;
	}

}
