package NopcommerceJunitUtility;

//Automation to open Gift Cards Link by using Selenium and JUnit.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GiftCards extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("https://demo.nopcommerce.com");
    }

    @Test
    public void setGiftCardsLink() {

        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));

        String expectedMessage = "Gift Cards";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
