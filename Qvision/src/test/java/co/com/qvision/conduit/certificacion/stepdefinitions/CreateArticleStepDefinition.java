package co.com.qvision.conduit.certificacion.stepdefinitions;

import co.com.qvision.conduit.certificacion.exceptions.ExceptionError;
import co.com.qvision.conduit.certificacion.questions.TheArticle;
import co.com.qvision.conduit.certificacion.tasks.CreateAccount;
import co.com.qvision.conduit.certificacion.tasks.CreateArticle;
import co.com.qvision.conduit.certificacion.tasks.Login;
import co.com.qvision.conduit.certificacion.utils.ReadFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.qvision.conduit.certificacion.utils.Constants.URL_CONDUIT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateArticleStepDefinition {

    @Given("{string} is on the web")
    public void isOnTheWeb(String user) {
        theActorCalled(user).wasAbleTo(Open.url(URL_CONDUIT));
    }
    @When("{string} creates account")
    public void createsAccount(String account) {
        theActorInTheSpotlight().attemptsTo(
                CreateAccount.onConduit(ReadFile.readAccount(account))
        );
    }
    @Then("shoulds see a msg on the page")
    public void shouldsSeeAMsgOnThePage() {
        theActorInTheSpotlight().should(seeThat(co.com.qvision.conduit.certificacion.questions.CreateAccount.isDone())
                .orComplainWith(ExceptionError.class));
    }

    @When("{string} logs on conduit")
    public void logs(String account) {
        theActorInTheSpotlight().attemptsTo(
                Login.conduit(ReadFile.readAccount(account))
        );
    }

    @When("{string} is created")
    public void isCreated(String article) {
        theActorInTheSpotlight().attemptsTo(
                CreateArticle.inConduit(ReadFile.readArticle(article))
        );
    }

    @Then("shoulds see the article on the page")
    public void shouldsSeeTheArticleOnThePage() {
        theActorInTheSpotlight().should(seeThat(TheArticle.isCreated()).orComplainWith(ExceptionError.class));
    }
}
