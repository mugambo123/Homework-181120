package NopcommerceJunitUtility;
//Selenium automation
//From nopcommerce homepage tab to Computer and then tab to Desktop with verification of correct page.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Computer extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("https://demo.nopcommerce.com");

    }

    @Test
    public void computerDesktop() throws InterruptedException {

        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        String expectedMessage = "Computers";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        Assert.assertEquals(expectedMessage, actualMessage);

        Thread.sleep(1000);

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));

        String expectedMsg = "Desktops";
        String actualMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Desktops')]"));
        Assert.assertEquals(expectedMsg, actualMsg);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}



