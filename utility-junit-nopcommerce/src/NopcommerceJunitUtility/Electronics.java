package NopcommerceJunitUtility;
//Problem(Bug) : Login details like password and email is not working properly despite providing correct details.
//Unable to verify : How many Quantity is entered like 1 or 2 or 3 by using expected message vs actual message.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Electronics extends BaseTest {

    @Before
    public void setUp() {
        openBrowser("https://demo.nopcommerce.com");

    }

    @Test
    public void electronicsCameraAndPhoto() throws InterruptedException {

        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

        String expectedMessage = "Electronics";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Electronics')]"));
        Assert.assertEquals(expectedMessage, actualMessage);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));

        String expectedMsg = "Camera & photo";
        String actualMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Camera & photo')]"));
        Assert.assertEquals(expectedMsg, actualMsg);

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));

        String expectedMsg1 = "Nikon D5500 DSLR";
        String actualMsg1 = getTextFromElement(By.xpath("//h1[contains(text(),'Nikon D5500 DSLR')]"));
        Assert.assertEquals(expectedMsg1, actualMsg1);

        String expectedMsg2 = "Availability: In stock";
        String actualStockAvailableStatus = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]"));
        Assert.assertEquals(expectedMsg2, actualStockAvailableStatus);

        Thread.sleep(1000);

        WebElement quantity = driver.findElement(By.xpath("//input[@id='product_enteredQuantity_14']"));
        quantity.clear();
        quantity.sendKeys("2");

        getTextFromElement(By.xpath("//input[@id='add-to-cart-button-14']"));

        clickOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));

        String expectedMsg3 = "Shopping cart";
        String shoppingCartPage = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedMsg3, shoppingCartPage);


        String expectedProductPrice = "$670.00";
        String productPrice = getTextFromElement(By.xpath("//tbody/tr[1]/td[5]/span[1]"));
        Assert.assertEquals(expectedProductPrice, productPrice);

        String expectedTotal = "$1,340.00";
        String total = getTextFromElement(By.xpath("//tbody/tr[1]/td[7]/span[1]"));
        Assert.assertEquals(expectedTotal, total);

        Thread.sleep(1000);

        String expectedCheckoutTotal = "$1,340.00";
        String checkoutTotal = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"));
        Assert.assertEquals(expectedCheckoutTotal, checkoutTotal);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        clickOnElement(By.xpath("//button[@id='checkout']"));

        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='Email']"), "newpresidentjoe@gamil.com");

        sendTextToElement(By.xpath("//input[@id='Password']"), "you999");

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]"));

        clickOnElement(By.xpath("//button[@id='checkout']"));

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Miami");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), " Marina Beach Street");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "45987");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "0014567892999");

        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/input[1]"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
