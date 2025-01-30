package io.homework.day4.practice;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class practice1 {
    /*go to http://the-internet.herokuapp.com/dropdown
validate "Please select an option" is selected by default
Choose option 1 and validate that it is selected
Choose option 2 and validate that it is selected
Validate dropdown name is "Dropdown List"
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethods() {
        driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethods() {
        //driver.close();
    }

    @Test
    public void selectOption() {

      Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
      String actual = dropdown.getFirstSelectedOption().getText();
      String expected = "Please select an option";
      Assert.assertEquals(actual, expected, "No matches");
    }

    @Test
    public void selectOption1() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        dropdown.selectByValue("1");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1", "Actual option does not match");
    }

    @Test
    public void selectOption2() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        dropdown.selectByVisibleText("Option 2");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2", "Actual option does not match");
    }

    @Test
    public void validateNameDropdownList() {

        WebElement dropDownList = driver.findElement(By.xpath("//h3[contains(text(),'Dropdown List')]"));
        Assert.assertTrue(dropDownList.isDisplayed(), "Dropdown list is not displayed");
    }






}
