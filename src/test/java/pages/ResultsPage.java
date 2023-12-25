package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ResultsPage {

    public ResultsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='btnBasket'])[1]")
    public WebElement addFirstProductButton;

    @FindBy(xpath = "//input[@data-name='RENK']//..")
    public WebElement colorOptionButton;

    @FindBy(xpath = "//input[@data-name='DAHİLİ HAFIZA']//..")
    public WebElement memoryOptionButton;

    @FindBy(xpath = "//div[@class='basket-container']//span")
    public WebElement addToBasketButton;

    @FindBy(css = ".basketTotalNum")
    public WebElement basketIcon;

    @FindBy(css = ".selectedText")
    public WebElement sortingOptionsButton;

    @FindBy(css = "[data-value='REVIEWS']")
    public WebElement sortByReviewsButton;

    @FindBy(xpath = "//span[text()='Ücretsiz Kargo']")
    public WebElement freeShippingFilterRadioButton;

    @FindBy(xpath = "//h2[text()='Kargo Seçenekleri']")
    public WebElement shippingOptionsFilter;

    @FindBy(css = ".lazy.cardImage")
    public List<WebElement> productsOnResultsPage;

    @FindBy(xpath = "//div[@class='cargoBadgeField  ']")
    public List<WebElement> freeShippingProductOnResultsPage;

    @FindBy(xpath = "//div[@class='columnContent']//span[@class='btnBasket']")
    public List<WebElement> addToBasketButtons;

    @FindBy(css = ".productName")
    public List<WebElement> productNames;

}
