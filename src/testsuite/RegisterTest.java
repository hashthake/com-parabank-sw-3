package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.UtilityTest;

public class RegisterTest extends UtilityTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //Find element for register and click regiser button
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        // Validate actual and expected message
        verifyText(By.className("title"), "Signing up is easy!");

    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //Find element for register and click regiser button
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        //Enter first name in firstname field
        sendTextToElement(By.id("customer.firstName"), "Hardik12");

        //Enter last name in lastname field
        sendTextToElement(By.id("customer.lastName"), "Thaker12");

        //Enter address in address field
        sendTextToElement(By.id("customer.address.street"), "20, Car Street");

        //Enter cityname in cityname field
        sendTextToElement(By.id("customer.address.city"), "Ahmedabad");

        //Enter state name in state field
        sendTextToElement(By.id("customer.address.state"), "Gujarat");

        //Enter postcode in pastcode field
        sendTextToElement(By.id("customer.address.state"), "380015");

        //Enter phonenumber in phonenumber field
        sendTextToElement(By.id("customer.phoneNumber"),"9825098250");

        //Enter ssn number in ssn number field
        sendTextToElement(By.id("customer.ssn"), "1234");

        // chooose username by entering username
        sendTextToElement(By.id("customer.username"), "Hard123456");

        //select password by entering password
        sendTextToElement(By.id("customer.password"), "Thaker1234");

        //Repeat entered password
        sendTextToElement(By.id("repeatedPassword"), "Thaker1234");

        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));

        //validated expected and actual message
        verifyText(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"), "Your account was created successfully. You are now logged in.");

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}


