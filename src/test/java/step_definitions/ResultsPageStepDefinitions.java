package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.ResultsPageSteps;

public class ResultsPageStepDefinitions extends ResultsPageSteps {

    @And("the results should be returned accordingly")
    public void the_results_should_be_returned_accordingly() {
        checkSearchResults();
    }

    @When("add the first and the last products from the first page of results to the basket")
    public void add_the_first_and_the_last_products_from_the_first_page_of_results_to_the_basket(){
        addFirstProductToBasketFromResults()
                .addLastProductToBasketFromResults();
    }

    @Then("added products should be in the basket")
    public void added_products_should_be_in_the_basket() {
        getNumberOfProductsInTheBasket();
    }

    @When("filter by brand number {int}")
    public void filter_by_brand_number(Integer brandNumber) {
        selectProductBrandByOrderNumber(brandNumber);
    }

    @When("sort incoming results by number of comments")
    public void sort_incoming_results_by_number_of_comments() {
        sortByReviews();
    }

    @Then("order should be correct on Results Page")
    public void order_should_be_correct_on_results_page() {
        checkSortingResultsAccordingToCommentCount();
    }

    @When("list incoming products with free shipping")
    public void list_incoming_products_with_free_shipping() {
        filterByFreeShipping();
    }

    @Then("all products must be seen to come with free shipping")
    public void all_products_must_be_seen_to_come_with_free_shipping() {
        checkFreeShippingProducts();
    }
}
