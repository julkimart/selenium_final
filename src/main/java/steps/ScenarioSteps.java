package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    MarketSteps marketSteps = new MarketSteps();
    SearchSteps searchSteps = new SearchSteps();




    @When("^выбран пункт меню \"(.+)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps.stepSelectMainMenu(menuItem);
    }
    @Then("^появился алерт с выбором города")
    public void stepWaitRegionAlert(){ marketSteps.stepWaitRegionAlert();}
    @Then("^выполнено нажатие на кнопку подтверждения города")
    public void stepRegionButton(){ marketSteps.stepRegionButton();}


    @When("^выбран вид подменю - \"(.+)\"$")
    public void stepSelectSubMenu(String menuItem){
        mainSteps.stepSelectSubMenu(menuItem);
    }
    @Then("^появилось всплывающее меню от Электроники")
    public void stepWaitSubMenu(){
        mainSteps.stepWaitSubMenu();
    }
    @Then("^появился товар в разделе Электроника - \"(.+)\"$")
    public void stepWaitGoodsInSubmenu(String goodsInSubmenu){
        marketSteps.stepWaitGoodsInSubmenu(goodsInSubmenu);
    }



    @When("^выбран товар в разделе Электроника - \"(.+)\"$")
    public void stepChoose(String subMenuItem){
        marketSteps.stepChooseGoods(subMenuItem);
    }
    @When("^появился заголовок - \"(.+)\"$")
    public void stepWaitTitle(String expectedTitle){ marketSteps.stepWaitTitle();}

    @Then("^заголовок страницы равен - \"(.+)\"$")
    public void stepCheckTitle(String expectedTitle){
        marketSteps.stepTitle(expectedTitle);
    }

    @When("^выполнено нажатие на кнопку - Перейти во всем фильтрам")
    public void stepAdvancedSearch(){
        marketSteps.stepAdvancedSearch();
    }
    @Then("^заголовок страницы равен - Все фильтры")
    public void stepTitleSearch(){
        searchSteps.stepTitleSearch("Все фильтры");
    }





    @When("^заполняются поля:$")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((key, value) -> searchSteps.stepFillField(key, value));
    }
    @Then("^значения полей равны:$")
    public void stepCheckFillFields(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((key, value) -> searchSteps.stepCheckFillField(key, value));
    }


    @When("выбран бренд в расширенном поиске - \"(.+)\"$")
    public void stepChooseLabel(String labelItem){
        searchSteps.stepChooseLabel(labelItem);
    }
    @When("^выполнено нажатие на кнопку - Показать подходящие")
    public void stepApplyButton(){
        searchSteps.stepApplyButton();
    }
    @When("^выполнен выбор отображения товаров - список")
    public void stepListView(){
        searchSteps.stepListView();
    }
    @Then("^выполнена проверка по количеству найденных товаров, количество - \"(.+)\"$")
    public void stepCheckCount(int expectedValue){ searchSteps.stepCheckCountProducts(expectedValue);    }



    @When("^первый элемент в списке запомнен")
    public void stepRememberExpectedElement(){
        searchSteps.stepRememberExpectedElement();
    }
    @When("^в поисковую строку введено запомненное значение")
    public void stepFillFieldSearch(){
        searchSteps.stepFillFieldSearch();
    }
    @When("^выполнено нажатие на кнопку - Поиск")
    public void stepSearchButton(){
        searchSteps.stepSearchButton();
    }

    @Then("^появился новый элемент после нового поиска")
    public void stepWaitElementFromNewSearch(){ searchSteps.stepWaitElementFromNewSearch();    }
    @Then("^выполнено нажатие на первый новый найденный элемент среди наушников")
    public void stepNewElementfromBeats() {searchSteps.stepNewElementFromBeats(); }
    @Then("^выполнена проверка: запомненный элемент равен новому найденному")
    public void stepCheckElements(){ searchSteps.stepCheckElements();    }


}
