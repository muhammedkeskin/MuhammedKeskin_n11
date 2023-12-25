package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.StoresPage;
import utilities.Driver;

import java.util.Random;

import static utilities.PageUtils.*;

public class StoresPageSteps extends StoresPage {

    static String selectedStoreTitle;

    public void clickOnStoreOption(String storesOption) {
        String xpathExpression = "//h3[(text()='" + storesOption + "')]";

        clickOnButtonByGivenValue(xpathExpression);
    }

    public void clickOnLetterOrFigureOnStoresPage(String letterOrFigure){
        String xpathExpression = "//span[@title='" + letterOrFigure + "']";

        clickOnButtonByGivenValue(xpathExpression);
    }

    private void clickOnButtonByGivenValue(String givenValue) {
        try {
            WebElement storeOptionElement = Driver.getDriver().findElement(By.xpath(givenValue));
            waitFor(2);
            clickElement(storeOptionElement);

        } catch (NoSuchElementException e) {
            System.err.println("Hata: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickOnRandomStore() {
        var sizeOfStores = listOfAllStores.size();
        var randomNum = generateRandomNumber(sizeOfStores);
        var randomStoreElement = (Driver.getDriver().findElement(
                By.xpath("(//div[@class='tabPanel allSellers']//div[@class='sellerListHolder']//li/a)["+randomNum+"]")));
        selectedStoreTitle = randomStoreElement.getAttribute("title");
        clickElement(randomStoreElement);
    }

    private int generateRandomNumber(int n) {
        Random random = new Random();

        return random.nextInt(n) + 1;

    }

    public void checkSelectedStore() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(searchResultLocator.getText()));
    }

}