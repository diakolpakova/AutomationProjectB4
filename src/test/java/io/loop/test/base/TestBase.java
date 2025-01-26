package io.loop.test.base;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverUtil.getDriver(ConfigurationReader.getProperties("browser"));
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDownMethod() {
       // driver.close();
    }
}
