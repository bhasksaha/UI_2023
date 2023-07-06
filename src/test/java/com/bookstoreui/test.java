package com.bookstoreui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class test {

    @Test
    public void t1() throws MalformedURLException, InterruptedException {
        ChromeOptions dcc = new ChromeOptions();
        dcc.setCapability("browserName", "chrome");
        dcc.setCapability("OS", "Linux");
        WebDriver driver1 = new RemoteWebDriver(new URL("https://localhost:4446/wd/hub"),dcc);// pass the url of selenium hub
        driver1.get("https://www.google.com");
        Thread.sleep(5000);
        driver1.quit();

    }
}
