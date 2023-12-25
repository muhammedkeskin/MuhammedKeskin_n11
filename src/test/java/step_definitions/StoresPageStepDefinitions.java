package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.HomePageSteps;
import steps.StoresPageSteps;
import utilities.ConfigurationReader;
import utilities.Driver;

public class StoresPageStepDefinitions extends StoresPageSteps {

    HomePageSteps homePageSteps = new HomePageSteps();

    @Given("navigate to Stores Page")
    public void navigate_to_stores_page() {
        String url = ConfigurationReader.get("storesUrl");
        Driver.getDriver().get(url);
    }

    @When("click On {string} button")
    public void click_on_button(String storesOptions) {
        homePageSteps.closeAllAcceptPopup();
        clickOnStoreOption(storesOptions);
    }

    @When("filter the stores starting with the letter {string}")
    public void filter_the_stores_starting_with_the_letter(String letterOrFigure) {
        clickOnLetterOrFigureOnStoresPage(letterOrFigure);
    }

    @When("click on a random store")
    public void click_on_a_random_store() {
        clickOnRandomStore();
    }

    @Then("the page of the selected store should be displayed")
    public void the_page_of_the_selected_store_should_be_displayed() {
        checkSelectedStore();
    }
}
