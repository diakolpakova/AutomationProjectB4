package io.loop.test.day8;

import io.loop.test.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_google_search {

    /*
    go to "https://www.google.com"
    write "Loop Academy" and search
    validate title : Loop Academy
     */

    @Test
    public void google_search() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("google.url"));

        System.out.println("((RemoteWebDriver) Driver.getDriver()).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());

        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys("Loop Academy" + Keys.ENTER);
        String actualTitle = Driver.getDriver().getTitle();

        Thread.sleep(8000);
        Assert.assertEquals(actualTitle, "Loop academy - Google Search");
    }

    @Test
    public void docuport_search () throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuportBETA"));
        System.out.println("((RemoteWebDriver) Driver.getDriver()).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());

        DocuportUtils.login(Driver.getDriver(),"advisor");
        WebElement myUploads = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'My Uploads')]"));
        myUploads.click();


    }
}
