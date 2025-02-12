package io.homework.homework3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.Driver;
import org.testng.annotations.Test;


public class Task1 {

    /*login as an advisor
    go to users
    validate that full name for alex.de.souza@gmail.com is Alex De Souza
    validate that user name for alex.de.souza@gmail.com is alexdesouze
    validate that phone number for alex.de.souza@gmail.com is +994512060042
    validate that role for alex.de.souza@gmail.com is client
    validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
     */

    @Test
    public void test1() throws InterruptedException {

        DocuportUtils.login(Driver.getDriver(), DocuportConstants.ADVISOR);
    }
}
