package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.Driver;

import static utilities.PageUtils.*;

public class HomePageSteps extends HomePage {

    public HomePageSteps closeAllAcceptPopup() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement acceptButton = (WebElement) js.executeScript("return document.querySelector('efilli-layout-dynamic').shadowRoot.querySelector('div[id=\"480698fc-e6ac-41bc-a722-51059b783200\"]');");
        acceptButton.click();
        return this;
    }

    public HomePageSteps typeKeywordToSearchInputOnHomePage(String searchedKeyword) {
        typeToInput(searchInputOnHomePage, searchedKeyword);
        return this;
    }

    public void clickSearchIconOnHomePage() {
        clickElement(searchIconOnHomePage);
    }

}
