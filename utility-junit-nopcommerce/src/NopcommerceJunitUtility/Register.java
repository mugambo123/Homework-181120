package NopcommerceJunitUtility;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Register extends BaseTest {

    @Before
    public void setUp() {
        openBrowser("https://demo.nopcommerce.com");
    }

    @Test
    public void navigateToRegister() {
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        String expectedMessage = "register";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @Test
    public void registerSuccessfully() throws InterruptedException {
        navigateToRegister();

        Thread.sleep(1000);

        clickOnElement(By.xpath("//input[@id='gender-male']"));

        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='FirstName']"), "joe");

        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='LastName']"), "biden");

        Thread.sleep(1000);

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]/option[11]"));

        Thread.sleep(1000);

        clickOnElement(By.xpath("//option[contains(text(),'October')]"));

        Thread.sleep(1000);

        clickOnElement(By.xpath("//option[contains(text(),'1950')]"));

        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='Email']"), "newpresidentjoe@gamil.com");

        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='Company']"), "white house");

        Thread.sleep(1000);

        clickOnElement(By.xpath("//input[@id='Newsletter']"));

        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='Password']"), "you999");

        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "you999");

        String expectedSuccessfulRegisterMessage = "Your registration completed";
        String actualSuccessfulRegisterMessage = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals(expectedSuccessfulRegisterMessage, actualSuccessfulRegisterMessage);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
