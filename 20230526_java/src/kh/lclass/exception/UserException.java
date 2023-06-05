package kh.lclass.exception;

public class UserException extends Exception{
	
	public UserException() {
		super("유저익셉션 발생");
	}
	public UserException(String msg) {
		super(msg);
	}
}
