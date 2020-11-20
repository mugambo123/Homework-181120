package NopcommerceJunitUtility;

//Automation to open Apparel Link by using Selenium and JUnit.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Apparel extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("https://demo.nopcommerce.com");
    }

    @Test
    public void setApparelLink() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));

        String expectedMessage = "Apparel";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Apparel')]"));
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
