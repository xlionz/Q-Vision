package co.com.qvision.conduit.certificacion.tasks;

import co.com.qvision.conduit.certificacion.models.Article;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Random;

import static co.com.qvision.conduit.certificacion.userinterfaces.ArticlePage.*;
import static co.com.qvision.conduit.certificacion.userinterfaces.HomePage.BTN_NEW_ARTICLE;

@AllArgsConstructor
public class CreateArticle implements Task {

    private Article article;

    public static CreateArticle inConduit(Article article){
        return Tasks.instrumented(CreateArticle.class, article);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        article.setTitleArticle(article.getTitleArticle() + new Random().nextInt(999));

        actor.attemptsTo(
                Click.on(BTN_NEW_ARTICLE),
                Enter.theValue(article.getTitleArticle()).into(INPUT_TITLE),
                Enter.theValue(article.getAboutArticle()).into(INPUT_ABOUT_ARTICLE),
                Enter.theValue(article.getArticleDescription()).into(TXT_DESCRIPTION_ARTICLE),
                Click.on(BTN_PUBLISH_ARTICLE)
        );

        actor.remember("TITLE_ARTICLE", article.getTitleArticle());
    }
}
