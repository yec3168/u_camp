package day2;

public class IfTest {

	public static void main(String[] args) {
		
		/**
		 * 인자 주는법.
		 * 
		 *  1. run Configuration 클릭
		 *  2. Argument tab 클릭
		 *  3. variables에서 ${string_prompt} 클릭하면 실행시 args 인자를 받을 수 있음.
		 */
		
		
		/**
		 * if(조건문){
		 * 
		 * 	} 
		 * 	
		 *  * 한줄일 경우 생략.
		 */
		int month = Integer.parseInt(args[0]);
		
		if (month == 2) {
			System.out.println("28일");
		}
		else if( month  <=7  && month % 2 != 0 ||  month >7 && month % 2 == 0) {
			System.out.println("31일");
		}
		else if( month <= 7 && month % 2 == 0 ||  month >7 && month % 2 != 0) {
			System.out.println("30일");
		}
		
		
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		
		/**
		 * 		switch
		 * 	switch(변수){
		 * 		case 조건:
		 * 			실행내용.
		 * 			break;
		 * 		case 조건:
		 * 			실행내용.
		 * 			break;
		 * 		default:
		 * 			실행내용.
		 * 	}
		 * 
		 *  ** 실수는 근사치라 값을 정확하게 확인할 수 없다.
		 *  
		 *  byte, short, int, char, String, enum 타입만 가능.
		 */
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.println("31일");
			break;
		case 4, 6, 9, 11 :
			System.out.println("30일");
			break;
		default:
			System.out.println("28일");
		}
		
		
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		
		
		
		
	}

}
