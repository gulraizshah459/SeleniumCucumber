# Cucumber-Selenium Automation Framework for Mercari

This project is a Cucumber-Selenium based automation framework designed to test the Mercari website (https://jp.mercari.com/). It uses Java as the programming language, JUnit as the test runner, and Maven as the build tool.

## Prerequisites

* **JDK 11 or higher:** Ensure you have a compatible Java Development Kit installed.
* **Maven:**  Make sure Maven is installed and configured on your system.


## Project Structure

* **`src/test/java`:**
    * Contains the step definition classes (`com.mercari.automation.StepDefinitions.StepDefinition`), page object classes (`com.mercari.automation.PageRepo.SearchRepo`), and Cucumber hooks (`com.mercari.automation.Hooks.cucumberHooks`).
    * The `RunnerTest` class is responsible for executing the Cucumber tests.
* **`src/test/resources/Features`:**  Contains the feature files (`.feature` files) describing the test scenarios.
* **`src/main/java`:**  Contains the driver factory class (`DriverFactory`) and utility functions (`CommonFunctions`).

## Framework Overview

* **Cucumber:** A tool for behavior-driven development (BDD), allowing you to write tests in a human-readable format using Gherkin language.
* **Selenium:** A widely-used browser automation framework for interacting with web elements.
* **Java:** The programming language used for writing step definitions and framework code.
* **Maven:**  A build automation tool for managing dependencies and the project lifecycle.
* **Page Object Model (POM):**  The framework follows the POM design pattern to enhance code organization and maintainability. The `SearchRepo` class encapsulates page elements and actions for the Mercari search page.
* **Driver Factory:** The `DriverFactory` class handles the initialization and configuration of the WebDriver, including browser selection and maximizing the window.
* **Utility Functions:** The `CommonFunctions` class provides reusable utility functions for waiting for elements to be displayed or selected.

## Running the Tests

1. **Clone the repository:** `git clone <repository_url>`
2. **Navigate to the project directory:** `cd <project_directory>`
3. **Execute the tests:** `mvn clean test`


## Additional Notes

* The framework is designed to be extensible and can be easily adapted to test other areas of the Mercari website or other web applications.
* Consider adding more robust reporting (e.g., using ExtentReports or Allure) for enhanced test analysis and visualization.
* You can configure the framework to use different browsers by modifying the `getDriver()` method in the `DriverFactory` class.
* Refer to the Cucumber and Selenium documentation for more advanced features and capabilities.