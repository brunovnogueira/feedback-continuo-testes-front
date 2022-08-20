package pages;

import org.openqa.selenium.By;
import util.BaseTest;


public class PaginaPrincipalLogado {
    private static final By nome = By.cssSelector("#id-user-name");
    private static final By email = By.cssSelector("#id-user-email");
    private static final By btnUserIcon = By.cssSelector("#root > header > div > div > button");
    private static final By btnSair = By.cssSelector("#id-button-signout");
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
}
