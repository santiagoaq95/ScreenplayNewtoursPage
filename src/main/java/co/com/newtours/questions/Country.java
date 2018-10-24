package co.com.newtours.questions;

import co.com.newtours.ui.NewtoursRegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class Country implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		
		return Text.of(NewtoursRegisterPage.REGISTER_COUNTRY).viewedBy(actor).asString();
	}
	public static Country name() {
		// TODO Auto-generated method stub
		return new Country();
	}

	

}
