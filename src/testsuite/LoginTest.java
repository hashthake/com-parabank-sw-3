package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.UtilityTest;

public class LoginTest extends UtilityTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter details for username
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "Hard123456");

        //Enter details for password
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "Thaker1234");

        //Click on login button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        //Validate expected message and actual message
        verifyText(By.xpath("//h1[contains(text(),'Accounts Overview')]"), "Accounts Overview");

    }

    @Test
    public void verifyTheErrorMessage() {
        //Enter details for username
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "Hard123");

        //Enter details for password
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "Thaker12");

        //Click on login button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        //Validate expected message and actual message
        verifyText(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"), "The username and password could not be verified.");

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Enter details for username
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "Hard123456");

        //Enter details for password
        sendTextToElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "Thaker1234");

        //Click on login button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        //Validate expected and actual message
        verifyText(By.xpath("//h2[contains(text(),'Customer Login')]"), "Customer Login");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

