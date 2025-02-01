package io.homework.day4.practice;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class practice1 {
    /*
    1. go to http://the-internet.herokuapp.com/dropdown
    2. validate "Please select an option" is selected by default
    3. Choose option 1 and validate that it is selected
    4. Choose option 2 and validate that it is selected
    5. Validate dropdown name is "Dropdown List"
     */
    WebDriver driver;
    String actual;
    String expected;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void setOut() {
        //driver.close();
    }

    @Test
    public void testDropdown1() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        String actual = dropdown.getFirstSelectedOption().getText();
        String expected = "Please select an option";
        Assert.assertEquals(actual, expected, "Actual does not match expected");
    }

    @Test
    public void testDropdown2() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByValue("1");
        String actual2 = dropdown.getFirstSelectedOption().getText();
        String expected2 = "Option 1";
        Assert.assertEquals(actual2, expected2, "Actual does not match expected");
    }

    @Test
    public void testDropdown3() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByVisibleText("Option 2");
        String actual = dropdown.getFirstSelectedOption().getText();
        String expected2 = "Option 2";
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2", "Actual does not match expected value");
    }

    @Test
    public void testDropdown4() {
        WebElement dropdownName = driver.findElement(By.xpath("//h3[.='Dropdown List']"));
        Assert.assertEquals(dropdownName.getText(), "Dropdown List", "Actual does not match expected");
    }
}
