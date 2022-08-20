package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class PaginaColaboradores {
    private static final By campoPesquisaNome = By.cssSelector("#root > section > div > input");
    private static final By usuarioPesquisado = By.cssSelector("#root > section > div > ul > li:nth-child(1)");
    private static final By usuarioPesquisadoNome = By.cssSelector("#root > section > div > ul > li:nth-child(1) > div > h4");

    public void preencherCampoPesquisa(String nome){
        BaseTest.sendKeys(campoPesquisaNome,nome);
    }

    public String validarNomePesquisado(){
        return BaseTest.getText(usuarioPesquisadoNome);
    }

    public void clicarUsuarioPesquisado(){
        BaseTest.click(usuarioPesquisado);
    }
}
