package com.bookstoreui;

import com.aventstack.extentreports.Status;
import com.bookstoreui.Reporter.ExtentReport;
import com.bookstoreui.core.BaseTest;
import com.bookstoreui.core.DriverManager;
import com.bookstoreui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;
    private WebDriver driver;
    private DriverManager driverManager;

    @BeforeTest
    public void setup(){
        driverManager=new DriverManager();
        driver=driverManager.getDriver();
        loginPage=new LoginPage(driver);
    }


    @Test(description = "verify Login header")
    public void verifyLoginHeader(){
        Assert.assertEquals(loginPage.loginHeaderPresence(),true);
        ExtentReport.test.log(Status.PASS,"Login header is present");
    }

    @Test(description = "verify username textbox")
    public void verifyUsernametextBox(){
        Assert.assertEquals(loginPage.usernameTextBoxPresence(),true);
        ExtentReport.test.log(Status.PASS,"username textbox is present");
    }

    @Test(description = "verify password text box")
    public void verifyPasswordtextBox(){
        Assert.assertEquals(loginPage.passwordTextBoxPresence(),true);
        ExtentReport.test.log(Status.PASS,"password text box is present");
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
