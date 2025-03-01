# Car-Checking.com Automation Test Suite

This project is a Java-based automation test suite developed using the Cucumber-JVM framework. It is designed to test the functionalities of [Car-Checking.com](https://car-checking.com), a service that provides comprehensive vehicle verification reports.

## Table of Contents

- [Car-Checking.com Automation Test Suite](#car-checkingcom-automation-test-suite)
  - [Table of Contents](#table-of-contents)
  - [Project Overview](#project-overview)
  - [Prerequisites](#prerequisites)
  - [Installation and Setup](#installation-and-setup)
  - [Running the Tests](#running-the-tests)
  - [Known Issues](#known-issues)
  - [Contributing](#contributing)

## Project Overview

The test suite leverages Behavior-Driven Development (BDD) principles using Cucumber-JVM. It automates various user scenarios on Car-Checking.com, such as verifying vehicle details, checking for outstanding finance, and ensuring the vehicle hasn't been reported stolen.

## Prerequisites

Before setting up the project, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Maven**: For dependency management and build automation.
- **ChromeDriver**: Required for Selenium to interact with the Chrome browser. Ensure that the ChromeDriver version matches your installed Chrome browser version and is accessible in your system's PATH.

## Installation and Setup

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/your-username/car-checking-automation.git
   cd identity-ui-test
   ```

2. **Install Dependencies**:

   Use Maven to install the necessary dependencies:

   ```bash
   mvn clean install
   ```

   This command will download and set up all required libraries as specified in the `pom.xml` file.

3. **Configure WebDriver**:

   Ensure that the `chromedriver` executable is in your system's PATH. You can download it from the [official ChromeDriver site](https://sites.google.com/chromium.org/driver/).
   This project, automatically configures the webdriver so that you can focus more on writing test scenarios.

## Running the Tests

To execute the test suite, run:

```bash
mvn test
```

This command will initiate the Cucumber tests using Maven's test lifecycle. Test results will be displayed in the console, and detailed reports can be found in the `target/cucumber-reports` directory.

## Known Issues

- **Intermittent Test Failures**:
One test out of the 4 tests fails due to the car registration number not being found on Car-Checking.com. This issue arises because some test data uses registration numbers that do not exist in the website's database. To mitigate this, ensure that the test data includes valid and existing registration numbers.

## Contributing

I welcome contributions to enhance and expand this test suite. Please fork the repository, create a new branch for your feature or bug fix, and submit a pull request with a detailed description of your changes.
