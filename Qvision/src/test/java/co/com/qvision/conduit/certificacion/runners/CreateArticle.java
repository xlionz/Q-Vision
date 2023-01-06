package co.com.qvision.conduit.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/create_article.feature",
        glue = {"co.com.qvision.conduit.certificacion.stepdefinitions",
                "co.com.qvision.conduit.certificacion.hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CreateArticle {
}
