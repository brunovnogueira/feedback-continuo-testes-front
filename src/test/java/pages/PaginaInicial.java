package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class PaginaInicial {

    private static final By campoEmail = By.cssSelector("#login");
    private static final By campoSenha = By.cssSelector("#senha");
    private static final By btnEntrar = By.cssSelector("#root > div.sc-gsnTZi.jVyDQX > section.sc-hKMtZM.fDWqpn > div > form > button");
    private static final By btnCriar = By.cssSelector("#root > div.sc-gsnTZi.jVyDQX > section.sc-hKMtZM.fDWqpn > div > a:nth-child(4) > span");

    public void preencherEmail(String email){
        BaseTest.sendKeys(campoEmail,email);
    }

    public void preencherSenha(String senha){
        BaseTest.sendKeys(campoSenha,senha);
    }

    public void clicarBtnEntrar(){
        BaseTest.click(btnEntrar);
    }

    public void clicarBtnCriar(){
        BaseTest.click(btnCriar);
    }
}
