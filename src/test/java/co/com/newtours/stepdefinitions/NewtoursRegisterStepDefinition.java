package co.com.newtours.stepdefinitions;

import static org.hamcrest.Matchers.containsString;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.WebDriver;

import co.com.newtours.questions.Page;
import co.com.newtours.questions.TheMessage;
import co.com.newtours.task.OpenTheBrowser;
import co.com.newtours.task.Register;
import co.com.newtours.exceptions.StartingException;
import co.com.newtours.ui.NewtoursRegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class NewtoursRegisterStepDefinition {

	@Managed(driver = "chrome")
	private WebDriver hisDriver;
	Actor lukas = new Actor("Lukas");
	private NewtoursRegisterPage newtoursRegister = new NewtoursRegisterPage();

	@Before
	public void setUp() {
		lukas.can(BrowseTheWeb.with(hisDriver));

	}

	@Given("^Lukas opens the Newtours register page$")
	public void lukasOpensTheNewtoursRegisterPage() {
		lukas.wasAbleTo(OpenTheBrowser.on(newtoursRegister));
		lukas.should(seeThat(Page.load(), is(equalTo(1))).orComplainWith(StartingException.class, StartingException.MESSAGE_PAGE_UNLOAD));
	}

	@When("^he enters the contact information$")
	public void heEntersTheContactInformation(DataTable information) {
		lukas.attemptsTo(Register.theContact(information));
	}

	@When("^he enters the mailing information$")
	public void heEntersTheMailingInformation(DataTable information) {
		lukas.attemptsTo(Register.theMailing(information));
	}

	@When("^he enters the user information$")
	public void heEntersTheUserInformation(DataTable information) {
		lukas.attemptsTo(Register.theUser(information));
	}

	@Then("^he sees the message Note: Your user name is \"([^\"]*)\"$")
	public void heSeesTheMessageNoteYourUserNameIs(String username) {
		lukas.should(seeThat(TheMessage.ofUsername(), containsString(username)));
	}

}
