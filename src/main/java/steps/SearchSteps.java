package steps;

import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchSteps {


    @Step("заголовок страницы - Все фильтры")
    public void stepTitleSearch(String expectedTitle) {
        String actualTitle = new SearchPage().titleSearch.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }


    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        new SearchPage().fillField(field, value);
    }

    @Step("заполняются поля")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("поле {0} заполнено значением {1}")
    public void stepCheckFillField(String field, String value) {
        String actual = new SearchPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }


    @Step("выбран бренд в расширенном поиске - {0}")
    public void stepChooseLabel(String labelItem) {
        new SearchPage().chooseLabel(labelItem);
    }

    @Step("выполнено нажатие на кнопку - Показать подходящие")
    public void stepApplyButton() {
        new SearchPage().applyButton.click();
    }

    @Step("выполнена проверка по количеству найденных товаров - {0}")
    public void stepCheckCountProducts(int expectedValue) {
        int actualValue = new SearchPage().getSizeFoundedProducts();
        assertEquals(actualValue, expectedValue, 0);
    }


    //вид товаров - список
    @Step("выполнен выбор отображения товаров - список")
    public void stepListView() {
        new SearchPage().listView.click();
    }


    String expectedElement;

    //первый элемент в списке запомнен
    @Step("первый элемент в списке запомнен")
    public void stepRememberExpectedElement() {
        expectedElement = new SearchPage().getFirstElement();
    }


    @Step("в поисковую строку ввести запомненное значение")
    public void stepFillFieldSearch() {
        new SearchPage().fillFieldSearch(expectedElement);
    }

    @Step("выполнено нажатие на кнопку - Поиск")
    public void stepSearchButton() {
        new SearchPage().searchButton.click();
    }

    @Step("появился новый элемент после нового поиска")
    public void stepWaitElementFromNewSearch() {
        new SearchPage().waitElementFromNewSearch();
    }

    @Step("выполнена проверка: запомненный элемент равен новому найденному")
    public void stepCheckElements() {
        String actualElement = new SearchPage().elementFromNewSearch.getText();
        assertTrue(String.format("Элемент равен [%s]. Ожидалось - [%s]",
                actualElement, expectedElement), actualElement.contains(expectedElement));
    }


    //открыть первые найденные наушники после поиска
    @Step("открыть первый новый найденный элемент среди наушников")
    public void stepNewElementFromBeats() {
        new SearchPage().newElementFromBeats();
    }

}

