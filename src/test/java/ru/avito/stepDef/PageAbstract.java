package ru.avito.stepDef;

public abstract class PageAbstract {

    public PageAbstract() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
    }
}
