package pages;

import org.openqa.selenium.By;
import util.BaseTest;


public class PaginaPrincipalLogado {
    private static final By nome = By.cssSelector("#id-user-name");
    private static final By email = By.cssSelector("#id-user-email");
    private static final By btnUserIcon = By.cssSelector("#root > header > div > div > button");
    private static final By btnSair = By.cssSelector("#id-button-signout");
    private static final By btnEnviarFeedback = By.cssSelector("#root > header > div > nav > ul > li:nth-child(2) > a");
    private static final By nomeUltimoFeed = By.xpath("/html/body/div/main/div/div/section/ul/li/div[1]/div/h4");
    private static final By msgUltimoFeed = By.xpath("/html/body/div[1]/main/div/div/section/ul/li/div[2]/p");
    public String validarNome(){
        return BaseTest.getText(nome);
    }
    public String validarEmail(){
        return BaseTest.getText(email);
    }
    public void clicarUserIcon(){
        BaseTest.click(btnUserIcon);
    }
    public void clicarSair(){
        BaseTest.click(btnSair);
    }
    public void clicarEnviarFeedback(){
        BaseTest.click(btnEnviarFeedback);
    }
    public String validarNomeFeed(){
        return BaseTest.getText(nomeUltimoFeed);
    }
    public String validarMsgFeed(){
        return BaseTest.getText(msgUltimoFeed);
    }
}
