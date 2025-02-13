package io.homework.homework4;

import io.loop.test.pages.SmartBearSoftware;
import io.loop.test.utilities.BrowserUtils;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {

       SmartBearSoftware smartBearSoftware;

        @BeforeMethod
        public void beforeMethod() {
            Driver.getDriver().get(ConfigurationReader.getProperties("smartBear.web"));
            smartBearSoftware = new SmartBearSoftware();
        }
        @AfterMethod
        public void afterMethod() {
            //Driver.closeDriver();
        }

        @Test
    public void task2() {
            smartBearSoftware.userNameBear.sendKeys(ConfigurationReader.getProperties("smartBear.username"));
            smartBearSoftware.passwordBear.sendKeys(ConfigurationReader.getProperties("smartBear.password"));
            smartBearSoftware.loginButton.click();
            System.out.println("Count of all the links on landing page: " + smartBearSoftware.allLinks.size());
            BrowserUtils.eachLink(smartBearSoftware.allLinks);




        }

}
