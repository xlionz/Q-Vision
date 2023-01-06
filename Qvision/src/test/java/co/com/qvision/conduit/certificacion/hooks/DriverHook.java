package co.com.qvision.conduit.certificacion.hooks;

import co.com.qvision.conduit.certificacion.utils.WebDriverFactory;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

public class DriverHook {

    @Before
    public void prepareStage(){
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(WebDriverFactory.goToWeb())));
    }
}
