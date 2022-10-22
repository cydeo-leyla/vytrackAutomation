package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /**
     * Creating a private constructor, so we are closing access to object of this class from outside of any class
     */
    private Driver() {
    }

    /**
     * Making our driver instance private, so that is not reachable from outside of any class
     */
    private static WebDriver driver;

    /**
     * Create re-usable method which will return same driver instance when we call it
     */

    public static WebDriver getDriver() {

            if (driver == null) {
                String browserType = ConfigurationReader.getProperty("browser");
/**
 Depending on the browserType our switch statement will determine to open specific type of browser/driver
 */
                switch(browserType){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        driver.manage().window().maximize();
                        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                }
            }


        /**
         // Same driver instance will be return every time we Driver.getDriver() method

         */
        return driver;
    }
    public static void closeDriver(){
        if(driver != null){
            driver.quit(); // this line will kill the session

            // driver = null
        }



    }
}
