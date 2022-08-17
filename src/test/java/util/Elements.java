package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Elements extends Browser{
    protected static WebElement element(By by){
        return driver.findElement(by);
    }

    //Para validar a presença
    protected static void waitElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    //Para clicar
    protected static void waitElementClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //Para extrair um atributo
    protected static void waitElementVisibility(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
