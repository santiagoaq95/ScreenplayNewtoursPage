package co.com.newtours.exceptions;

public class StartingException extends AssertionError{

	private static final long serialVersionUID = 5L;
	public static final String MESSAGE_PAGE_UNLOAD="The page could not be loaded";
	
	public StartingException(String message, Throwable cause) {
		super(message,cause);
	}



	
	

}


