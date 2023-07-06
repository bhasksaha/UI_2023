package com.bookstoreui.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bookstoreui.utils.Helper;

import java.util.Properties;

public class ExtentReport {

    public static ExtentReports report=null;
    public static ExtentTest test=null;
    private final static String configPath=System.getProperty("user.dir")+"/src/test/resources/config.properties";
//    private static Helper helpobj;

    public static void initialize(String reportPath) {
        if (report == null) {
            //exetent test
            Properties prop=new Helper().propertyReader(configPath);
            report = new ExtentReports();
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath + "/extent-report.html");//add to perties file
            reporter.config().setReportName("Books API Automation Report");
            reporter.config().setTheme(Theme.STANDARD);
            report.attachReporter(reporter);
            report.setSystemInfo("OS", prop.getProperty("OS"));
            report.setSystemInfo("Author", prop.getProperty("Author"));
            report.setSystemInfo("Environment", prop.getProperty("Environment"));
        }
    }
}
