package com.vytrack.pages;


import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VytrackPage {

    public VytrackPage() {

        PageFactory.initElements(Driver.getDriver(), this);


    }

    @FindBy(id = "prependedInput")
    public WebElement userBtn;


    @FindBy(id = "prependedInput2")
    public WebElement passwordBtn;

    @FindBy(id = "_submit")
    public WebElement logInBtn;

  @FindBy(xpath = "//li[@class='dropdown dropdown-level-1']/a/span[normalize-space(text())='Fleet']")
    public WebElement fleet;

  @FindBy(xpath = "//span[.='Vehicle Costs']")
    public WebElement vehicleCost;

  @FindBy(xpath ="//thead[@class ='grid-header']//a[@class='grid-header-cell__link']//span[.='Type']")
    public WebElement type;

  @FindBy(xpath ="//thead[@class ='grid-header']//a[@class='grid-header-cell__link']//span[.='Total Price']")
    public WebElement total_price;

    @FindBy(xpath ="//thead[@class ='grid-header']//a[@class='grid-header-cell__link']//span[.='Date']")
    public WebElement date;
}
