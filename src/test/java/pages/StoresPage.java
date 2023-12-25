package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StoresPage {

    public StoresPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='tabPanel allSellers']//div[@class='sellerListHolder']//li")
    public List<WebElement> listOfAllStores;

    @FindBy(css = "div[class='resultText ']>h1")
    public WebElement searchResultLocator;

}
