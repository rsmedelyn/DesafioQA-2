package br.com.decolarqa.cucumber.pages;

import br.com.decolarqa.cucumber.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static br.com.decolarqa.cucumber.core.DriverFactory.getDriver;

public class DeeplPage extends BasePage {


    public void fecharNotificacao(){
        clicarBotao(By.cssSelector("button[aria-label=Fechar"));

    }

    public void escolherIdiomaDoTexto(){
        clicarBotaoPorDataTestId("translator-source-lang-btn");
    }

    public void escolherIdiomaParaTraduzir(){
        clicarBotaoPorDataTestId("translator-target-lang-btn");
    }

    public void escolherOpcaoTextoPortugues(){
        escolherIdiomaDoTexto();
        clicarBotaoPorDataTestId("translator-lang-option-ppt");
    }

    public void pesquisarIdiomaParaTraduzir(String idioma){
        escolherIdiomaParaTraduzir();
        escreverCampo(By.cssSelector("input[placeholder='Pesquisar idioma']"), idioma);
        escolherIdiomaPesquisado(idioma);
    }

    public void escolherIdiomaPesquisado(String idioma){
        WebElement elemento = getDriver().findElement(By.xpath("//button[.='"+idioma+"']"));
        executarJS("arguments[0].click()", elemento);
    }

    public void inserirTexto(String texto){
        escreverTextAreaDataTestId("translator-source-input", texto);
    }

    public void aguardarLoading(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[data-testid=loading-indicator]")));
    }

    public String obterTextoTraduzido(){
        return obterTextoDataTest("translator-target-input");
    }
}
