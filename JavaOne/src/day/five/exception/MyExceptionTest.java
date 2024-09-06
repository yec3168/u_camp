package day.five.exception;

public class MyExceptionTest {

	public static void main(String[] args) {
		
		int month = 13;
		
		if( month > 12) {
			try {
				MyException e = new MyException("1~12 사이의 값이 아님");
				
				throw e; // 임의 exception을 강제로 발생시킴.
				
			}catch(MyException e) {
				System.out.println(e.getMessage());
			}
			
			
		}

	}

}
