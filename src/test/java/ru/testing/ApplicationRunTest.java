package ru.testing;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@SuppressWarnings("unused")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "ru.testing.steps",
        tags = "@avito or @google"
//        ,dryRun = true
)
public class ApplicationRunTest {
    @org.junit.Test
    public static void run(String[] args) {
    }
}
