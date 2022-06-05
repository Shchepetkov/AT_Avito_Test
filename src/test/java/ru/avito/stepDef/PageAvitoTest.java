package ru.avito.stepDef;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.bg.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;

public class PageAvitoTest {
    private PageAvito page;

    @ParameterType(".*")
    public Categories categories(String category) {
        return Categories.valueOf(category);
    }

    @ParameterType(".*")
    public Filters filters(String filter) {
        return Filters.valueOf(filter);
    }

    @Step("Открыть ресурс авито")
    @Пусть("открыт ресурс авито")
    public void before() {
        page = new PageAvito();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @Step("В поле поиска ввести значение {text}")
    @И("в поле поиска введено значение {word}")
    public void inSearchFieldInput(String text) {
        page.inputTextArea(text);
    }

    @Step("В выпадающем списке категорий выбрать категорию {category}")
    @И("в выпадающем списке категорий выбрана {categories}")
    public void inDropDownListCategoryChoose(Categories category) {
        page.selectCategory(category.getName());
    }

    @Step("Активировать чекбокс только с фотографией")
    @И("активирован чекбокс только с фотографией")
    public void checkboxOnlyWithPhoto() {
        page.checkbox();
    }

    @Step("Кликнуть по выпадающему списку региона")
    @Тогда("кликнуть по выпадающему списку региона")
    public void clickOnDropDownListCity() {
        page.clickOnFieldCity();
    }

    @Step("В поле регион ввести значение {word}")
    @Тогда("в поле регион введено значение {word}")
    public void inFieldCityInput(String city) {
        page.searchForCity(city);
    }

    @Step("Нажать кнопку показать объявления")
    @И("нажата кнопка показать объявления")
    public void clickOnButtonShowAds() {
        page.clickOnButton();
    }

    @Step("Открылась страница результаты по запросу {word}")
    @Тогда("открылась страница результаты по запросу {word}")
    public void openedPageOnRequest(String word) {
        page.checkOpenedPage(word);
    }

    @Step("В выпадающем списке сортировка выбрать нужное значение {filters}")
    @И("в выпадающем списке сортировка выбрано значение {filters}")
    public void inDropDownListSortChoose(Filters filter) {
        page.selectFilter(filter.getName());
    }

    @Step("Вывести в консоль значение названия и цены {word} товаров")
    @И("в консоль выведено значение названия и цены {word} первых товаров")
    public void nameAndPriceOfProduct(String count) {
        page.nameAndPrice(Integer.parseInt(count));
    }

    @AfterStep
    @SuppressWarnings("unused")
    public void after() {
        page.getScreenshot();
    }

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
    }

}
