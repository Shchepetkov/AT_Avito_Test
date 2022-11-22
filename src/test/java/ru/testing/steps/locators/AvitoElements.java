package ru.testing.steps.locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AvitoElements {
    @FindBy(css = "input[autocomplete = 'off'][maxlength = '100']")
    public SelenideElement textArea;

    @FindBy(css = "#app>div")
    public SelenideElement app;

    @FindBy(xpath = "//div[contains(@data-marker,'search-form/region')]")
    public SelenideElement locationSelect;

    @FindBy(xpath = "//span[contains(text(), 'фото')]")
    public SelenideElement checkBoxStatus;

    @FindBy(css = "input[data-marker = 'popup-location/region/input']")
    public SelenideElement location;

    @FindBy(css = "li[data-marker = 'suggest(0)']")
    public SelenideElement locationField;

    @FindBy(xpath = "//button[contains(@data-marker,'save-button')]")
    public SelenideElement searchOnLocationField;

    @FindBy(css = "h1[data-marker = 'page-title/text']")
    public SelenideElement checkOpenedPage;

    @FindBy(xpath = "//a[@data-marker='item-title']/h3[@itemprop='name']")
    public List<SelenideElement> printersNames;

    @FindBy(xpath = "//span[@data-marker='item-price']/span[contains(@class,'price')]")
    public List<SelenideElement> printersPrices;

    @FindBy(css = "div.index-topPanel-McfCA  select.select-select-IdfiC")
    public SelenideElement selectFilter;

    @FindBy(css = "#category")
    public SelenideElement selectFromListCategory;

    @FindBy(xpath = "//span[contains(text(), 'категории')]/ancestor::button")
    public SelenideElement selectAllCategory;

    public static String selectCategory = "//div[@class = 'new-rubricator-content-childrenWrapper-gBEcA']/descendant::*[text() = '%1$s']";

    public static String selectCategoryOld = "//*[text() = '%1$s']";

    public static String section = "//div[@class = 'new-rubricator-content-root-X25iB']/descendant::*[text() = '%1$s']";

}
