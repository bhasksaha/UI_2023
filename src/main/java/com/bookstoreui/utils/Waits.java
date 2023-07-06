package com.bookstoreui.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Waits {
//    private Helper helper;

    public WebElement explicitWaitPresenceLocated(WebDriver driver, By locator){
        WebDriverWait wait=new WebDriverWait(driver,3);
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    public void scrollToView(WebDriver driver,By locator){
        WebElement element=explicitWaitPresenceLocated(driver,locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickUsingJSExec(WebDriver driver,By locator){
        WebElement element=explicitWaitPresenceLocated(driver,locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

    }



    public String screenshot(WebDriver driver, String screenshotName,String folder){
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        new Helper().createFolder("/target/screeenshots");
        String des=folder+"/"+ screenshotName +".png";
        File end=new File(des);
        try {
            FileHandler.copy(f,end);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(end.getAbsolutePath());
        return end.getName();
    }
}
