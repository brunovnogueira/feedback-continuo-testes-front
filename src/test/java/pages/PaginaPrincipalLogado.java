package pages;

import org.openqa.selenium.By;
import util.BaseTest;


public class PaginaPrincipalLogado {
    private static final By nome = By.cssSelector("#root > main > div > div > div.sc-ksZaOG.hjZtJw > h1");
    private static final By email = By.cssSelector("#root > main > div > div > div.sc-ksZaOG.hjZtJw > p:nth-child(4)");
    private static final By btnUserIcon = By.cssSelector("#root > header > div > div > button > img");
    private static final By btnSair = By.cssSelector("#root > header > div > div > button.sc-eCYdqJ.iecHYK");
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
