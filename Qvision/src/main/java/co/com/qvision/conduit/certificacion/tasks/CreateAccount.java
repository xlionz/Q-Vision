package co.com.qvision.conduit.certificacion.tasks;

import co.com.qvision.conduit.certificacion.models.Account;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import java.util.Random;

import static co.com.qvision.conduit.certificacion.userinterfaces.HomePage.*;

@AllArgsConstructor
public class CreateAccount implements Task {

    private Account account;

    public static CreateAccount onConduit(Account account){
        return Tasks.instrumented(CreateAccount.class, account);
    }

    @Step("Users in on the web to create account")
    @Override
    public <T extends Actor> void performAs(T actor) {
        account.setUserName(new Random().nextInt(500) + account.getUserName());
        account.setEmail(new Random().nextInt(500) + account.getEmail());

        actor.attemptsTo(
                Click.on(BTN_SIGN_UP),
                Enter.theValue(account.getUserName()).into(INPUT_USERNAME),
                Enter.theValue(account.getEmail()).into(INPUT_EMAIL),
                Enter.theValue(account.getPassword()).into(INPUT_PASSWORD),
                Click.on(BTN_CREATE_ACCOUNT)
        );

        actor.remember("NAME", account.getUserName());

    }
}
