# N11 Test Automation with Cucumber

This project demonstrates automated testing of a user journey on the N11 website using Cucumber, Selenium, and Java 21.

## Prerequisites

- Java Development Kit (JDK 21)
- Maven
- Browser Drivers (ChromeDriver, GeckoDriver)

## Setup

1. Clone the repository: `git clone https://github.com/muhammedkeskin/Muhammedkeskin_n11`
2. Install dependencies: `mvn clean install`

## Running Tests

1. Open the terminal/command prompt in the project directory.
2. Run the tests using Maven: `mvn test`

## Scenarios

The test scenarios covered in this project includes:

    1. Scenario: Sorting and filtering products by free shipping

      Given navigate to Home Page
      When search with keyword "telefon" on Home Page
      And filter by brand number 2
      And sort incoming results by number of comments
      Then order should be correct on Results Page
      When list incoming products with free shipping
      Then all products must be seen to come with free shipping


    2. Scenario: Searching with wrong keyword

      Given navigate to Home Page
      When search with keyword "iPhone" on Home Page
      And the results should be returned accordingly
      When add the first and the last products from the first page of results to the basket
      Then added products should be in the basket


    3. Scenario: Filter Stores By Letter

      Given navigate to Stores Page
      When click On "Tüm Mağazalar" button
      And filter the stores starting with the letter "S"
      And click on a random store
      Then the page of the selected store should be displayed

## Project Structure

The project follows the Page Object Model (POM) design pattern for better organization and maintainability of test code. It includes the following packages:

- `pages`: Contains Page Object classes that define web element locators on pages.
- `runners`: Contains Cucumber runner classes (`CukesRunner` and `FailedTestRunner`) to execute the feature files.
- `step_definitions`: Contains Cucumber step definition classes that map the Gherkin steps to Java methods.
- `steps`: Contains methods that implement the test steps.
- `utils`: Contains utility classes for page utils, configuration reading, and Driver(WebDriver setup).

## Configuration

Browser configuration and other settings can be customized in the `configuration.properties`.

## Reporting

Test reports are generated using the default Cucumber HTML report plugin. After running tests, the report can be found at `target/n11-html-reports.html`.

## Notes

- Please make sure to have the appropriate browser drivers (ChromeDriver, GeckoDriver) installed and added to the system's PATH.
- You can modify the scenario or add new ones as needed in the feature files located in the `src/test/resources` directory.
