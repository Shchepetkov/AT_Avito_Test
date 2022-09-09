package ru.testing.steps.locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class GoogleElements {
    @FindBy(xpath = "//form[@action = '/search']//input[@type = 'text']")
    public SelenideElement textArea;

    @FindBy(xpath = "//form[@action = '/search']//div[@jsname = 'VlcLAe']//input[@role= 'button' and @value =  'Поиск в Google' and @aria-label = 'Поиск в Google']")
    public SelenideElement findForGoogleButton;
}
