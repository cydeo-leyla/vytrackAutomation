package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {


    public static WebDriver getDriver (String browser){

        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.chromedriver().setup();
            return new FirefoxDriver();

        }else{
            System.out.println("Given browser type does not exist or not currently supported");
            return null;
        }

    }
}
