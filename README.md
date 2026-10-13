# Selenium Web Automation — AccenSportz E2E Test Suite

An end-to-end UI test automation project built with Selenium WebDriver 4, TestNG, and Java, using the Page Object Model (POM) design pattern. Automates a complete purchase flow on the [AccenSportz](https://lkmdemoaut.accenture.com/AccenSportz/#/) sports merchandise demo web application.

---

## Test Result

```
Tests run: 1 | Passed: 1 | Failed: 0 | Skipped: 0
Duration: ~17 seconds
```

---

## What It Automates

The test covers the full end-to-end purchase flow on the AccenSportz web application:

1. Launch browser and navigate to AccenSportz home page
2. Navigate to Player & Team Strategy → hover over Premier League → click Manchester United
3. Handle a browser-native JavaScript alert (captures and accepts it)
4. Navigate to Merchandise → hover over jersey card → click Buy Now
5. Fill in customer details across a multi-step stepper form (Name → Phone → Email → Address)
6. Fill in payment details (card name, 16-digit card number, expiry month via dropdown, expiry year, CVV)
7. Submit payment
8. Assert success — `Assert.assertTrue(actualMessage.contains("Payment Successful"))`
9. Capture and save a screenshot of the confirmed transaction
10. Click OK to complete

---

## Architecture

### Page Object Model (POM)

All UI interactions are separated from test logic:

```
src/test/java/
├── browserUtility/
│   └── BrowserUtility.java       # Browser lifecycle: launch (Chrome), implicit wait, teardown
├── pages/
│   └── ManchesterUnitedPage.java # All locators + action methods for the purchase flow
└── tests/
    └── ManchesterUnitedTest.java # TestNG test: @BeforeMethod setup, @Test, @AfterMethod teardown
```

### Selenium Interactions Used

| Interaction Type | Where Used |
|---|---|
| `driver.findElement` + `sendKeys` | Form field entry (name, phone, email, address, card details) |
| `driver.findElement` + `click` | Button clicks throughout the flow |
| `Actions.moveToElement` | Hover over Premier League nav item and jersey card |
| `driver.switchTo().alert()` | Handle JS alert on Manchester United team page |
| `Select.selectByVisibleText` | Expiry month dropdown |
| `WebDriverWait` + `ExpectedConditions` | Explicit waits — prevents flakiness on slow-loading elements |
| `TakesScreenshot` + `FileUtils.copyFile` | Save screenshot on successful transaction |
| `Assert.assertTrue` | TestNG assertion on success message text |

---

## Tech Stack

| Component | Technology / Version |
|---|---|
| Language | Java |
| Test Framework | TestNG 7.12.0 |
| WebDriver | Selenium Java 4.45.0 |
| Browser | Google Chrome (ChromeDriver auto-managed) |
| Build Tool | Maven |
| Reporting | TestNG HTML report (auto-generated in `test-output/`) |
| IDE | Eclipse |

**Dependencies also configured (pom.xml):**
- `com.deque.html.axe-core:selenium:4.12.0` — axe-core accessibility testing integration
- `com.aventstack:extentreports:5.1.2` — ExtentReports for enhanced HTML reporting

---

## Project Structure

```
SeleniumAutomation/
├── pom.xml                             # Maven dependencies (Selenium, TestNG, axe-core, ExtentReports)
├── testng.xml                          # TestNG suite configuration
├── src/test/java/
│   ├── browserUtility/BrowserUtility.java
│   ├── pages/ManchesterUnitedPage.java
│   └── tests/ManchesterUnitedTest.java
├── Screenshots/
│   └── SuccessfulTransaction.png       # Auto-saved on test pass
└── test-output/                        # TestNG-generated HTML reports
    ├── index.html
    └── emailable-report.html
```

---

## Running the Tests

### Prerequisites
- Java 8+
- Maven
- Google Chrome installed

### Execute

```bash
git clone <repo-url>
cd SeleniumAutomation
mvn test
```

TestNG will launch Chrome, execute the full purchase flow, save a screenshot to `Screenshots/SuccessfulTransaction.png`, and generate an HTML report in `test-output/`.

---

## Screenshot

<img width="1366" height="585" alt="SuccessfulTransaction" src="https://github.com/user-attachments/assets/a3824837-501a-445d-ac46-ab8ac09b7d5a" />


---

## Author

**Anuvab Munshi**
[LinkedIn](https://linkedin.com/in/anuvab-munshi) · [GitHub](https://github.com/A-Munshi)
