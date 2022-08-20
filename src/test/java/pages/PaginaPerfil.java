package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class PaginaPerfil {
    private static final By msgFeedback = By.xpath("/html/body/div[1]/section/div/div/section/ul/li[1]/div[2]/p");
    private static final By nomeFeedback = By.xpath("/html/body/div[1]/section/div/div/section/ul/li[1]/div[1]/h4");

    public String validarNome(){
        return BaseTest.getText(nomeFeedback);
    }

    public String validarMsg(){
        return BaseTest.getText(msgFeedback);
    }
}
