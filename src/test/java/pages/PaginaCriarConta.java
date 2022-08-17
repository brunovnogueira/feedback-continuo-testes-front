package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class PaginaCriarConta {
    private static final By campoNome = By.cssSelector("#name");
    private static final By campoEmail = By.cssSelector("#email");
    private static final By campoSenha = By.cssSelector("#password");
    private static final By campoConfirmarSenha = By.cssSelector("#confirmPassword");
    private static final By listaCargo = By.cssSelector("#role");
    private static final By btnAdicionarImagem = By.cssSelector("#avatar");
    private static final By btnCriarConta = By.cssSelector("#root > div.sc-gsnTZi.jVyDQX > section.sc-hKMtZM.fDWqpn > div > form > button");
    private static final By msgNomeAtencao = By.cssSelector("#root > div.sc-gsnTZi.jVyDQX > section.sc-hKMtZM.fDWqpn > div > form > div:nth-child(1) > div > span");
    private static final By msgEmailAtencao = By.cssSelector("#root > div.sc-gsnTZi.jVyDQX > section.sc-hKMtZM.fDWqpn > div > form > div:nth-child(2) > div > span");
    private static final By msgSenhaAtencao = By.cssSelector("#root > div.sc-gsnTZi.jVyDQX > section.sc-hKMtZM.fDWqpn > div > form > div:nth-child(3) > div > span");
    private static final By msgConfirmacaoSenhaAtencao = By.cssSelector("#root > div.sc-gsnTZi.jVyDQX > section.sc-hKMtZM.fDWqpn > div > form > div:nth-child(4) > div > span");
    private static final By msgSenhasIguais = By.cssSelector("#root > div.sc-gsnTZi.jVyDQX > section.sc-hKMtZM.fDWqpn > div > form > div:nth-child(4) > div > span");
    public void preencherNome(String nome){
        BaseTest.sendKeys(campoNome,nome);
    }

    public void preencherEmail(String email){
        BaseTest.sendKeys(campoEmail,email);
    }

    public void preencherSenha(String senha){
        BaseTest.sendKeys(campoSenha,senha);
    }

    public void preencherConfirmarSenha(String senha){
        BaseTest.sendKeys(campoConfirmarSenha,senha);
    }

    public void selecionarCargo(String cargo){
        BaseTest.selecionarLista(listaCargo,cargo);
    }

    public void adicionarImagem(){

        BaseTest.sendKeys(btnAdicionarImagem,"C:\\Users\\bruno\\OneDrive\\Imagens\\images.png");
    }

    public void clicarBtnCriarConta(){
        BaseTest.click(btnCriarConta);
    }

    public String validarMsgNome(){
        return BaseTest.getText(msgNomeAtencao);
    }

    public String validarMsgEmail(){
        return BaseTest.getText(msgEmailAtencao);
    }

    public String validarMsgSenha(){
        return BaseTest.getText(msgSenhaAtencao);
    }

    public String validarMsgConfirmacaoSenha(){
        return BaseTest.getText(msgConfirmacaoSenhaAtencao);
    }

    public String validarMsgSenhasIguais(){
        return BaseTest.getText(msgSenhasIguais);
    }
}
