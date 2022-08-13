package starter.testRunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "starter.stepDefinitions",
        tags = "@smoke or @regression"
)
public class CucumberRunner {}
