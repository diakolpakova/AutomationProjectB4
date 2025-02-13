package io.loop.test.pages;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearSoftware {
    public SmartBearSoftware() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement userNameBear;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBear;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//ul[@id='ctl00_menu']//li")
    public List<WebElement> allLinks;



















}
