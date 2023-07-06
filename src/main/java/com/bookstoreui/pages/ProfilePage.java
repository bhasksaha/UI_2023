package com.bookstoreui.pages;

import com.bookstoreui.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    WebDriver driver;

    public Waits waitObj=new Waits();
    LoginPage loginPage;

    public enum PROFILEPAGE{

        DELETEALLBOOKS(By.xpath("//button[text()='Delete Account']//following::button[text()='Delete All Books'][1]")),
        DELETECONFIRMATION(By.id("closeSmallModal-ok")),
        NOROWSFOUND(By.xpath("//div[text()='No rows found']")),
        PROFILEPAGEHEADING(By.xpath("//div[text()='Profile']"));
        private By findby;

        PROFILEPAGE(By locator){
            this.findby=locator;
        }
    }

    public ProfilePage(WebDriver driver){
        this.driver=driver;
        loginPage=new LoginPage(this.driver);
    }
    public void deleteAllBooks(WebDriver driver){
        waitObj.scrollToView(driver,PROFILEPAGE.DELETEALLBOOKS.findby);
        waitObj.explicitWaitPresenceLocated(driver,PROFILEPAGE.DELETEALLBOOKS.findby).click();
        waitObj.explicitWaitPresenceLocated(driver,PROFILEPAGE.DELETECONFIRMATION.findby).click();
        try {
            driver.switchTo().alert().accept();
        }catch (NoAlertPresentException e){
            System.out.println("No Alert present");
        }
    }

    public boolean validateNoBooksPresent(){
        return waitObj.explicitWaitPresenceLocated(driver,PROFILEPAGE.NOROWSFOUND.findby).isDisplayed();
    }

    public boolean profilePageheading(WebDriver driver){
        waitObj.scrollToView(driver,PROFILEPAGE.PROFILEPAGEHEADING.findby);
        return waitObj.explicitWaitPresenceLocated(driver, PROFILEPAGE.PROFILEPAGEHEADING.findby).isDisplayed();

    }
}
