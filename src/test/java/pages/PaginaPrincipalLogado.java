package pages;

import org.openqa.selenium.By;
import util.BaseTest;


public class PaginaPrincipalLogado {
    private static final By nome = By.xpath("/html/body/div/main/div/section/div[1]/h2");
    private static final By email = By.xpath("/html/body/div/main/div/section/div[1]/small");
    private static final By btnUserIcon = By.xpath("/html/body/div/header/div/div/button");
    private static final By btnSair = By.xpath("/html/body/div/header/div/div/button[1]");
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
