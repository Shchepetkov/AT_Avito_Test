package ru.testing;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("unused")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "ru.testing.steps",
        tags = "@avito"
//        ,dryRun = true
)
public class ApplicationRunTest {
    @Test
    public static void run(String[] args) {
    }
}
