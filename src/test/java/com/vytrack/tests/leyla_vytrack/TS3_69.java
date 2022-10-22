package com.cydeo.tests.leyla_vytrack;

import com.cydeo.pages.VytrackPage;
import com.cydeo.utilites.BrowserUtils;
import com.cydeo.utilites.ConfigurationReader;
import com.cydeo.utilites.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS3_69 {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    @BeforeMethod
    public void login() {

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_env2"));

        VytrackPage vytrackPage = new VytrackPage();
        vytrackPage.userBtn.sendKeys(ConfigurationReader.getProperty("user1Vytrack"));
        vytrackPage.passwordBtn.sendKeys(ConfigurationReader.getProperty("password1Vyrack"));
        vytrackPage.logInBtn.click();
    }

    @Test
    public void home_page() {
        // 1.Click the Vehicle Costs under the Fleet
        //3. Verify there are 3 columns on the table:
        // __ Expected Column names: ** TYPE, TOTAL PRICE, DATE
        BrowserUtils.sleep(3);
        Actions action = new Actions(Driver.getDriver());
        VytrackPage vytrackPage = new VytrackPage();

        action.moveToElement(vytrackPage.fleet).perform();


        wait.until(ExpectedConditions.elementToBeClickable(vytrackPage.vehicleCost));
        action.moveToElement(vytrackPage.vehicleCost).click().perform();

        Assert.assertEquals(vytrackPage.type.getText(), "TYPE");
        Assert.assertEquals(vytrackPage.total_price.getText(), "TOTAL PRICE");
        Assert.assertEquals(vytrackPage.date.getText(), "DATE");

    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
