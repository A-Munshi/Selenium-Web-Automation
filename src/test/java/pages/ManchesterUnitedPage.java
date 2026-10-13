package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManchesterUnitedPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // Locators
    private By playerTeamStrategy = By.xpath("//a[@href='#/actions/playerandteamstrategy']");
    private By premierLeague = By.xpath("//b[text()='Premier League']");
    private By manchesterUnited = By.xpath("//a[contains(@href,'manchesterunited')]");
    private By merchandise = By.xpath("//a[text()='Merchandise']");
    private By jerseyCard = By.className("thecard4");
    private By buyNow = By.id("button5");
    private By customerName = By.id("name");
    private By nextButton1 = By.xpath("(//button[text()='Next'])[1]");
    private By phone = By.id("mat-input-1");
    private By nextButton2 = By.xpath("(//button[text()='Next'])[2]");
    private By email = By.id("mat-input-2");
    private By nextButton3 = By.xpath("(//button[text()='Next'])[3]");
    private By address = By.id("address");
    private By submit = By.xpath("//button[text()='Submit']");
    private By cardHolderName = By.xpath("(//form//input[@id='name'])[2]");
    private By cardNumber = By.id("cardnumbercredit");
    private By expiryMonth = By.name("months");
    private By expiryYear = By.name("expyear");
    private By cvv = By.id("cvv");
    private By payNow = By.xpath("//input[@type='submit']");
    private By successMessage = By.xpath("//*[contains(text(),'Payment Successful')]");
    private By okButton = By.xpath("//button[text()='OK']");

    // Constructor
    public ManchesterUnitedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    // Methods
    public void openManchesterUnitedPage() throws InterruptedException {
        driver.findElement(playerTeamStrategy).click();
        Thread.sleep(500);

        actions.moveToElement(driver.findElement(premierLeague)).perform();
        Thread.sleep(500);
        
        driver.findElement(manchesterUnited).click();
        Thread.sleep(500);
    }

    public void acceptAlert() throws InterruptedException {
        Alert alert = wait.until(driver -> driver.switchTo().alert());
        System.out.println("Alert Message : " + alert.getText());
        alert.accept();
        Thread.sleep(500);
    }

    public void openMerchandise() throws InterruptedException {
        driver.findElement(merchandise).click();
        Thread.sleep(500);

        actions.moveToElement(driver.findElement(jerseyCard)).perform();
        Thread.sleep(500);
        
        driver.findElement(buyNow).click();
        Thread.sleep(500);
    }

    public void enterCustomerDetails() throws InterruptedException {
        driver.findElement(customerName).sendKeys("Amit Singh");
        driver.findElement(nextButton1).click();
        Thread.sleep(500);

        driver.findElement(phone).sendKeys("9876543210");
        driver.findElement(nextButton2).click();
        Thread.sleep(500);

        driver.findElement(email).sendKeys("rahul@test.com");
        driver.findElement(nextButton3).click();
        Thread.sleep(500);

        driver.findElement(address).sendKeys("Kolkata, India");
        driver.findElement(submit).click();
        Thread.sleep(500);
    }

    public void enterPaymentDetails() throws InterruptedException {
        driver.findElement(cardHolderName).sendKeys("Amit Singh");
        driver.findElement(cardNumber).sendKeys("1111222233334444");

        WebElement month = driver.findElement(expiryMonth);
        Select select = new Select(month);
        select.selectByVisibleText("January");

        driver.findElement(expiryYear).sendKeys("2030");
        driver.findElement(cvv).sendKeys("123");
        Thread.sleep(500);
    }

    public void submitPayment() throws InterruptedException {
    	Thread.sleep(500);
        driver.findElement(payNow).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public void captureScreenshot() throws IOException, InterruptedException {
        Thread.sleep(500);

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("Screenshots/SuccessfulTransaction.png");
        FileUtils.copyFile(src, destination);
    }

    public void clickOK() {
        driver.findElement(okButton).click();
    }
}