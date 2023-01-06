package co.com.qvision.conduit.certificacion.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import static co.com.qvision.conduit.certificacion.userinterfaces.ArticlePage.H1_TITLE_ARTICLE;

@AllArgsConstructor
public class TheArticle implements Question<Boolean> {

    public static TheArticle isCreated(){
        return new TheArticle();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String titleArticle = actor.recall("TITLE_ARTICLE");
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos((long) 2 * 1000));

        return H1_TITLE_ARTICLE.of(titleArticle).resolveFor(actor).getText().equals(titleArticle);
    }
}
