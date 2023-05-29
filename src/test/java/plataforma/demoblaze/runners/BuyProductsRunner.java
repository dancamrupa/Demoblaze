package plataforma.demoblaze.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/BuyProduct.feature",
        glue = "plataforma.demoblaze.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class BuyProductsRunner {
}
