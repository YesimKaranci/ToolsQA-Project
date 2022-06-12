package com.yesim.test.tests;

import cucumber.api.java.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    //private final String driverName = "webdriver.gecko.driver";
    private final String driverName = "webdriver.chrome.driver";
    //private final String driverPath = "src/test/resources/driver/geckodriver";
    private final String driverPath = "src/test/resources/driver/chromedriver";
    private final String url = "https://demoqa.com";

    public static WebDriver getDriver() { return driver; }
    public static WebDriverWait getWait(){ return wait;}

    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized"); //tarayıcı boyutu
        //options.addArguments("disble-popup-blocking"); //popup kapat
        //options.addArguments("disable-notifications"); //bildirimleri kapat
        //options.addArguments("test-type"); //Test tipinde aç
        System.setProperty(driverName,driverPath);
        driver  = new ChromeDriver(options);
        //driver=new FirefoxDriver(options); //ön ayarlarla kalkar
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,60,500);
    }

    @After
    public void close(){
        driver.quit(); //tarayıcıyı kapat
    }

}
