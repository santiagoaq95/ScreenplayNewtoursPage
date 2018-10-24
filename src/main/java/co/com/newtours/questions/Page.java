package co.com.newtours.questions;

import co.com.newtours.ui.NewtoursLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class Page implements Question<Integer> {

	@Override
	public Integer answeredBy(Actor actor) {

		if (Text.of(NewtoursLoginPage.LOGIN_USERNAME).viewedBy(actor).asList().size() > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static Page load() {
		// TODO Auto-generated method stub
		return new Page();
	}

}
