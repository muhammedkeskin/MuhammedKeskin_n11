package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ResultsPage;
import utilities.Driver;
import static utilities.PageUtils.*;

import static utilities.PageUtils.clickElement;

public class ResultsPageSteps extends ResultsPage {

    int addedProductCount;

    public void checkSearchResults() {
        for (var productText : productNames) {
            Assert.assertTrue("results are not related with searched keyword",
                    productText.getText().toLowerCase().contains("iphone"));
        }
    }

    public ResultsPageSteps addFirstProductToBasketFromResults() {
        addProductBasketProcess(addFirstProductButton, colorOptionButton, memoryOptionButton );
        addedProductCount++;
        return this;
    }

    private void addProductBasketProcess(WebElement product, WebElement color, WebElement memory) {
        clickElement(product);
        addOptionToProduct(color);
        addOptionToProduct(memory);
        waitFor(1);
        clickElementWithJS(Driver.getDriver(), addToBasketButton);
    }

    public void addLastProductToBasketFromResults() {
        var addLastProductButton = addToBasketButtons.get(addToBasketButtons.size()-1);
        addProductBasketProcess(addLastProductButton, colorOptionButton, memoryOptionButton);
        addedProductCount++;
    }

    private void addOptionToProduct(WebElement option) {
        clickElement(option);
    }

    public void getNumberOfProductsInTheBasket() {
        waitFor(1);
        var productCountInTheBasket = Integer.parseInt(basketIcon.getText());
        Assert.assertEquals(productCountInTheBasket, addedProductCount);
    }

    public void selectProductBrandByOrderNumber(int brandNumber){
        WebElement brand =
                Driver.getDriver().findElement(By.xpath("(//h2[text()='Marka']/..//input[@class='brand-checkbox'])["+brandNumber+"]/../a"));

        clickElement(brand);
    }

    public void sortByReviews() {
        clickElement(sortingOptionsButton);
        clickElement(sortByReviewsButton);
    }

    public void checkSortingResultsAccordingToCommentCount() {
        var ratingCounts = Driver.getDriver().findElements(By.xpath("//li//span[@class='ratingText']"));
        for (var i=0;i<ratingCounts.size()-1;i++) {
            var countBigger = Integer.parseInt(ratingCounts.get(i).getText().replace(",","")
                    .replace("(","").replace(")",""));
            var countSmaller = Integer.parseInt(ratingCounts.get(i+1).getText().replace(",","")
                    .replace("(","").replace(")",""));

            Assert.assertTrue(countBigger>=countSmaller);
        }
    }

    public void filterByFreeShipping() {
        clickElement(shippingOptionsFilter);
        clickElement(freeShippingFilterRadioButton);
    }

    public void checkFreeShippingProducts() {
        Assert.assertEquals(freeShippingProductOnResultsPage.size(), productsOnResultsPage.size());
    }

}
