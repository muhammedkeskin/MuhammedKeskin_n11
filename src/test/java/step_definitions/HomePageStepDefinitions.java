package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import steps.HomePageSteps;
import utilities.ConfigurationReader;
import utilities.Driver;

public class HomePageStepDefinitions extends HomePageSteps {

    @Given("navigate to Home Page")
    public void navigate_to_home_page() {
        String url = ConfigurationReader.get("url");
        Driver.getDriver().get(url);
    }

    @When("search with keyword {string} on Home Page")
    public void search_with_keyword_on_home_page(String searchedKeyword) {
        closeAllAcceptPopup()
                .typeKeywordToSearchInputOnHomePage(searchedKeyword)
                .clickSearchIconOnHomePage();
    }
}
