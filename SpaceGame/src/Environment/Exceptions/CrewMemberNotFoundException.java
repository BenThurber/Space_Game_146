package Environment.Exceptions;

/**
 * Exception when a CrewMember object doesen't exist when searched for.
 * @author Benjamin Thurber
 * @author Blake Kayser
 *
 */
public class CrewMemberNotFoundException extends Exception {
	public CrewMemberNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public CrewMemberNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CrewMemberNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CrewMemberNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CrewMemberNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
