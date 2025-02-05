package io.homework.homework2;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practice3 extends TestBase {
    /*task2
=============

    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza - we did in class
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
    */

@Test
    public void practice3() throws InterruptedException {
    DocuportUtils.login(driver, DocuportConstants.ADVISOR);

    Thread.sleep(5000);

    WebElement users = driver.findElement(By.xpath("//*[contains(text(),'Users')]"));
    users.click();

    WebElement search = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
    search.click();
    Thread.sleep(5000);
    WebElement emailInput = driver.findElement(By.xpath("//input[@id='input-137']"));
    emailInput.click();
    emailInput.sendKeys("alex.de.souza@gmail.com");

    Thread.sleep(5000);
    WebElement buttonSearch = driver.findElement(By.xpath("//button[@type='submit']"));
    buttonSearch.click();


    Thread.sleep(5000);
    WebElement fullName = driver.findElement(By.xpath("//*[contains(text(),'Alex De Souza')]"));
    Assert.assertEquals(fullName.getText(), "Alex De Souza", "Full name Alex De Souza is not displayed");
    Thread.sleep(5000);
    WebElement username = driver.findElement(By.xpath("//*[contains(text(),'alexdesouze')]"));
    Assert.assertEquals(username.getText(), "alexdesouze", "Username is not displayed");
    Thread.sleep(5000);
    WebElement phoneNumber = driver.findElement(By.xpath("//*[contains(text(),'+994512060042')]"));
    Assert.assertEquals(phoneNumber.getText(), "+994512060042", "Phone number is not valid for client");
    Thread.sleep(5000);
    WebElement role = driver.findElement(By.xpath("//*[contains(text(),' Client ')]"));
    Assert.assertEquals(role.getText(), "Client", "Role \"client\" is not displayed");
    Thread.sleep(5000);
    WebElement advisorInformation = driver.findElement(By.xpath("//td[contains(text(),'Batch1 Group1')]"));
    Assert.assertEquals(advisorInformation.getText(), "Batch1 Group1", "Information is not correct");



}
}
