package co.com.newtours.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://newtours.demoaut.com/mercuryregister.php")
public class NewtoursRegisterPage extends PageObject{
	
	public static final Target REGISTER_FIRSTNAME= Target.the("Register textbox First Name").located(By.name("firstName"));
	public static final Target REGISTER_LASTNAME= Target.the("Register textbox Last Name").located(By.name("lastName"));
	public static final Target REGISTER_PHONE= Target.the("Register textbox Phone").locatedBy("//input[@name='phone']");
	public static final Target REGISTER_EMAIL= Target.the("Register textbox Email").located(By.name("userName"));
	public static final Target REGISTER_ADDRESS1= Target.the("Register textbox Address1").locatedBy("//input[@name='address1']");
	public static final Target REGISTER_ADDRESS2= Target.the("Register textbox Address2").located(By.name("address2"));
	public static final Target REGISTER_CITY= Target.the("Register textbox City").located(By.name("city"));
	public static final Target REGISTER_STATE= Target.the("Register textbox State").located(By.name("state"));
	public static final Target REGISTER_POSTAL_CODE= Target.the("Register textbox Postal Code").located(By.name("postalCode"));
	public static final Target REGISTER_USERNAME= Target.the("Register textbox Username").located(By.name("email"));
	public static final Target REGISTER_PASSWORD= Target.the("Register textbox password").located(By.name("password"));
	public static final Target REGISTER_CONFIRM_PASSWORD= Target.the("Register textbox Confirm password").locatedBy("//input[@name='confirmPassword']");
	public static final Target REGISTER_SUBMIT_BUTTON= Target.the("Register button submit").locatedBy("//input[@type='image']");
	public static final Target REGISTER_COUNTRY= Target.the("Register Select country").located(By.name("country"));
	public static final Target REGISTER_NOTE= Target.the("Register Select country").locatedBy("//b[contains(text(),'Note: Your user name is')]");
	
	
	
	

}
