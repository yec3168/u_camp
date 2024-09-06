package day.five.exception;

public class MyException extends RuntimeException{
	public MyException(String msg) {
		//  아래 코드 때문에 super()가 없어진 것
		super(msg);
	}
}
