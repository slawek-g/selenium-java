package Runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"classpath:Features/Site.feature"},
        glue = {"org.selenium.StepDefinitions"},
        plugin = { "pretty", "json:target/cucumber.json",
                "html:target/cucumber-reports.html"}
)
public class MySerenityTestRunner {

}

