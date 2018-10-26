package co.com.newtours.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.WebDriver;

import co.com.newtours.exceptions.NoMatchingElement;
import co.com.newtours.exceptions.StartingException;
import co.com.newtours.questions.Page;
import co.com.newtours.questions.Title;
import co.com.newtours.task.OpenTheBrowser;
import co.com.newtours.task.Write;
import co.com.newtours.ui.NewtoursLoginPage;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;

/**
 * @author Santiagoaq95
 *
 */
public class NewtoursLoginStepDefinitions {

	@Managed(driver = "chrome",clearCookies=ClearCookiesPolicy.BeforeEachTest,uniqueSession=true, options="--headless")
	private WebDriver hisDriver;

	Actor lukas = new Actor("Lukas");

	private NewtoursLoginPage newtoursLogin = new NewtoursLoginPage();

	@Before
	public void setUp() {
		
		lukas.can(BrowseTheWeb.with(hisDriver));
		hisDriver.manage().deleteAllCookies();
		hisDriver.manage().window().maximize();
	}

	@Given("^lukas open Login Newtours$")
	public void lukasOpenLoginNewtours() {
		lukas.wasAbleTo(OpenTheBrowser.on(newtoursLogin));
		lukas.should(seeThat(Page.load(), is(equalTo(1))).orComplainWith(StartingException.class, StartingException.MESSAGE_PAGE_UNLOAD));
	}

	@When("^he enter his username and password$")
	public void heEnterHisUsernameAndPassword(DataTable usernameAndPassword) {
		
		lukas.attemptsTo(Write.onFields(usernameAndPassword));
	}

	@When("^he does click on button sign in$")
	public void heDoesClickOnButtonSignIn() {

		lukas.attemptsTo(Click.on(NewtoursLoginPage.LOGIN_BUTTON));
	}

	@Then("^he validate tag \"([^\"]*)\"$")
	public void heValidateTagSINGOFF(String sign) {

		lukas.should(seeThat(Title.singOff(), is(equalTo(sign))).orComplainWith(NoMatchingElement.class,
				NoMatchingElement.getMissingTitleMessage(sign)));
	}

}
