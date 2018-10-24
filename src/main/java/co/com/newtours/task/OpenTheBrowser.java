package co.com.newtours.task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheBrowser implements Task {

	private PageObject page;


	public OpenTheBrowser(PageObject page) {
		this.setPage(page);
	}

	@Override
	@Step("{0} Opens the browser on Newtours page ")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.browserOn(this.page));
		
		
	}

	public static OpenTheBrowser on(PageObject page) {

		return instrumented(OpenTheBrowser.class, page);
	}

	public PageObject getPage() {
		return page;
	}

	public void setPage(PageObject page) {
		this.page = page;
	}

}
