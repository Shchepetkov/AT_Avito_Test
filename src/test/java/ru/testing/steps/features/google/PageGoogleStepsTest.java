package ru.testing.steps.features.google;

import io.cucumber.java.bg.И;
import io.cucumber.java.ru.Пусть;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class PageGoogleStepsTest {
    private final PageGoogle pageGoogle = new PageGoogle();

    @Step("Открыть ресурс google")
    @Пусть("открыть ресурс google")
    public void start() {
        pageGoogle.openSite();
        LOGGER.log(Level.INFO, "Открыт ресурс google");
    }

    @Step("В поисковой строке ввести значение {text}")
    @И("в поисковой строке ввести значение {word}")
    public void setText(String text) {
        pageGoogle.setText(text);
        LOGGER.log(Level.INFO, String.format("В поисковой строке введено значение %s", text));
        Allure.addAttachment("My attachment", text);
    }

    @Step("Нажать на кнопку Поиск в Google")
    @И("нажать на кнопку Поиск в Google")
    public void clickButton() {
        pageGoogle.clickFindGoogle();
        LOGGER.log(Level.INFO, "Была нажата кнопка \"Поиск в Google\"");
    }
}
