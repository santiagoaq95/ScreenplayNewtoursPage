package co.com.newtours.task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;
import java.util.Map;

import co.com.newtours.models.Persona;
import co.com.newtours.ui.NewtoursRegisterPage;
import co.com.newtours.utils.RegisterInformation;
import cucumber.api.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class Register implements Task {

	private RegisterInformation register = new RegisterInformation();

	public Register(String first, String last, String number, String email) {
		register.RegisterContactInformation(first, last, number, email);
	}



	@Override
	public <T extends Actor> void performAs(T actor) {
		Persona persona = register.getPersona();
		actor.attemptsTo(Enter.theValue(persona.getFirstName()).into(NewtoursRegisterPage.REGISTER_FIRSTNAME));
		actor.attemptsTo(Enter.theValue(persona.getLastName()).into(NewtoursRegisterPage.REGISTER_LASTNAME));
		actor.attemptsTo(Enter.theValue(persona.getPhone()).into(NewtoursRegisterPage.REGISTER_PHONE));
		actor.attemptsTo(Enter.theValue(persona.getEmail()).into(NewtoursRegisterPage.REGISTER_EMAIL));

	}

	public static Register theContact(DataTable information) {
		List<Map<String, String>> params = information.asMaps(String.class, String.class);
		String firstName = params.get(0).get("firstName");
		String lastName = params.get(0).get("lastName");
		String phone = params.get(0).get("phone");
		String email = params.get(0).get("email");

		return instrumented(Register.class, firstName, lastName, phone, email);
	}

	public static Performable theMailing(DataTable information) {
		List<Map<String, String>> params = information.asMaps(String.class, String.class);
		String address1 = params.get(0).get("address1");
		String address2 = params.get(0).get("address2");
		String city = params.get(0).get("city");
		String state = params.get(0).get("state");
		String postalCode = params.get(0).get("postalCode");
		String country = params.get(0).get("country");
		return instrumented(RegisterMailing.class, address1, address2, city, state, postalCode, country);
	}



	public static Performable theUser(DataTable information) {
		List<Map<String, String>> params = information.asMaps(String.class, String.class);
		String username = params.get(0).get("username");
		String password = params.get(0).get("password");
		String confirmPassword = params.get(0).get("confirmPass");
		return instrumented(RegisterUserInformation.class, username, password, confirmPassword);
	}

}
