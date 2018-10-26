package co.com.newtours.questions;

import co.com.newtours.ui.NewtoursRegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

//Questions para verificar si el usuario ingresado en el registro es el correcto 
public class TheMessage implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {

		return Text.of(NewtoursRegisterPage.REGISTER_NOTE).viewedBy(actor).asString();
	}

	public static TheMessage ofUsername() {
		return new TheMessage();
	}

}
