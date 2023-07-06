package com.bookstoreui.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class BrowserOptions {

    public ChromeOptions chrome(){
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("/Users/bhaskar/IdeaProjects/UIAutomationFramework/src/test/resources/drivers/extension_5_7_0_0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return options;
    }

}
