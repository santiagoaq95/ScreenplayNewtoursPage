package co.com.newtours.task;

import co.com.newtours.models.Persona;
import co.com.newtours.ui.NewtoursRegisterPage;
import co.com.newtours.utils.RegisterInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class RegisterUserInformation implements Task {

	private RegisterInformation register = new RegisterInformation();
	public RegisterUserInformation(String uid, String pass, String confirm) {
		register.RegisterUserInformation(uid, pass, confirm);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		Persona persona = register.getPersona();
		actor.attemptsTo(Scroll.to(NewtoursRegisterPage.REGISTER_SUBMIT_BUTTON));
		actor.attemptsTo(Enter.theValue(persona.getUsername()).into(NewtoursRegisterPage.REGISTER_USERNAME));
		actor.attemptsTo(Enter.theValue(persona.getPassword()).into(NewtoursRegisterPage.REGISTER_PASSWORD));
		actor.attemptsTo(Enter.theValue(persona.getConfirmPassword()).into(NewtoursRegisterPage.REGISTER_CONFIRM_PASSWORD));
		actor.attemptsTo(Click.on(NewtoursRegisterPage.REGISTER_SUBMIT_BUTTON));
		
	}

}
