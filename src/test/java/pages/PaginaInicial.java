package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class PaginaInicial {

    private static final By campoEmail = By.cssSelector("#login");
    private static final By campoSenha = By.cssSelector("#senha");
    private static final By btnEntrar = By.cssSelector("#root > div.sc-gsnTZi.jVyDQX > section.sc-hKMtZM.fDWqpn > div > form > button");
    private static final By btnCriar = By.cssSelector("#root > div.sc-gsnTZi.jVyDQX > section.sc-hKMtZM.fDWqpn > div > a:nth-child(4) > span");
    private static final By msgEmailAtencao = By.xpath("//*[@id=\"root\"]/div[2]/section[2]/div/form/div[1]/div/span");
    private static final By msgSenhaAtencao = By.xpath("//*[@id=\"root\"]/div[2]/section[2]/div/form/div[2]/div/span");
    private static final By toastErroLogin = By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[2]");

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

    public String validarMsgEmail(){
        return BaseTest.getText(msgEmailAtencao);
    }

    public String validarMsgSenha(){
        return BaseTest.getText(msgSenhaAtencao);
    }

    public String validarToastErroLogin(){
        BaseTest.esperar(toastErroLogin,"Erro de login. Email ou senha invalido.");
        return BaseTest.getText(toastErroLogin);
    }
}
