package day.five;

/**
 * 			throws
 *  - 발생된 Exception을 호출한 메소드에게 보내는 것.
 *   
 *    main - homeworkOne - homeworkTwo
 *    
 *      1. homeworkTwo에서 Exception 발생
 *        main, homeworkOne에서 처리가능
 *        
 *      2. homeworkOne에서 Exception 발생
 *        main에서 처리가능
 */
public class ThrowsTest {

	public void homeworkTwo() throws ArithmeticException, NullPointerException {
		System.out.println("Homework Two!! start");
		
		
		System.out.println(10/0); // exception 발생
								  // throws 하여 에러를 자신을 호출한 homeworkOne에게 전달.
		
		
		System.out.println("Homework Two!! end");
	}
	
	public void homeworkOne() {
		System.out.println("Homework one start");
		
		/**
		 * 어떠한 메소드에서 Exception이 발생한다면, 메소드를 호출한 최종 도달지 main에서도 처리가 가능함.
		 */
		try {
			homeworkTwo();
		}catch(ArithmeticException e) {
			System.out.println("homeworkTwo에서 발행한 homeworkOne에서 Exception 잡기");
		}
		
		System.out.println("Homework one end");
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Test 시작");
		ThrowsTest t = new ThrowsTest();
		
		t.homeworkOne();
		
		/**
		 * try {
			t.homeworkOne();
		}catch(ArithmeticException e) {
			System.out.println("homeworkTwo에서 발행한 Main에서 Exception 잡기");
		}
		 */
		System.out.println("Test 종료");
	}

}
