package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class PaginaInicial {

    private static final By campoEmail = By.cssSelector("#login");
    private static final By campoSenha = By.cssSelector("#senha");
    private static final By btnEntrar = By.cssSelector("#id-button-login");
    private static final By btnCriar = By.cssSelector("#id-navigate-for-create > span");
    private static final By msgEmailAtencao = By.xpath("/html/body/div[1]/div[2]/section[2]/div/form/div[1]/div/span");
    private static final By msgSenhaAtencao = By.xpath("/html/body/div[1]/div[2]/section[2]/div/form/div[2]/div/span");
    private static final By toastErroLogin = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]");

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
