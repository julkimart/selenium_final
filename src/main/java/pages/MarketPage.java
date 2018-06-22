package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


public class MarketPage {


    @FindBy(xpath = "//ul[@class='topmenu__list']//a[text()='Телевизоры']")
    public WebElement tv;

    @FindBy(xpath = "//ul[@class='topmenu__list']//a[@class='link topmenu__subitem'][text()='Наушники']")
    public WebElement beats;

    @FindBy(xpath = "//h1[contains(@class,'title')]")
    public WebElement title;

    //ваш город спб?
    @FindBy(xpath = "//div[@class='n-region-notification_layout_init']")
    public WebElement regionAlert;
    //кнопка - подтверждаем город
    @FindBy(xpath = "//span[contains(@class,'button2 button2_size_m button2_theme_action')]")
    public WebElement regionButton;

    //все фильтры
    @FindBy(xpath = "//a[contains(text(),'Перейти ко всем фильтрам')]")
    public WebElement advancedSearch;

    //дождаться алерта выбора города
    public void waitRegionAlert() {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 20, 2000);
        wait.until(ExpectedConditions.visibilityOf(regionAlert));
    }


    //дождаться заголовка Телевизоры / Наушники
    public void waitTitle() {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 20, 2000);
        wait.until(ExpectedConditions.visibilityOf(title));
    }


    //дождаться видимости Телевизоры / Наушники
    public void waitGoodsInSubmenu(String goodsInSubmenu) {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 20, 2000);
        switch (goodsInSubmenu) {
            case "Телевизоры":
                wait.until(ExpectedConditions.visibilityOf(tv));
                break;
            case "Наушники":
                wait.until(ExpectedConditions.visibilityOf(beats));
                break;
            default:
                throw new AssertionError("Поле '" + goodsInSubmenu + "' не найдено");
        }
    }


    //выбрать товар в разделе Электроника
    public void chooseGoods(String subMenuItem) {
        switch (subMenuItem) {
            case "Телевизоры":
                BaseSteps.getDriver().findElement(By.xpath
                        ("//ul[@class='topmenu__list']//a[text()='" + subMenuItem + "']")).click();
                break;
            case "Наушники":
                BaseSteps.getDriver().findElement(By.xpath
                        ("//ul[@class='topmenu__list']//a[text()='" + subMenuItem + "']")).click();
                break;
            default:
                throw new AssertionError("Поле '" + subMenuItem + "' не найдено");
        }
    }


    public MarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 40, 1000);
    }


}
