package co.com.newtours.questions;

import co.com.newtours.ui.NewtoursLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class Title implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		
			return Text.of(NewtoursLoginPage.LOGIN_SING_OFF).viewedBy(actor).asString();
		
	}

	public static Title singOff() {
		
		return new Title();
	}
	
	

	
}
