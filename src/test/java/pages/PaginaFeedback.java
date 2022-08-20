package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class PaginaFeedback {
    private static final By campoNome = By.cssSelector("#userFeedbackSend");
    private static final By nomeLista = By.cssSelector("#root > section > div > form > div:nth-child(1) > ul > p:nth-child(1)");
    private static final By campoMsg = By.cssSelector("#message");
    private static final By campoTag = By.cssSelector("#tags");
    private static final By checkboxAnonimo = By.cssSelector("#anonymous");
    private static final By btnCriarFeedback = By.cssSelector("#root > section > div > form > button");
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
}
