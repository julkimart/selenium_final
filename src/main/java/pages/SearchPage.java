package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SearchPage {

    public SearchPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);

    }


    //название заголовка все фильтры
    @FindBy(xpath = "//h1[contains(text(),'Все фильтры')]")
    public WebElement titleSearch;

    @FindBy(name = "glf-pricefrom-var")
    public WebElement pricefrom;
    @FindBy(xpath = "//label[contains(text(),'Samsung')]")
    public WebElement Samsung;
    @FindBy(xpath = "//label[contains(text(),'LG')]")
    public WebElement LG;
    @FindBy(xpath = "//label[contains(text(),'Beats')]")
    public WebElement Beats;

    @FindBy(xpath = "//a[contains(@class,'button button_size_l')]")
    public WebElement applyButton;

    //строка поиска
    @FindBy(name = "text")
    public WebElement text;

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Цена от":
                fillField(pricefrom, value);
                break;

            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Цена от":
                return pricefrom.getAttribute("value");

        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }


    public void chooseLabel(String labelItem) {
        switch (labelItem) {
            case "Samsung":
                Samsung.click();
                break;
            case "LG":
                LG.click();
                break;
            case "Beats":
                Beats.click();
                break;
            default:
                throw new AssertionError("Поле '" + labelItem + "' не найдено");
        }
    }


    //список найденных товаров
    @FindBy(xpath = "//div[contains(@class,'n-snippet-card2 i-bem')]//div[@class='n-snippet-card2__title']")
    List<WebElement> foundedProducts;

    //количество найденных товаров
    public int getSizeFoundedProducts() {
        return foundedProducts.size();
    }

    //вид товаров - список
    @FindBy(xpath = "//span[contains(@class,'radio-button radio-button_size_s')]//input[@value='list']")
    public WebElement listView;


    //первый элемент в списке
    public String getFirstElement() {
        return foundedProducts.get(0).getText();
    }

    //в поисковую строку ввести запомненное значение
    public void fillFieldSearch(String expectedElement) {
        text.sendKeys(expectedElement);
    }

    //кнопка поиск
    @FindBy(xpath = "//span[@class='search2__button']//button[@role='button']")
    public WebElement searchButton;


    //открыть первые найденные наушники после поиска
    public void newElementFromBeats() {
        BaseSteps.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        foundedProducts.get(0).click();
    }

    //товар из нового поиска (тот с которым сравнивать)
    @FindBy(xpath = "//h1[contains(@class,'title')]")
    public WebElement elementFromNewSearch;

    //дождаться пока новый элемент появится
    public void waitElementFromNewSearch() {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 20, 2000);
        wait.until(ExpectedConditions.visibilityOf(elementFromNewSearch));
    }


}
