package NopcommerceJunitUtility;

//Automation to open Digital Downloads Link by using Selenium and JUnit.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DigitalDownloads extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("https://demo.nopcommerce.com");
    }

    @Test
    public void setDigitalDownloadsLink() {

        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));

        String expectedMessage = "Digital downloads";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Digital downloads')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
