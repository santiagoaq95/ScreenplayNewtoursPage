package co.com.newtours.task;

import static org.hamcrest.Matchers.containsString;

import co.com.newtours.models.Persona;
import co.com.newtours.questions.Country;
import co.com.newtours.ui.NewtoursRegisterPage;
import co.com.newtours.utils.RegisterInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class RegisterMailing implements Task{

	private RegisterInformation register = new RegisterInformation();
	
	public RegisterMailing(String address1, String address2, String city, String state,
			String postalCode, String country) {
		register.RegisterMaillingInformation(address1, address2, city, state, postalCode, country);
	}
	@Override
	@Step("{0} Click on Button sign in ")
	public <T extends Actor> void performAs(T actor) {
		Persona persona = register.getPersona();
		actor.attemptsTo(Enter.theValue(persona.getAddress1()).into(NewtoursRegisterPage.REGISTER_ADDRESS1));
		actor.attemptsTo(Enter.theValue(persona.getAddress2()).into(NewtoursRegisterPage.REGISTER_ADDRESS2));
		actor.attemptsTo(Enter.theValue(persona.getCity()).into(NewtoursRegisterPage.REGISTER_CITY));
		actor.attemptsTo(Enter.theValue(persona.getState()).into(NewtoursRegisterPage.REGISTER_STATE));
		actor.attemptsTo(Enter.theValue(persona.getPostalCode()).into(NewtoursRegisterPage.REGISTER_POSTAL_CODE));
		actor.attemptsTo(SelectFromOptions.byVisibleText(persona.getCountry().toUpperCase()).from(NewtoursRegisterPage.REGISTER_COUNTRY));
		actor.should(GivenWhenThen.seeThat(Country.name(), containsString(persona.getCountry().toUpperCase())));
		
	}


}
