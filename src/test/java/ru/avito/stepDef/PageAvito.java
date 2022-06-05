package ru.avito.stepDef;

import org.junit.Assert;

import static com.codeborne.selenide.Selenide.*;

public class PageAvito extends PageAbstract {
    private final AvitoElements avitoElements = page(AvitoElements.class);

    public PageAvito() {
        open("https://www.avito.ru/");
        webdriver().object().manage().window().maximize();
    }

    public void inputTextArea(String text) {
        avitoElements.textArea.click();
        avitoElements.textArea.sendKeys(text);
        avitoElements.app.click();
    }

    public void clickOnFieldCity() {
        avitoElements.locationSelect.click();
    }

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

    public void clickOnButton() {
        avitoElements.searchOnLocationField.click();
    }

    public void checkbox() {
        if (!avitoElements.checkBoxStatus.isSelected())
            avitoElements.checkBoxStatus.click();
    }

    public void checkOpenedPage(String word) {
        Assert.assertTrue("Значение не равны!", avitoElements.checkOpenedPage.getText().contains(word));
    }

    public void nameAndPrice(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(avitoElements.printersNames.get(i).getText());
            System.out.println(avitoElements.printersPrices.get(i).getText());
            System.out.println();
        }
    }
}
