package co.com.newtours.task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;
import java.util.Map;

import co.com.newtours.models.Usuario;
import co.com.newtours.ui.NewtoursLoginPage;
import cucumber.api.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class Write implements Task {
	private Usuario user;
	

	public Write(String user, String pass) {
		this.user = new Usuario(user, pass);
	}

	@Override
	@Step("{0} Enter his username and password on Login page ")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(this.user.getUsername()).into(NewtoursLoginPage.LOGIN_USERNAME),
				Enter.theValue(this.user.getPassword()).into(NewtoursLoginPage.LOGIN_PASSWORD));

	}


	public static Write onFields(DataTable lista) {
		List<Map<String, String>> params = lista.asMaps(String.class, String.class);
		String user = params.get(0).get("username");
		String password = params.get(0).get("password");
		return instrumented(Write.class, user, password);

	}

}
