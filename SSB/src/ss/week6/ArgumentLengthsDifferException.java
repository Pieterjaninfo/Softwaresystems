package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {

	public ArgumentLengthsDifferException() {}
	public ArgumentLengthsDifferException(String msg) {
		super(msg);
	}
	public ArgumentLengthsDifferException(int l1, int l2) {
		super("error: length of command line arguments "
                + "differs (" + l1 + ", " + l2 + ")");
	}
	
}
