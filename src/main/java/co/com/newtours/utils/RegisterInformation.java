package co.com.newtours.utils;

import co.com.newtours.models.Persona;

public class RegisterInformation {

	private Persona persona =new Persona();
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public void RegisterContactInformation(String first, String last, String number, String email) {
		persona.setFirstName(first);
		persona.setLastName(last);
		persona.setPhone(number);
		persona.setEmail(email);
		
	}
	public void RegisterMaillingInformation(String address1, String address2, String city, String state,
			String postalCode, String country) {
		persona.setAddress1(address1);
		persona.setAddress2(address2);
		persona.setCity(city);
		persona.setState(state);
		persona.setPostalCode(postalCode);
		persona.setCountry(country);
	}

	// Método para ingresar información de usuario
	public void RegisterUserInformation(String uid, String pass, String confirm) {
		persona.setUsername(uid);
		persona.setPassword(pass);
		persona.setConfirmPassword(confirm);
	}
	
}
