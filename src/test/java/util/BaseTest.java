package util;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Elements{
    //Método de clicar
    public static void click(By by){
        waitElementClickable(by);
        element(by).click();
    }
    //Método de pegar texto na tela
    public static String getText(By by){
        waitElementVisibility(by);
        return element(by).getText();
    }
    //Método de escrever em campo
    public static void sendKeys(By by,String texto){
        waitElement(by);
        element(by).sendKeys(texto);
    }

    public static void clear(By by){
        waitElement(by);
        element(by).clear();
    }

    public static void selecionarLista(By by,String value){
        waitElement(by);
        Select objSelect = new Select(driver.findElement(by));
        objSelect.selectByValue(value);
    }

    public static void hover(By by){
        waitElement(by);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(by)).perform();
    }
}
