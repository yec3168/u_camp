package day.five;

public class ExceptionTest {
		
	/**
	 * 		Exception
	 *  - 연산오류, 포맷오류 처럼 상황에 따라 해결이 가능한 오류.
	 *  
	 *    1. RuntimeExcetpion(unCheckedExceptiion)
	 *  - 실행시켜야 알 수 있는 오류
	 *      ex) NumberFormatExceiption, ClassCastException
	 *  	
	 *    2. checkedException
	 *  - 컴파일하기전에 체크하는 예외처리
	 *      ex) IOException, ClassNotFoundException
	 *      
	 *      
	 *	- 최대한 발생할 수 있는 exception은 다 잡아주는게 원칙
	 *     reason) exception을 처리할 때, 해당 exception만 처리할 수 있는 코드를 작성이 가능.
	 *  - 그 외 신경쓰지 못한 exception을 따로 처리.
	 */
	public static void main(String[] args) {
		
			// simple exception test
		 for (int i = -3; i <3; i++) {
			 try {
				 System.out.println(4/ i);
				 
			 }catch(ArithmeticException e) {
				 e.printStackTrace(); // 해당 exception stack 출력.
				 					  // 기존에는 exception이 발생하면 실행 중단.
				 System.out.println(e.getMessage());
				 
			 }catch(ArrayIndexOutOfBoundsException  e) {
				 System.out.println("배열의 범위를 벗어남");
				 System.out.println(e.getMessage());
			 }
			 catch(Exception e) {
				 System.out.println(e.getMessage());
			 }finally{
				 // 예외처리 발생여부에 상관없이 무조건 실행되는 블록.
				 // exception을 한번씩 확인하고 예외처리가 있든 없든 무조건실행됨.
				 System.out.println("Finally :::: 무조건 실행되는 블록");
			 }
			 			 
		 }
		 
		 
		 // io exception 
		 // Scanner같은 것.
		 // 마지막에 무조건 scan.close()가 실행됨
		 // AutoClose가 있어야 함.
		 
		 

	}

}
