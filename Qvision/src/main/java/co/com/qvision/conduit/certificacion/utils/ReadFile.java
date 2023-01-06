package co.com.qvision.conduit.certificacion.utils;

import co.com.qvision.conduit.certificacion.models.Account;
import co.com.qvision.conduit.certificacion.models.Article;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class ReadFile {

    private static final EnvironmentVariables CONF = SystemEnvironmentVariables.createEnvironmentVariables();
    public static final String CONFIG_ACCOUNT = "accounts.";
    public static final String CONFIG_ARTICLE = "articles.";

    public static Account readAccount(String account){
        return new Account(CONF.getProperty(CONFIG_ACCOUNT + account + ".username"),
                CONF.getProperty(CONFIG_ACCOUNT + account + ".email"),
                CONF.getProperty(CONFIG_ACCOUNT + account + ".password"));
    }

    public static Article readArticle(String article){
        return new Article(CONF.getProperty(CONFIG_ARTICLE + article + ".articletitle"),
                CONF.getProperty(CONFIG_ARTICLE + article + ".aboutarticle"),
                CONF.getProperty(CONFIG_ARTICLE + article + ".articledescription"));
    }
}
