
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class MainPage {
   // WebDriver driver;
    @FindBy(xpath = "//div[@class='home-tabs stream-control i-bem dropdown-menu home-tabs_js_inited']")
    WebElement mainMenu;

    @FindBy(xpath = "//ul[@class='topmenu__list']")
    WebElement subMenu;

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }



    //маркет
    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//a[contains(text(),'"+menuItem+"')]")).click();
    }

    //электроника - всплывающее меню
    public void selectSubMenu(String menuItem) {
        Actions action = new Actions(BaseSteps.getDriver());
        action.moveToElement(subMenu.findElement(By.xpath(".//a[contains(text(),'"+menuItem+"')][contains(@class,'link topmenu__link')]")));
        action.perform();
    }

    //дождаться выпадающее меню
    public void waitSubMenu () {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 10, 2000);
        wait.until(ExpectedConditions.visibilityOf(subMenu));
    }







}


