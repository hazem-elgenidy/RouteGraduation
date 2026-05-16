# 🎓 RouteGraduation - Automation Testing Project

Comprehensive end-to-end test automation framework for the Route Graduation Portal using Selenium WebDriver, TestNG, Allure Reports, and advanced test design patterns.

## 📋 Overview

RouteGraduation is a professional-grade test automation project designed to validate the functionality of a graduation management system. This project demonstrates enterprise-level automation testing practices, including test organization, detailed reporting, and CI/CD integration preparation.

## ✨ Key Features

- **Advanced TestNG Framework**: Parameterized tests, test groups, data providers, and custom listeners
- **Allure Reporting**: Professional test reports with screenshots, logs, and trends
- **Page Object Model (POM)**: Clean, maintainable, and scalable code architecture
- **Comprehensive Test Coverage**: 30+ automated test cases across multiple modules
- **Maven Build Integration**: Easy setup, dependency management, and plugin configuration
- **Cross-Browser Support**: Designed for Chrome, Firefox, and Edge browsers
- **Test Data Management**: External configuration files for easy test data updates
- **Professional Assertions**: Detailed validation with meaningful error messages

## 🎯 Test Modules & Coverage

| Module | Description | Test Cases | Status |
|--------|-------------|-----------|--------|
| **User Authentication** | Login, logout, password reset | 5+ | ✅ |
| **Student Portal** | Student registration, profile management | 6+ | ✅ |
| **Graduation Requirements** | Requirement verification, progress tracking | 5+ | ✅ |
| **Document Upload** | Transcript upload, document validation | 4+ | ✅ |
| **Grade Management** | GPA calculation, grade verification | 5+ | ✅ |
| **Report Generation** | Degree audit, graduation status report | 4+ | ✅ |
| **Admin Functions** | User management, system settings | 4+ | ✅ |
| **Total Coverage** | **33+ comprehensive test cases** | **✅** |

## 🛠️ Tech Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| **Language** | Java | 11+ |
| **Automation Tool** | Selenium WebDriver | 4.39.0 |
| **Testing Framework** | TestNG | 7.11.0 |
| **Reporting** | Allure TestNG | 2.24.0 |
| **Build Tool** | Maven | 3.6.3+ |
| **Surefire Plugin** | Maven Surefire | 3.2.5 |
| **Design Pattern** | Page Object Model | - |

## 📦 Installation & Setup

### Prerequisites
- **Java Development Kit (JDK)**: Java 11 or higher
- **Maven**: Version 3.6.3 or higher
- **Google Chrome / Firefox / Edge**: Latest versions
- **WebDriver**: Corresponding browser drivers ([ChromeDriver](https://googlechromelabs.github.io/chrome-for-testing/), [GeckoDriver](https://github.com/mozilla/geckodriver/releases))
- **Allure CLI**: For viewing reports (optional, [Install Guide](https://docs.qameta.io/allure/#_installing_a_commandline))

### Step 1: Clone Repository
```bash
git clone https://github.com/hazem-elgenidy/RouteGraduation.git
cd RouteGraduation
```

### Step 2: Install Dependencies
```bash
mvn clean install
```

### Step 3: Configure WebDriver
Update `src/main/java/config/DriverConfig.java` or set system properties:
```bash
# Option A: Update properties file
# src/main/resources/config.properties
browser=chrome
chromedriver.path=/path/to/chromedriver

# Option B: Command-line parameter
mvn -Dbrowser=chrome -Ddriver.path="/path/to/chromedriver" clean test
```

### Step 4: Run Tests
```bash
# Run all tests
mvn clean test

# Run specific test class
mvn -Dtest=StudentPortalTest test

# Run specific test method
mvn -Dtest=StudentPortalTest#testStudentRegistration test

# Run tests by group
mvn clean test -Dgroups="smoke,regression"

# Run with specific browser
mvn -Dbrowser=firefox clean test
```

## 🚀 Quick Start Example

```java
@Test(groups = "smoke")
@Description("Verify student can successfully register in the portal")
public void testStudentRegistration() {
    LoginPage loginPage = new LoginPage(driver);
    StudentPortalPage studentPage = loginPage.loginAsStudent("student@email.com", "password123");
    
    // Fill registration form
    studentPage.fillRegistrationForm(testData.getRegistrationDetails());
    
    // Submit and verify
    studentPage.submitForm();
    assert studentPage.isRegistrationSuccessful() : "Registration failed";
}
```

## 📁 Project Structure

```
RouteGraduation/
├── pom.xml                                # Maven configuration
├── testng.xml                             # TestNG suite configuration
├── README.md                              # This file
├── .gitignore
│
├── src/
│   ├── main/java/
│   │   ├── pages/                         # Page Object classes
│   │   │   ├── BasePage.java              # Base page with common methods
│   │   │   ├── LoginPage.java
│   │   │   ├── StudentPortalPage.java
│   │   │   ├── GraduationRequirementsPage.java
│   │   │   ├── DocumentUploadPage.java
│   │   │   ├── AdminDashboardPage.java
│   │   │   └── ReportPage.java
│   │   │
│   │   ├── utils/                         # Utility classes
│   │   │   ├── DriverFactory.java         # WebDriver singleton
│   │   │   ├── ExcelDataProvider.java     # Excel data reader
│   │   │   ├── ConfigReader.java          # Configuration loader
│   │   │   ├── WaitUtils.java             # Explicit waits wrapper
│   │   │   └── ScreenshotUtils.java       # Screenshot capture
│   │   │
│   │   ├── config/                        # Configuration
│   │   │   ├── DriverConfig.java
│   │   │   └── AppConfig.java
│   │   │
│   │   └── models/                        # Data models
│   │       ├── StudentData.java
│   │       ├── GraduationRequirement.java
│   │       └── DocumentData.java
│   │
│   ├── test/java/
│   │   ├── base/
│   │   │   └── BaseTest.java              # Test base class with setup/teardown
│   │   │
│   │   ├── tests/
│   │   │   ├── AuthenticationTests.java   # Login/logout tests
│   │   │   ├── StudentPortalTests.java    # Student feature tests
│   │   │   ├── GraduationTests.java       # Graduation flow tests
│   │   │   ├── DocumentManagementTests.java
│   │   │   ├── AdminTests.java
│   │   │   ├── ReportGenerationTests.java
│   │   │   └── RegressionTests.java
│   │   │
│   │   └── listeners/
│   │       └── TestListener.java          # TestNG listener for reporting
│   │
│   └── resources/
│       ├── config.properties              # Application configuration
│       ├── testdata.xlsx                  # Test data (Excel)
│       └── logging.properties             # Logging configuration
│
├── allure-results/                        # Allure report data (auto-generated)
└── target/
    ├── surefire-reports/                  # TestNG reports
    └── site/                              # Allure HTML reports
```

## 🧪 Test Design Patterns Used

### **1. Page Object Model (POM)**
Encapsulates page elements and interactions:
```java
public class StudentPortalPage extends BasePage {
    // Locators
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By submitButton = By.xpath("//button[text()='Submit']");
    
    // Methods
    public void fillRegistrationForm(StudentData data) {
        type(firstNameField, data.getFirstName());
        type(lastNameField, data.getLastName());
    }
    
    public void submitForm() {
        click(submitButton);
    }
}
```

### **2. Data Provider Pattern**
Parameterized test data:
```java
@DataProvider(name = "studentCredentials")
public Object[][] getStudentCredentials() {
    return new Object[][] {
        {"student1@email.com", "password123", "VALID"},
        {"invalid@email.com", "wrongpass", "INVALID"}
    };
}

@Test(dataProvider = "studentCredentials")
public void testLogin(String email, String password, String expectedResult) { ... }
```

### **3. Custom Listeners**
Track test execution and generate reports:
```java
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getTestName());
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtils.captureScreenshot(result.getTestName());
    }
}
```

## 📊 Running Tests & Generating Reports

### Run Test Suite
```bash
mvn clean test
```

### Generate Allure Report
```bash
# Generate and open Allure report
mvn allure:serve

# Or manually generate HTML report
mvn allure:report
# Report location: target/site/allure-maven/index.html
```

### View TestNG Report
```bash
# Open TestNG HTML report
target/surefire-reports/index.html
```

## 📈 Report Features

**Allure Reports Include:**
- ✅ Test execution timeline
- 📊 Pass/fail statistics
- 🏷️ Test categorization and filtering
- 📸 Screenshots on failures
- 📝 Test logs and details
- 🔄 Test history and trends
- ⏱️ Execution duration analysis

## 🔧 Configuration Management

### config.properties
```properties
# Application URL
app.url=https://graduation-portal.example.com

# Browser Configuration
browser=chrome
headless=false
implicit.wait=10
explicit.wait=20

# Test Data
test.data.file=testdata.xlsx

# Reporting
screenshots.enabled=true
allure.enabled=true
```

### TestNG Groups
```java
@Test(groups = {"smoke", "regression"})
public void criticalTest() { ... }

@Test(groups = {"smoke"})
public void smokeTest() { ... }

@Test(groups = {"regression"})
public void regressionTest() { ... }
```

Run by group:
```bash
mvn test -Dgroups="smoke"
mvn test -Dgroups="smoke,regression"
```

## 🎓 Test Scenarios Covered

### **Authentication Tests**
- ✅ Valid login with correct credentials
- ✅ Login failure with incorrect password
- ✅ Login failure with inactive account
- ✅ Password reset functionality
- ✅ Session timeout handling

### **Student Portal Tests**
- ✅ Student registration
- ✅ Profile update
- ✅ Graduation requirement viewing
- ✅ Progress tracking
- ✅ GPA calculation verification

### **Document Management**
- ✅ Document upload success
- ✅ Unsupported file type rejection
- ✅ File size validation
- ✅ Document verification
- ✅ Download documents

### **Graduation Requirements**
- ✅ Requirement completion tracking
- ✅ Missing requirement alerts
- ✅ Graduation eligibility determination
- ✅ Degree audit report generation

### **Admin Functions**
- ✅ User account management
- ✅ Role assignment
- ✅ System settings modification
- ✅ Report access control

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

1. **Fork** the repository
2. **Create feature branch**: `git checkout -b feature/new-tests`
3. **Write tests** following existing patterns
4. **Ensure all tests pass**: `mvn clean test`
5. **Commit** with clear messages: `git commit -m "Add tests for graduation requirements"`
6. **Push** to your fork: `git push origin feature/new-tests`
7. **Create Pull Request** with description

### Code Style Standards
- Follow Java conventions (camelCase for methods, PascalCase for classes)
- Keep methods focused and small
- Add meaningful comments
- Use descriptive variable names
- Maintain 4-space indentation
- Document complex logic

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| ChromeDriver version mismatch | Update ChromeDriver to match Chrome version |
| Tests timeout | Increase `explicit.wait` in config.properties |
| Allure reports not generating | Run `mvn clean test` before `mvn allure:serve` |
| Port already in use (Allure) | Use different port: `mvn allure:serve -Dallure.port=8888` |
| Permission denied (ChromeDriver) | Make driver executable: `chmod +x chromedriver` |

## 🚀 Future Enhancements

- [ ] GitHub Actions CI/CD pipeline
- [ ] Headless browser execution
- [ ] Visual regression testing
- [ ] Performance testing
- [ ] API testing with REST Assured
- [ ] Parallel test execution optimization
- [ ] Multi-environment support (Dev/Staging/Prod)
- [ ] Email notifications for test results

## 📞 Support & Contact

- **Report Issues**: Use GitHub Issues
- **Discussions**: Start a GitHub Discussion
- **Contact**: Reach out via LinkedIn
- **Author**: Hazem Elgenidy | QA Automation Engineer

## 📜 License

This project is licensed under the MIT License - see LICENSE file for details.

---

**Made with ❤️ for Quality Assurance**

*Last Updated: May 2026*
