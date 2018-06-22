package steps;


import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;


public class MainSteps {

    @Step("выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem) {
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("выбран вид подменю {0}")
    public void stepSelectSubMenu(String menuItem) {
        new MainPage().selectSubMenu(menuItem);
    }

    @Step("появилось выпадающее меню от электроники")
    public void stepWaitSubMenu() {
        new MainPage().waitSubMenu();
    }


}
