package co.com.qvision.conduit.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target BTN_SIGN_UP = Target.the("Button to sign up.")
            .locatedBy("//a[contains(text(), 'Sign up')]");
    public static final Target BTN_SIGN_IN = Target.the("Button to sign in.")
            .locatedBy("//a[contains(text(), 'Sign in')]");
    public static final Target INPUT_USERNAME = Target.the("Input of username.")
            .locatedBy("//input[@placeholder = 'Username']");
    public static final Target INPUT_EMAIL = Target.the("Input of email.")
            .locatedBy("//input[@placeholder = 'Email']");
    public static final Target INPUT_PASSWORD = Target.the("Input of password.")
            .locatedBy("//input[@placeholder = 'Password']");
    public static final Target BTN_CREATE_ACCOUNT = Target.the("Button to sign up.")
            .locatedBy("//button[contains(text(), 'Sign up')]");
    public static final Target LBL_USERNAME = Target.the("Label of username.")
            .locatedBy("//a[@href = '/profile/{0}']");
    public static final Target BTN_LOGIN = Target.the("Button to login")
            .locatedBy("//button[contains(text(), 'Sign in')]");
    public static final Target BTN_NEW_ARTICLE = Target.the("Button to create a new article.")
            .locatedBy("//a[@href = '/editor']");
}
