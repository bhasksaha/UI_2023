package com.bookstoreui.pages;

import com.bookstoreui.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStorePage {

    public Waits waitObj=new Waits();
    WebDriver driver;
    BookStorePage bookStorePage;

    public BookStorePage(WebDriver driver){
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
}
