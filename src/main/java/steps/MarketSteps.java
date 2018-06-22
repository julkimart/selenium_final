package steps;


import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;


public class MarketSteps {

    @Step("появился алерт с выбором города")
    public void stepWaitRegionAlert() {
        new MarketPage().waitRegionAlert();
    }

    @Step("выполнено нажатие на кнопку подтверждения города")
    public void stepRegionButton() {
        new MarketPage().regionButton.click();
    }


    @Step("появился товар в разделе Электроника - {0}")
    public void stepWaitGoodsInSubmenu(String goodsInSubmenu) {
        new MarketPage().waitGoodsInSubmenu(goodsInSubmenu);
    }

    @Step("выбран товар в разделе Электроника - {0}")
    public void stepChooseGoods(String subMenuItem) {
        new MarketPage().chooseGoods(subMenuItem);
    }


    @Step("появился заголовок - {0}")
    public void stepWaitTitle() {
        new MarketPage().waitTitle();
    }

    @Step("заголовок страницы равен - {0}")
    public void stepTitle(String expectedTitle) {
        String actualTitle = new MarketPage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }


    @Step("выполнено нажатие на кнопку - Перейти во всем фильтрам")
    public void stepAdvancedSearch() {
        new MarketPage().advancedSearch.click();
    }


}
