# the-internet_herokuapp_TAF
Designing a Test Automation Framework using the Page Object Model (POM), Factory Design Pattern, and Fluent Approach Design Pattern to implement test cases for most of the features provided by the Herokuapp.com website.


A Selenium-based Test Automation Framework built with Java, TestNG, and the Page Object Model pattern,
targeting the [The Internet Herokuapp](https://the-internet.herokuapp.com/) practice site.
 
---
 
## 🏗️ Project Structure
 
```
myFirstSeleniumProject1/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── drivers/
│   │   │   │   ├── AbstractDriver.java          # Abstract base for browser factories
│   │   │   │   ├── browsers.java                # Enum mapping browser names to factories
│   │   │   │   ├── ChromeFactory.java           # Chrome WebDriver setup
│   │   │   │   ├── FireFoxFactory.java          # Firefox WebDriver setup
│   │   │   │   ├── EdgeFactory.java             # Edge WebDriver setup
│   │   │   │   └── WebDriverFactory.java        # Thread-safe driver init via ThreadLocal
│   │   │   │
│   │   │   ├── pages/
│   │   │   │   ├── homepage.java                # Home page POM
│   │   │   │   ├── loginPage.java               # Login page POM
│   │   │   │   ├── secureAreaPage.java          # Secure area page POM
│   │   │   │   ├── javaScriptAlert.java         # JS Alerts page POM
│   │   │   │   └── ... (other page objects)
│   │   │   │
│   │   │   ├── bots/
│   │   │   │   ├── ActionBot.java               # Reusable click/type/getText actions
│   │   │   │   └── WaitBot.java                 # FluentWait wrapper
│   │   │   │
│   │   │   └── utils/
│   │   │       ├── PropertyReader.java          # Loads .properties files from resources
│   │   │       ├── JsonReader.java              # Reads JSON test data via JsonPath
│   │   │       └── WindowManager.java           # Browser navigation & tab switching
│   │   │
│   │   └── resources/
│   │       ├── data.properties                  # Test credentials & config values
│   │       └── META-INF/services/
│   │           └── org.testng.ITestListener     # Auto-registers TestNGListeners
│   │
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── baseTests.java               # @BeforeMethod / @AfterMethod setup
│       │   │
│       │   ├── listeners/
│       │   │   └── TestNGListeners.java         # ITestListener + IRetryAnalyzer + IExecutionListener
│       │   │
│       │   ├── login/
│       │   │   └── loginTests.java              # Login test cases
│       │   │
│       │   ├── fluentPatternApproachTrialTest/
│       │   │   └── secureAreaPageTest.java      # Fluent-chain login test
│       │   │
│       │   ├── dropdown/                        # Dropdown tests
│       │   ├── hoversTests/                     # Hover interaction tests
│       │   ├── navigateTests/                   # Navigation tests
│       │   ├── fileUploadTests/                 # File upload tests
│       │   └── ... (other test packages)
│       │
│       └── resources/
│           └── test_data/
│               └── logindata.json               # JSON test data
│
└── pom.xml
```
 
---
 
## ⚙️ Tech Stack
 
| Tool | Purpose |
|---|---|
| Java | Primary language |
| Selenium WebDriver 4 | Browser automation |
| TestNG | Test runner & assertions |
| Maven | Build & dependency management |
| Apache Commons IO | File scanning for PropertyReader |
| JSON Simple | JSON file parsing |
| JsonPath (Jayway) | JSON data extraction |
| ThreadLocal | Thread-safe parallel driver management |
 
---
 
## 🔧 Design Patterns Used
 
**Factory Pattern** — `AbstractDriver` + `ChromeFactory` / `FireFoxFactory` / `EdgeFactory` + `browsers` enum
select and create the correct WebDriver without `if/else` chains.
 
**Page Object Model (POM)** — Each page is its own class under `pages/`, encapsulating locators and actions,
keeping test classes clean.
 
**Fluent Interface** — Page methods return the next page object, enabling readable chained calls like:
```java
new homepage(driver)
    .clickOnformAuthenticationLink()
    .login(username, password)
    .clickLoginButton()
    .getWelcomeMessage();
```
 
**Bot Pattern** — `ActionBot` and `WaitBot` abstract low-level Selenium calls (click, type, getText)
behind stable, retry-safe methods used by all page objects.
 
---
 
## 🚀 Getting Started
 
### Prerequisites
 
- Java 11+
- Maven 3.6+
- Chrome / Firefox / Edge installed
### Run Tests
 
```bash
# Run all tests
mvn test
 
# Run a specific test class
mvn test -Dtest=loginTests
 
# Run with a specific browser (if baseTests reads from properties)
mvn test -Dbrowser=firefox
```
 
---
 
## 📋 Test Data
 
**Properties file** — `src/main/resources/data.properties`
```properties
validUserName = tomsmith
validPassword = SuperSecretPassword!
inValidUserName = Amr
inValidPassword = 1581998
```
 
**JSON file** — `src/test/resources/test_data/logindata.json`
```json
{
  "valid-userName": "tomsmith",
  "valid-password": "SuperSecretPassword!"
}
```
 
---
 
## 🎧 Listeners
 
`TestNGListeners` implements four interfaces and is auto-registered via `META-INF/services`:
 
| Interface | Responsibility |
|---|---|
| `ITestListener` | Logs test start, pass, fail, skip events |
| `IInvokedMethodListener` | Logs before/after each method invocation |
| `IExecutionListener` | Loads properties at suite start |
| `IRetryAnalyzer` | Retries failed tests up to 2 times |
 
