package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class PaginaFeedback {
    private static final By campoNome = By.cssSelector("#userFeedbackSend");
    private static final By nomeLista = By.cssSelector("#root > section > div > form > div:nth-child(1) > ul > li");
    private static final By campoMsg = By.cssSelector("#message");
    private static final By campoTag = By.cssSelector("#tags");
    private static final By tagLista = By.xpath("/html/body/div[1]/section/div/form/div[3]/ul[1]/li[1]");
    private static final By checkboxAnonimo = By.cssSelector("#anonymous");
    private static final By btnCriarFeedback = By.cssSelector("#root > section > div > form > button");
    private static final By msgAtencaoNome = By.cssSelector("#id-message-collaborator");
    private static final By msgAtencaoFeed = By.cssSelector("#id-message-feedback");
    private static final By toastUsuarioInexistente = By.xpath("/html/body/div[1]/div/div/div/div[2]");

    public void preencherNome(String nome){
        BaseTest.sendKeys(campoNome,nome);
    }

    public void preencherMsg(String msg){
        BaseTest.sendKeys(campoMsg,msg);
    }

    public void preencherTag(String tag){
        BaseTest.sendKeys(campoTag,tag);
    }

    public void clicarAnonimo(){
        BaseTest.click(checkboxAnonimo);
    }

    public void clicarBtnCriarFeedback(){
        BaseTest.click(btnCriarFeedback);
    }

    public void clicarNomeLista(){
        BaseTest.click(nomeLista);
    }

    public void clicarTagLista(){
        BaseTest.click(tagLista);
    }

    public String validarMsgAtencaoNome(){
        return BaseTest.getText(msgAtencaoNome);
    }

    public String validarMsgAtencaoFeed(){
        return BaseTest.getText(msgAtencaoFeed);
    }

    public void clicarCampoMsg(){
        BaseTest.click(campoMsg);
    }

    public String validarToastUsuarioInexistente(){
        BaseTest.esperar(toastUsuarioInexistente,"Usuário não encontrado");
        return BaseTest.getText(toastUsuarioInexistente);
    }
}
