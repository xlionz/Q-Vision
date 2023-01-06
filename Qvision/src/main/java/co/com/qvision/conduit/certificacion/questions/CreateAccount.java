package co.com.qvision.conduit.certificacion.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import static co.com.qvision.conduit.certificacion.userinterfaces.HomePage.LBL_USERNAME;

@AllArgsConstructor
public class CreateAccount implements Question<Boolean> {

    public static CreateAccount isDone(){
        return new CreateAccount();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String name = actor.recall("NAME");
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos((long) 1 * 1000));

        return LBL_USERNAME.of(name).resolveFor(actor).getText().equals(name);
    }
}
