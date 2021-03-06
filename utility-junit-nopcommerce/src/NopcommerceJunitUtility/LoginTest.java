package NopcommerceJunitUtility;

// Login test for nopcommerce by using Selenium, JUnit and Utility Package.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Before
    public void setUp() {
        openBrowser("https://demo.nopcommerce.com");

    }

    @Test
    public void verifyUserShouldNavigateTOLoginPageSuccessfully() {
        clickOnElement(By.linkText("Log in"));

        String expectedMessage = "Welcome, Please Sign In!";

        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @Test
    public void verifyErrorMessageWhenWrongUserNameIsEntered() throws InterruptedException {

        clickOnElement(By.linkText("Log in"));

        Thread.sleep(1000);

        sendTextToElement(By.id("Email"), "abc@gmail.com");

        sendTextToElement(By.name("Password"), "xyz123");

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]"));

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        String actualMessage = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"));

        Assert.assertEquals(expectedErrorMessage, actualMessage);

    }

    @Test
    public void verifyErrorMessageWhenWrongPasswordIsEntered() throws InterruptedException {

        clickOnElement(By.linkText("Log in"));

        Thread.sleep(1000);

        sendTextToElement(By.id("Email"), "krishna123@gmail.com");

        sendTextToElement(By.id("Password"), "abc123");

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]"));

        String expectedErrorMsg = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        String actualErrorMsg = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"));

        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);


    }

    @Test
    public void verifySuccessfulLoginMessageWhenCorrectCredentialsEntered() {

        clickOnElement(By.linkText("Log in"));

        sendTextToElement(By.id("Email"), "krishna123@gmail.com");

        sendTextToElement(By.name("Password"), "xyz123");

        String expectedSuccessfulLoginMsg = "Welcome to our store";
        String actualSuccessfulLoginMsg = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals(expectedSuccessfulLoginMsg, actualSuccessfulLoginMsg);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
