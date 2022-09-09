package ru.testing.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import javafx.application.Application;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.testing.ApplicationRunTest;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.webdriver;

public class hook {

    /**
     * {@code System.setProperty} Для локального запуска через драйвер,
     * все что ниже для запуска в selenoid.
     * Также локально можно запускать и без драйвера используя зависимость в pom webDriverManager
     */
    @Before
    public void before() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
//        Configuration.browser = "chrome";
//        Configuration.remote = "http://localhost:4444/wd/hub";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        Configuration.browserCapabilities = capabilities;
    }

    @After
    public void closeDriver(Scenario scenario) {
        System.out.println(scenario.getId());
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        System.out.println(scenario.isFailed());
        System.out.println(scenario.getSourceTagNames());
        if (webdriver().driver() != null) {
            webdriver().driver().close();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    @SuppressWarnings("all")
    public byte[] takeScreenshot(WebDriver driver) {
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            ImageIO.write(screenshot.getImage(), "PNG", buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }

    @AfterStep
    @SuppressWarnings("unused")
    public void after() {
        takeScreenshot(webdriver().driver().getWebDriver());
    }
}
