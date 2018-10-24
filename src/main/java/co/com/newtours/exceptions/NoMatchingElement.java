package co.com.newtours.exceptions;

public class NoMatchingElement extends AssertionError{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoMatchingElement(String message, Throwable cause) {
		super(message, cause);
	}
	
	public static String getMissingTitleMessage(String message) {
		return String.format("No se encuentra el titulo del menu: '%s'", message);
	}
}
