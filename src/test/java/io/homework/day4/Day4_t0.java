package io.homework.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Day4_t0 {
    public static void main(String[] args) throws InterruptedException {
        /*
        /*
    1. go to docuport app
    2. identify docuport with css
    3. get value of the attribute
    4.validate if it is "Docuport"

    the rest is home work
    locate:
    username
    password
    login
        with css
    login to docuport
    locate home icon of docuport after login or any other element after login
    validated that you logged in

     */

        // 1. go to the url
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.navigate().to(DocuportConstants.DOCUPORT_TEST);

        // 2. locate the element with css
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));

        // 3. get the value of the attribute
        //String docuport = logo.getAttribute("alt");
        String docuport = logo.getDomAttribute("alt");

        // 4. validate if it is "Docuport"
        System.out.println("docuport = " + docuport);

        if (DocuportConstants.LOGO_DOCUPORT.equals(docuport)) {
            System.out.println("Expected result matches actual result");
            System.out.println("Test passed");
        } else {
            System.out.println("Expected result DOES NOT match actual result");
            System.out.println("Test failed");
        }

        // 5. locate username
        WebElement userName = driver.findElement(By.id("input-14"));
        userName.sendKeys(("b1g1_client@gmail.com"));

        // 6. locate password
        WebElement password = driver.findElement(By.id("input-15"));
        password.sendKeys("Group1");

        // 7. locate login
        WebElement login = driver.findElement(By.className("v-btn__content"));

        // 8. login to docuport
        login.click();
        Thread.sleep(5000);
        WebElement continueButton = driver.findElement(By.cssSelector("button[type=submit]"));
        Thread.sleep(5000);
        continueButton.click();

        // 9. locate home icon of docuport after login or any other element after login
        WebElement iconHome = driver.findElement(By.xpath("//span[.='Home']"));
        String getIcon = iconHome.getText();

        // 10. validated that you logged in
        if(getIcon.equals("Home")){
            System.out.println("You logged in");
        }else {
            System.out.println("You are not logged in");
        }



    }
}
