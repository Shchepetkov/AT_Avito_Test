package ru.testing.steps.features.avito;

import io.cucumber.java.ParameterType;
import io.cucumber.java.bg.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import ru.testing.steps.features.avito.enumeration.Categories;
import ru.testing.steps.features.avito.enumeration.Filters;

public class PageAvitoStepsTest {
    private final PageAvito pageAvito = new PageAvito();

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
    }

    @Step("В поле поиска ввести значение {text}")
    @И("в поле поиска введено значение {word}")
    public void inSearchFieldInput(String text) {
        pageAvito.inputTextArea(text);
    }

    @Step("В выпадающем списке категорий выбрать категорию {category}")
    @И("в выпадающем списке категорий выбрана {categories}")
    public void inDropDownListCategoryChoose(Categories category) {
        pageAvito.selectCategory(category.getName());
    }

    @Step("Активировать чекбокс только с фотографией")
    @И("активирован чекбокс только с фотографией")
    public void checkboxOnlyWithPhoto() {
        pageAvito.checkbox();
    }

    @Step("Кликнуть по выпадающему списку региона")
    @Тогда("кликнуть по выпадающему списку региона")
    public void clickOnDropDownListCity() {
        pageAvito.clickOnFieldCity();
    }

    @Step("В поле регион ввести значение {city}")
    @Тогда("в поле регион введено значение {word}")
    public void inFieldCityInput(String city) {
        pageAvito.searchForCity(city);
    }

    @Step("Нажать кнопку показать объявления")
    @И("нажата кнопка показать объявления")
    public void clickOnButtonShowAds() {
        pageAvito.clickOnButton();
    }

    @Step("Открылась страница результаты по запросу {word}")
    @Тогда("открылась страница результаты по запросу {word}")
    public void openedPageOnRequest(String word) {
        pageAvito.checkOpenedPage(word);
    }

    @Step("В выпадающем списке сортировка выбрать нужное значение {filter}")
    @И("в выпадающем списке сортировка выбрано значение {filters}")
    public void inDropDownListSortChoose(Filters filter) {
        pageAvito.selectFilter(filter.getName());
    }

    @Step("Вывести в консоль значение названия и цены {count} товаров")
    @И("в консоль выведено значение названия и цены {word} первых товаров")
    public void nameAndPriceOfProduct(String count) {
        pageAvito.nameAndPrice(Integer.parseInt(count));
    }
}
