package ru.testing.steps.features.google;

import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;
import ru.testing.steps.PageAbstract;
import ru.testing.steps.locators.GoogleElements;

import static com.codeborne.selenide.Selenide.*;

public class PageGoogle extends PageAbstract {
    private final GoogleElements googleElements = page(GoogleElements.class);

    @DisplayName("В поисковой строке ввести значение")
    public void setText(String text) {
        googleElements.textArea.click();
        googleElements.textArea.sendKeys(text);
    }

    @DisplayName("Нажать на кнопку Поиск в Google")
    public void clickFindGoogle() {
        googleElements.findForGoogleButton.click();
    }

    @DisplayName("Нажать на кнопку Поиск в Google")
    public void clickSite() {
        $$(By.xpath("//*[contains(text(),'Авито')]")).first().click();
    }

    @Override
    public void openSite() {
        open("https://www.google.com/");
        webdriver().object().manage().window().maximize();
    }
}
