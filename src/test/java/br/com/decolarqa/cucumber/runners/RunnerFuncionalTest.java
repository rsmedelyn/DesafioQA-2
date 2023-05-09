package br.com.decolarqa.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/tradutor_textos.feature",
        glue = "br.com.decolarqa.cucumber.steps",
        publish = true,
        plugin = {"pretty", "html:target/report.html", "json:target/report.json"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
)
public class RunnerFuncionalTest {

}