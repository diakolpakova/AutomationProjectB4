package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T000_xpath_getText {
    public static void main(String[] args) throws InterruptedException {

        // open chrome and go to docuport
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);

        // 3. click to forget password
        WebElement forgetPasswordLink = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgetPasswordLink.click();

        // 4. validate url contains
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(DocuportConstants.RESET_PASSWORD_URL)) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        WebElement validateMessage = driver.findElement(By.xpath("//div[contains(text(),'Enter')]"));
        String actualValidateMessage = validateMessage.getText();

        if (actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        // 6. enter forgot password word
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id, 'input')]"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);

        WebElement cancelButton = driver.findElement(By.xpath("//span[contains(., 'Cancel')]"));
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));

        if (sendButton.isDisplayed()) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        sendButton.click();

        Thread.sleep(9000);

        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));

        Thread.sleep(10000);

        System.out.println("successMessage = " + successMessage.getText());

        try {
            System.out.println(successMessage.getText());
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not there anymore");
        }


    }
}
