package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {


//Method #1 info:
    //• Name: returnOrderDate ()
    //• Return type: String
    //• Arg1: WebDriver driver
    //• Arg2: String costumerName
    //This method should accept a costumerName and return the costumer order date as a String.

    public static String returnOrderDate(WebDriver driver, String costumerName) {

        String locator = "//td[.='" + costumerName + "']/following-sibling::td[3]";
        WebElement customerOrderDate = driver.findElement(By.xpath(locator));


        return customerOrderDate.getText();
    }


//  Method #2 info:
// • Name: orderVerify ()
//• Return type: void
//• Arg1: WebDriver driver
//• Arg2: String costumerName
//• Arg3: String expectedOrderDate
//    This method should accept above mentioned argume

    public static void orderVerify(WebDriver driver, String costumerName, String expectedOrder) {


        WebElement customerOrderDate =
                driver.findElement(By.xpath("//td[.='" + costumerName + "']/following-sibling::td[3]"));

        String actualOrderDate = customerOrderDate.getText();

        Assert.assertEquals(actualOrderDate, expectedOrder);
    }

    public static void getTableGetEmail(WebDriver driver, int tableNum, String lastName, String firstName){



        String locator ="//table[@id = 'table" + tableNum + "']//td[.='" + lastName + "']//following-sibling::td[.='" + firstName +"']//following-sibling::td[1]";
        WebElement email = driver.findElement(By.xpath(locator));
        System.out.println(email.getText());
    }

}
 // table1
// table2