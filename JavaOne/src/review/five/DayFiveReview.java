package review.five;

import day.five.ThrowsTest;

public class DayFiveReview {

	/**
	 *		Excecption
	 *	-  연산오류 포맷오류처럼 상황에 따라 해결이 가능한 오류.
	 *
	 *    1. RuntimeException(unCheckedException)
	 *   - 실행시켜야 알 수 있는 오류
	 *     ex) NumberFormatException, ClassCastException
	 *     
	 *     
	 *    2. checkedException
	 *   - 컴파일하기전에 체크하는 예외처리
	 *   	ex) IOException, ClassNotFoundException
	 *   
	 *   
	 *   - 최대한 발생할 수 있는 exception은 다 잡아주는게 원칙
	 *     reason) exception을 처리할 때, 해당 exception만 처리하는 코드를 작성이 가능.
	 *   - 그외 신경쓰지 못한 예외처리는 Exception을 따로 처리.
	 *   
	 *
	 */
	public void homeworkTwo() throws ArithmeticException {
		System.out.println("homework two start");
		
		System.out.println(10 / 0);
		
		System.out.println("homework two end");
	}
	public void homeworkOne() {
		System.out.println("homework one start");
		
		/**
		 * 어떠한 메소드에서 Exception이 발생한다면, 메소드를 호출한 최종 도달지 main에서도 처리가 가능함.
		 */
		try {
			homeworkTwo();
		}catch(ArithmeticException e) {
			System.out.println("homeworkTwo에서 발행한 homeworkOne에서 Exception 잡기");
		}
		
		
		System.out.println("homework one end");
	}
	public static void main(String[] args) {
		
		// simple exception Test
		
		for(int i = -3; i < 3; i++) {
			try {
				System.out.println(2 / i);
			}catch(ArithmeticException e ) {// catch를 통해 exception을 잡아서 중단을 막아줌.
				e.printStackTrace(); // exception이 발생할 때까지의 과정을 출력
				System.out.println(e.getMessage());
				
			}catch(ArrayIndexOutOfBoundsException  e) {
				 System.out.println("배열의 범위를 벗어남");
				 System.out.println(e.getMessage());
			 }catch(Exception e) {
				 System.out.println(e.getMessage());
			 }finally{
				 // 예외처리 발생여부에 상관없이 무조건 실행되는 블록.
				 // exception을 한번씩 확인하고 예외처리가 있든 없든 무조건실행됨.
				 System.out.println("Finally :::: 무조건 실행되는 블록");
			 }
		}
		
		
		
		
		
		// DayFiveReview Throws test;
		
		System.out.println("Throws test 시작");
		DayFiveReview day = new DayFiveReview();
		
		day.homeworkOne();
		
		/**
		 * try {
			t.homeworkOne();
		}catch(ArithmeticException e) {
			System.out.println("homeworkTwo에서 발행한 Main에서 Exception 잡기");
		}
		 */
		System.out.println("Throws test 종료");
		
	}

}
