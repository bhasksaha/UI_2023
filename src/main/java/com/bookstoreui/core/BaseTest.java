package com.bookstoreui.core;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.bookstoreui.Reporter.ExtentReport;
import com.bookstoreui.utils.Helper;
import com.bookstoreui.utils.Waits;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    private DriverManager driverManager=new DriverManager();

    @BeforeTest
    public void init(){
        driverManager.browserSetup();
    }

    @BeforeMethod
    public void extentStartTest(ITestResult result, Method method){
        ExtentReport.test=ExtentReport.report.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());

    }

    @AfterMethod
    public void getTestStatus(ITestResult result){
        Waits waits=new Waits();
        if(result.getStatus()==ITestResult.SUCCESS){
            ExtentReport.test.pass("Test Case : "+result.getName()+" is passed");
            ExtentReport.test.addScreenCaptureFromPath(waits.screenshot(driverManager.getDriver(), result.getName(),driverManager.reportPath));
        }else if(result.getStatus()==ITestResult.FAILURE){
            ExtentReport.test.fail("Test Case : "+result.getName()+" is failed");
            ExtentReport.test.fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(waits.screenshot(driverManager.getDriver(), result.getName(),driverManager.reportPath)).build());
        }else if(result.getStatus()==ITestResult.SKIP){
            ExtentReport.test.skip("Test Case : "+result.getName()+" is skipped");
        }
    }

    @AfterSuite
    public void enReport(){
        ExtentReport.report.flush();
    }
}
