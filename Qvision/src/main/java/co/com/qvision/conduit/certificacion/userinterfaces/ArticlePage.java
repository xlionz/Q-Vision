package co.com.qvision.conduit.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ArticlePage {
    public static final Target INPUT_TITLE = Target.the("Input title of article.")
            .locatedBy("//input[@formcontrolname= 'title']");
    public static final Target INPUT_ABOUT_ARTICLE = Target.the("Input of about your article.")
            .locatedBy("//input[@formcontrolname= 'description']");
    public static final Target TXT_DESCRIPTION_ARTICLE = Target.the("Text area of description article.")
            .locatedBy("//textarea[@formcontrolname= 'body']");
    public static final Target BTN_PUBLISH_ARTICLE = Target.the("Button to publish article.")
            .locatedBy("//button[contains(text(), 'Publish Article')]");
    public static final Target H1_TITLE_ARTICLE = Target.the("H1 of article title.")
            .locatedBy("//h1[text() = '{0}']");
}
