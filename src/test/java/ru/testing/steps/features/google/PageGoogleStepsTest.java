package ru.testing.steps.features.google;

import io.cucumber.java.bg.И;
import io.cucumber.java.ru.Пусть;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.util.logging.Level;

public class PageGoogleStepsTest {
    private final PageGoogle pageGoogle = new PageGoogle();

    @Step("Открыть ресурс google")
    @Пусть("открыть ресурс google")
    public void start() {
        pageGoogle.openSite();

    }

    @Step("В поисковой строке ввести значение {text}")
    @И("в поисковой строке ввести значение {word}")
    public void setText(String text) {
        pageGoogle.setText(text);

        Allure.addAttachment("My attachment", text);
    }

    @Step("Нажать на кнопку Поиск в Google")
    @И("нажать на кнопку Поиск в Google")
    public void clickButton() {
        pageGoogle.clickFindGoogle();

    }
}
