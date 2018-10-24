package co.com.newtours.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="resources/features/newtours_register.feature", 
glue="co.com.newtours.stepdefinitions", snippets=SnippetType.CAMELCASE)
public class NewtoursRegisterRunner {

}
