package ru.testing.steps.features.avito;

import io.cucumber.java.ParameterType;
import io.cucumber.java.bg.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import java.util.logging.Logger;
import ru.testing.steps.features.avito.enumeration.Categories;
import ru.testing.steps.features.avito.enumeration.Filters;


public class PageAvitoStepsTest {
    private final PageAvito pageAvito = new PageAvito();
    private static final Logger log = Logger.getLogger(PageAvitoStepsTest.class.getName());

    @ParameterType(".*")
    public Categories categories(String category) {
        return Categories.valueOf(category);
    }

    @ParameterType(".*")
    public Filters filters(String filter) {
        return Filters.valueOf(filter);
    }

    @Step("Открыть ресурс авито")
    @Пусть("открыть ресурс авито")
    public void before() {
        pageAvito.openSite();
        log.info("Открыт ресурс авито");
    }

    @Step("В поле поиска ввести значение {text}")
    @И("в поле поиска введено значение {word}")
    public void inSearchFieldInput(String text) {
        pageAvito.inputTextArea(text);
        log.info(String.format("В поле поиска введено значение %s", text));
    }

    @Step("В выпадающем списке все категории в разделе {section} выбрать категорию {category}")
    @И("в выпадающем списке все категории в разделе {word} выбрана {categories}")
    public void inDropDownListCategoryChoose(String section, Categories category) {
        pageAvito.selectCategory(section, category.getName());
        log.info(String.format("В выпадающем списке категорий выбрана %s", category.getName()));
    }

    @Step("Активирован любой чекбокс на странице")
    @И("активирован любой чекбокс на странице")
    public void checkboxOnlyWithPhoto() {
        pageAvito.checkbox();
        log.info("Активирован любой чекбокс на странице");
    }

    @Step("Кликнуть по выпадающему списку региона")
    @Тогда("кликнуть по выпадающему списку региона")
    public void clickOnDropDownListCity() {
        pageAvito.clickOnFieldCity();
        log.info("Раскрылся выпадающий список регионов");
    }

    @Step("В поле регион ввести значение {city}")
    @Тогда("в поле регион введено значение {word}")
    public void inFieldCityInput(String city) {
        pageAvito.searchForCity(city);
        log.info(String.format("В поле регион введено значение %s", city));
    }

    @Step("Нажать кнопку показать объявления")
    @И("нажата кнопка показать объявления")
    public void clickOnButtonShowAds() {
        pageAvito.clickOnButton();
        log.info("Была нажата кнопка показать объявления");
    }

    @Step("Открылась страница результаты по запросу {word}")
    @Тогда("открылась страница результаты по запросу {word}")
    public void openedPageOnRequest(String word) {
        pageAvito.checkOpenedPage(word);
        log.info(String.format("открылась страница результаты по запросу %s", word));
    }

    @Step("В выпадающем списке сортировка выбрать нужное значение {filter}")
    @И("в выпадающем списке сортировка выбрано значение {filters}")
    public void inDropDownListSortChoose(Filters filter) {
        pageAvito.selectFilter(filter.getName());
        log.info(String.format("В выпадающем списке сортировка выбрано значение %s", filter.getName()));
    }

    @Step("Вывести в консоль значение названия и цены {count} товаров")
    @И("в консоль выведено значение названия и цены {word} первых товаров")
    public void nameAndPriceOfProduct(String count) {
        pageAvito.nameAndPrice(Integer.parseInt(count));
        log.info(String.format("В консоль выведено значение названия и цены %s первых товаров", count));
    }
}
