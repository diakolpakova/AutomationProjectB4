package io.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class DocuportUtils {

    /**
     * logins to Docuport application
     * @param driver, which is initialized in the test base
     * @param role, comes from Docuport constants
     *              author dk
     */
public static void login(WebDriver driver, String role) throws InterruptedException {
    driver.get(ConfigurationReader.getProperties("docuportBETA"));
    WebElement username = driver.findElement(By.xpath("//label[text()='Username or email']/following-sibling::input")); ;
    WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
    WebElement logIn = driver.findElement(By.xpath("//span[@class='v-btn__content']")); //login button

    switch (role.toLowerCase()){
        case "client":
            username.sendKeys(DocuportConstants.USERNAME_CLIENT);
            password.sendKeys(DocuportConstants.PASSWORD);
            break;
        case "supervisor":
            username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
            password.sendKeys(DocuportConstants.PASSWORD);
            break;
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
        case "employee":
            username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
            password.sendKeys(DocuportConstants.PASSWORD);
            break;
            default: throw new InterruptedException("There is not such a role: " + role);
    }

    logIn.click();

    if (role.toLowerCase().equals("client")) {
        Thread.sleep(3000);
        WebElement con = driver.findElement(By.xpath("//button[@type='submit']"));
        con.click();
        Thread.sleep(3000);
    }
}
    /**
     *  logs out from docuport application
     * @param driver
     * @author dk
     */
    public static void logOut(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement logout = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logout.click();

    }





}
