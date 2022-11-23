package ru.testing.steps.features.avito;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.testing.steps.PageAbstract;
import ru.testing.steps.locators.AvitoElements;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static utils.XPathUtils.formatSearch;

public class PageAvito extends PageAbstract {
    private final AvitoElements avitoElements = page(AvitoElements.class);

    @DisplayName("В поле поиска ввести значение")
    public void inputTextArea(String text) {
        avitoElements.textArea.click();
        avitoElements.textArea.sendKeys(text);
        avitoElements.app.click();
    }

    @DisplayName("Кликнуть по выпадающему списку региона")
    public void clickOnFieldCity() {
        avitoElements.locationSelect.click();
    }

    @DisplayName("В поле регион ввести значение")
    public void searchForCity(String city) {
        avitoElements.location.sendKeys(city);
        avitoElements.location.click();

        while (true) {
            if (avitoElements.locationField.getText().startsWith(city)) {
                avitoElements.locationField.click();
                break;
            }
        }
    }

    @DisplayName("Нажать кнопку показать объявления")
    public void clickOnButton() {
        avitoElements.searchOnLocationField.click();
    }

    @DisplayName("Активировать чекбокс только с фотографией")
    public void checkbox() {
        if (!avitoElements.checkBoxStatus.isSelected())
            avitoElements.checkBoxStatus.click();
    }

    @DisplayName("Открылась страница результаты по искомому запросу")
    public void checkOpenedPage(String word) {
        Assert.assertTrue("Значение не равны!", avitoElements.checkOpenedPage.getText().contains(word));
    }

    @DisplayName("Вывести в консоль значение названия и цены нужного количества товаров")
    public void nameAndPrice(int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println(avitoElements.printersNames.get(i).getText());
            System.out.println(avitoElements.printersPrices.get(i).getText());
            System.out.println();
            Allure.addAttachment(String.format("Вывести в консоль значение названия и цену %s товарова", i),
                    String.format("Название: %s,\n Цена: %s", avitoElements.printersNames.get(i).getText(), avitoElements.printersPrices.get(i).getText()));
        }
    }

    @DisplayName("В выпадающем списке сортировка выбрать нужное значение")
    public void selectFilter(String sortValue) {
        avitoElements.selectFilter.selectOption(sortValue);
    }

    @DisplayName("В выпадающем списке категорий выбрать категорию")
    public void selectCategory(String section, String category) {
        if (avitoElements.selectAllCategory.exists())
            avitoElements.selectAllCategory.shouldBe(Condition.visible).click();
        else
            avitoElements.selectFromListCategory.shouldBe(Condition.visible).selectOption(category);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if ($(By.xpath(formatSearch(AvitoElements.section, section))).exists()) {
            $(By.xpath(formatSearch(AvitoElements.section, section))).shouldBe(Condition.visible).click();
            $$(By.xpath(formatSearch(AvitoElements.selectCategory, category))).first().shouldBe(Condition.visible).click();
        } else
            $$(By.xpath(formatSearch(AvitoElements.selectCategoryOld, category))).first().click();
    }

    @Override
    public void openSite() {
        open("https://www.avito.ru/");
        webdriver().object().manage().window().maximize();
    }
}
