package io.homework.homework1;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class practice2 extends TestBase {
    /*task2
=============
1. login as an advisor
2. go to received document
3. click search
4. click status dropdown
5. choose in progress
     */
@Test
    public void docuportLoginAdrvisor() throws InterruptedException {

    driver.get(DocuportConstants.DOCUPORT_TEST);
    driver.manage().window().maximize();

    WebElement username = driver.findElement(By.xpath("//input[@id='input-14']"));
    username.sendKeys(DocuportConstants.USERNAME_ADVISOR);

    WebElement password = driver.findElement(By.xpath("//input[@id='input-15']"));
    password.sendKeys(DocuportConstants.PASSWORD);

    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
    loginButton.click();
    //DocuportUtils.login(driver, DocuportConstants.ADVISOR);

    Thread.sleep(3000);
    WebElement receivedDoc = driver.findElement(By.xpath("//span[.='Received docs']"));
    Thread.sleep(3000);
    receivedDoc.click();

    Thread.sleep(3000);
    WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
    Thread.sleep(3000);
    searchButton.click();

    Thread.sleep(3000);
    WebElement dropdownStatus = driver.findElement(By.xpath("//label[@for='input-337']"));
    Thread.sleep(3000);
    dropdownStatus.click();

    Thread.sleep(3000);
    WebElement inProgress = driver.findElement(By.xpath("//div[contains(text(),'In progress')]"));
    Thread.sleep(3000);
    inProgress.click();

}

}
