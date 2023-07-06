package com.bookstoreui.pages;


import com.bookstoreui.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public Waits waitObj=new Waits();
    WebDriver driver;
    ProfilePage homePage;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private enum LOGIN_PORTAL{

        USERNAME(By.id("userName")),
        PASSWORD(By.id("password")),
        LOGIN(By.xpath("//button[@id='login']")),
        LOGINHEADER(By.xpath("//div[text()='Login']"));
        private By findby;

        LOGIN_PORTAL(By locator){
            this.findby=locator;
        }
    }

    public ProfilePage loginIntoApp(WebDriver driver){
        waitObj.explicitWaitPresenceLocated(driver,LOGIN_PORTAL.USERNAME.findby).clear();
        waitObj.explicitWaitPresenceLocated(driver,LOGIN_PORTAL.USERNAME.findby).sendKeys("apitest1");
        waitObj.explicitWaitPresenceLocated(driver,LOGIN_PORTAL.PASSWORD.findby).clear();
        waitObj.explicitWaitPresenceLocated(driver,LOGIN_PORTAL.PASSWORD.findby).sendKeys("apitest@123");
        waitObj.explicitWaitPresenceLocated(driver,LOGIN_PORTAL.LOGIN.findby).click();
        homePage=new ProfilePage(driver);
        return homePage;
    }

    public boolean loginHeaderPresence(){
        waitObj.scrollToView(driver,LOGIN_PORTAL.LOGINHEADER.findby);
        return waitObj.explicitWaitPresenceLocated(driver,LOGIN_PORTAL.LOGINHEADER.findby).isDisplayed();
    }

    public boolean usernameTextBoxPresence(){
        return waitObj.explicitWaitPresenceLocated(driver,LOGIN_PORTAL.USERNAME.findby).isDisplayed();
    }

    public boolean passwordTextBoxPresence(){
        return waitObj.explicitWaitPresenceLocated(driver,LOGIN_PORTAL.PASSWORD.findby).isDisplayed();
    }
}
