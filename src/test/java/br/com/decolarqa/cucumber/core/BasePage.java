package br.com.decolarqa.cucumber.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static br.com.decolarqa.cucumber.core.DriverFactory.getDriver;

public class BasePage {

    /****************** Botao ******************/

    public void clicarBotao(By by) {
        getDriver().findElement(by).click();
    }
    public void clicarBotaoId(String id) {
        clicarBotao(By.id(id));
    }

    public void clicarBotaoPorTexto(String texto){
        clicarBotao(By.xpath("//button[.='"+texto+"']"));
    }

    public void clicarBotaoPorDataTestId(String dataTestId){
        clicarBotao(By.cssSelector("button[data-testid='"+dataTestId+"']"));
    }

    /********* TextField e TextArea ************/

    public void escreverCampo(By by, String texto){
        getDriver().findElement(by).sendKeys(texto);
    }

    public void escreverTextAreaDataTestId(String dataTestId, String texto){
        escreverCampo(By.cssSelector("d-textarea[data-testid='"+dataTestId+"']"), texto);
    }

    public String obterTextoDataTest( String dataTestId){
        return getDriver().findElement(By.cssSelector("d-textarea[data-testid='"+dataTestId+"']")).getText();
    }

    /****************** JS *********************/

    public Object executarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

}
