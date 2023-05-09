package br.com.decolarqa.cucumber.steps;

import br.com.decolarqa.cucumber.pages.DeeplPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static br.com.decolarqa.cucumber.core.DriverFactory.getDriver;
import static br.com.decolarqa.cucumber.core.DriverFactory.killDriver;

public class TradutorTextosSteps {

    private DeeplPage page;
    private String txtPortugues;
    public String txtEspanhol;

    @Dado("que o usuario acessa a pagina inicial do Deepl Translator")
    public void queOUsuarioAcessaAPaginaInicialDoDeeplTranslator() {
        getDriver().get("https://www.deepl.com/translator");
        page = new DeeplPage();
    }

    @Dado("que usuario possui um texto em idioma portugues")
    public void queUsuarioPossuiUmTextoEmIdiomaPortugues() {
        txtPortugues = "O teste automatizado vem sendo utilizado cada vez mais para aumentar a qualidade e confiabilidade no desenvolvimento de software.";
        page.fecharNotificacao();
        page.escolherOpcaoTextoPortugues();
    }

    @Dado("que usuario possui o texto {string} em idioma portugues")
    public void que_usuario_possui_o_texto_em_idioma_portugues(String string) {
        txtPortugues = string;
        page.fecharNotificacao();
        page.escolherOpcaoTextoPortugues();
    }


    @Quando("ele solicita a traducao do texto para o idioma em espanhol")
    public void eleSolicitaATraducaoDoTextoParaOIdiomaEmEspanhol() {
        page.pesquisarIdiomaParaTraduzir("espanhol");
        page.inserirTexto(txtPortugues);
    }
    @Quando("ele solicita a traducao do texto para o idioma em {string}")
    public void ele_solicita_a_traducao_do_texto_para_o_idioma_em(String string) {
        page.pesquisarIdiomaParaTraduzir(string);
        page.inserirTexto(txtPortugues);
    }

    @Entao("o sistema deve exibir a traducao do texto corretamente")
    public void OSistemaDeveExibirATraducaoDoTextoCorretamente() {
        page.aguardarLoading();
        txtEspanhol = "Las pruebas automatizadas se utilizan cada vez más para aumentar la calidad y fiabilidad del desarrollo de software.";
        Assert.assertEquals(txtEspanhol, page.obterTextoTraduzido());
    }

    @Entao("o sistema deve exibir o texto traduzido {string} corretamente")
    public void o_sistema_deve_exibir_o_texto_traduzido_corretamente(String string) {
        page.aguardarLoading();
        Assert.assertEquals(string, page.obterTextoTraduzido());
    }

    @After(order = 1, value = "@funcionais")
    public void screenshot(Scenario cenario) {
        File file = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After(order = 0, value = "@funcionais")
    public void fecharBrowser() { killDriver();}
}
