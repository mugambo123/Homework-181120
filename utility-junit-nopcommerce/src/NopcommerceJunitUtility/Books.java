package NopcommerceJunitUtility;

//Automation to open Books Link by using Selenium and JUnit.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Books extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("https://demo.nopcommerce.com");

    }

    @Test
    public void setBooksLink() {

        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));

        String expectedMessage = "Books";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Books')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void teardown() {
        closeBrowser();
    }
}
