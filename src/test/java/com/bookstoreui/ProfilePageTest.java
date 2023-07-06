package com.bookstoreui;

import com.aventstack.extentreports.Status;
import com.bookstoreui.Reporter.ExtentReport;
import com.bookstoreui.core.BaseTest;
import com.bookstoreui.core.DriverManager;
import com.bookstoreui.pages.ProfilePage;
import com.bookstoreui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProfilePageTest extends BaseTest {

    private LoginPage loginPage;
    private ProfilePage profilePage;
    private WebDriver driver;
    private DriverManager driverManager;

    @BeforeTest
    public void setup(){
        driverManager=new DriverManager();
        driver=driverManager.getDriver();
        loginPage=new LoginPage(driver);
        profilePage=loginPage.loginIntoApp(driver);

    }

    @Test(description = "validate profile page heading")
    public void verifyProfilePageHeading(){

        Assert.assertEquals(profilePage.profilePageheading(driver),true);
        ExtentReport.test.log(Status.PASS,"profile page heading is present");
    }

    @Test(description = "validate delete all books from profile page")
    public void deleteAllBooks(){
        profilePage.deleteAllBooks(driver);
        Assert.assertEquals(profilePage.validateNoBooksPresent(),true);
        ExtentReport.test.log(Status.PASS,"all books deleted from profile page");
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
