package co.com.qvision.conduit.certificacion.tasks;

import co.com.qvision.conduit.certificacion.models.Account;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.qvision.conduit.certificacion.userinterfaces.HomePage.*;

@AllArgsConstructor
public class Login implements Task {

    private Account account;

    public static Login conduit(Account account){
        return Tasks.instrumented(Login.class, account);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_SIGN_IN),
                Enter.theValue(account.getEmail()).into(INPUT_EMAIL),
                Enter.theValue(account.getPassword()).into(INPUT_PASSWORD),
                Click.on(BTN_LOGIN)
        );

        actor.remember("NAME", account.getUserName());
    }
}
