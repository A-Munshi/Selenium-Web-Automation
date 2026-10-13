package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browserUtility.BrowserUtility;
import pages.ManchesterUnitedPage;

public class ManchesterUnitedTest {

    private BrowserUtility browser;
    private WebDriver driver;
    private ManchesterUnitedPage manchesterUnited;

    @BeforeMethod
    public void setup() {
        browser = new BrowserUtility();
        driver = browser.launchBrowser();
        manchesterUnited = new ManchesterUnitedPage(driver);
    }

    @Test
    public void manchesterUnitedTest() throws IOException, InterruptedException {
        manchesterUnited.openManchesterUnitedPage();
        manchesterUnited.acceptAlert();
        manchesterUnited.openMerchandise();
        manchesterUnited.enterCustomerDetails();
        manchesterUnited.enterPaymentDetails();
        manchesterUnited.submitPayment();

        String actualMessage = manchesterUnited.getSuccessMessage();
        System.out.println("Success Message : " + actualMessage);

        Assert.assertTrue(actualMessage.contains("Payment Successful"),
                "Payment was not successful.");
        System.out.println("Payment Successful.");

        manchesterUnited.captureScreenshot();
        System.out.println("Screenshot captured successfully.");

        manchesterUnited.clickOK();
        System.out.println("Transaction completed successfully.");
    }

    @AfterMethod
    public void tearDown() {
        browser.closeBrowser();
    }
}