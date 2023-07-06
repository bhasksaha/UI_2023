package com.bookstoreui.core;

import com.bookstoreui.Reporter.ExtentReport;
import com.bookstoreui.utils.Helper;
import com.bookstoreui.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private BrowserOptions browserOptions;
    private Helper Helper=new Helper();
//    private final static String configPath=System.getProperty("user.dir")+"/src/test/resources/config.properties";
    private final static String configPath;
    static final ClassLoader loader = DriverManager.class.getClassLoader();
    protected String reportPath;
    protected String reportFolder;
    private static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<>();

    static {
        configPath=loader.getResource("config.properties").getPath();
    }

    public static void initdriver(WebDriver threadlocalDriver){
        driverLocal.set(threadlocalDriver);
    }

    public WebDriver getDriver(){
        return driverLocal.get();
    }

    public void browserSetup() {
        reportFolder=Helper.getCurrentTimestamp();
        reportPath=Helper.createFolder(System.getProperty("user.dir")+"/src/test/resources/test-reports/"+reportFolder);
        WebDriver driver;
        Helper=new Helper();
        ExtentReport.initialize(reportPath);

        String browser=Helper.propertyReader(configPath).getProperty("browser");
        if(browser.isEmpty()){
            browser="CHROME";
        }
        DriverManager driverManager=new DriverManager();

        switch (browser){

            case "REMOTE":
//                ChromeOptions dcc = new ChromeOptions();
//                dcc.setCapability("browserName", "chrome");
//                dcc.setCapability("OS", "Windows");
//                WebDriver driver1 = new RemoteWebDriver(new URL("https://localhost:4446/wd/hub"),dcc);// pass the url of selenium hub
//                driver1.get("https://www.google.com");
//                Thread.sleep(5000);
//                driver1.quit();

            case "CHROME":
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+Helper.propertyReader(configPath).getProperty("chormeDriverPath"));
                browserOptions= new BrowserOptions();
                driver=new ChromeDriver(browserOptions.chrome());
                driverManager.initdriver(driver);
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String mainWindow=driverManager.getDriver().getWindowHandle();
                Iterator<String> it=driverManager.getDriver().getWindowHandles().iterator();
                while (it.hasNext()){
                    String handle=it.next();
                    if(!handle.equals(mainWindow)){
                        driverManager.getDriver().switchTo().window(handle);
                        driverManager.getDriver().close();
                        driverManager.getDriver().switchTo().window(mainWindow);
                    }
                }
                break;

            case "FF":
                System.setProperty("webdriver.gecko.driver","/Users/bhaskar/IdeaProjects/UIAutomationFramework/src/test/reources/geckodriver");
                driver=new FirefoxDriver();
                driverManager.initdriver(driver);
                break;
        }

        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverManager.getDriver().get("https://demoqa.com/login");

    }
}
