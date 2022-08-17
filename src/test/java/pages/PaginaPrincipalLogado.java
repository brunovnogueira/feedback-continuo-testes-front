package pages;

import org.openqa.selenium.By;
import util.BaseTest;


public class PaginaPrincipalLogado {
    private static final By nome = By.cssSelector("#root > main > div > div > div.sc-ksZaOG.hjZtJw > h1");
    private static final By email = By.cssSelector("#root > main > div > div > div.sc-ksZaOG.hjZtJw > p:nth-child(4)");

    public String validarNome(){
        return BaseTest.getText(nome);
    }

    public String validarEmail(){
        return BaseTest.getText(email);
    }
}
