package io.homework.homework4;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Task1 {

    @Test
    public void test1() throws InterruptedException {

        Driver.getDriver().get("https://app.docuport.app/company-formation/resident");

        WebElement typeOfBusinessLLC = Driver.getDriver().findElement(By.xpath("//label[contains(text(), 'LLC')]/preceding-sibling::div//input[@type='radio' and @value='1']"));
        assertTrue(typeOfBusinessLLC.isSelected());

        WebElement typeOfBusinessCorporation = Driver.getDriver().findElement(By.xpath("//label[contains(text(), 'Corporation')]/preceding-sibling::div//input[@type='radio' and @value='2']"));
        assertTrue(typeOfBusinessCorporation.isSelected());

        



    }
}
