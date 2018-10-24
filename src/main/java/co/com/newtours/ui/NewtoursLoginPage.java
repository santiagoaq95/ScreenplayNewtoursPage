package co.com.newtours.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://newtours.demoaut.com")
public class NewtoursLoginPage extends PageObject {

	public static final Target LOGIN_USERNAME= Target.the("Login textbox Username").located(By.name("userName"));
	public static final Target LOGIN_PASSWORD= Target.the("Login textbox Password").located(By.name("password"));
	public static final Target LOGIN_BUTTON= Target.the("Login Button sign in").locatedBy("//input[@type='image']");
	public static final Target LOGIN_SING_OFF= Target.the("Login SIGN-OFF").locatedBy("//a[.='SIGN-OFF']");
	
}
