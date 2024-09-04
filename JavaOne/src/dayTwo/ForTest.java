package dayTwo;

public class ForTest {

	public static void main(String[] args) {
		
		/**
		 * for(변수, 조건문, 증감식){
		 * 		실행내용.
		 * 	}
		 * 
		 * 
		 * i++(증감식)은 마지막에 실행.
		 */
		
		int length = Integer.parseInt(args[0]);
			
		for( int i =1; i <= length; i++) 
			System.out.print(i + " ");
		
		
		System.out.println();
		
		/**
		 * 문제 1.
		 * 1~10까지 합을 구하라 
		 */
		int sum = 0;
		for(int i =1; i<=10; i++) 
			sum += i;
		
		System.out.println("1부터 10까지 합  :::: "+ sum);
		
		
		/**
		 * 문제 2.
		 * argument 인자를 받아 1부터 입력받은 수까지 곱을 구한다.
		 */
		sum = 1;
		for(int i =1; i <= Integer.parseInt(args[0]); i++) 
			sum *= i; 

		System.out.println("1부터 "+args[0] +"까지 곱  :::: "+ sum);
		
		
		/**
		 * 문제 3.
		 * 100~ 200 까지 소수를 추출하라
		 */
		
//		System.out.println(" 소수 찾기");
//		for(int i = 100; i <= 200; i++) {
//			if (i == 2 || i == 3 || i == 5 ||i ==7|| i == 9) {
//				System.out.print(i + " ");
//			}
//			else if(i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0 && i % 9 != 0) {
//				System.out.print(i+" ");
//			}
//		}
		
		System.out.println();
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		

		/**
		 *  while(조건문){
		 *  	실행내용.
		 *   }
		 */
		
		
		sum = 1;
		while(sum < 10) {
			System.out.print(sum++ + " ");
		}
		System.out.println();
		
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		
		/**
		 * do{
		 * 		처음 무조건 실행할 내용.
		 * 	} while(조건);
		 */
		
		do {
			// 한번은 무조건 실행함.
			System.out.println("한번은 무조건 실행함.");
			break;
		}while(false);
		
		sum = 1;
		while(sum == -1){
			System.out.println("실행 못함.");
		}
		
		
		
		/**
		 * for-each
		 */
			
		int array [] = new int[] {1,2,3,4,5,6,7};
		
		for(int num : array) {
			System.out.print(num+" ");
		}
	}

}
