package day2;

public class BreakTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * break
		 * 
		 *  어떠한 조건이나 상황에 반복문이나 진행하는 작업을 탈출하는 것.
		 */
		
		int e = 0;
		while(true) {
			// i가 10보다 크면 탈출
			if(e >= 10)
				break;
			System.out.println(e++);
			 
		}
		
		/**
		 * 다중 반복문 탈출.
		 * 
		 * 1. breakPoint를 설정한 후. 반복문을 작성.
		 * 2. breakPoint를 만나면 해당 다중반복문을 모두 중지시키고 처음 선언한 breakpoint로 이동. 
		 */
		
		breakOut:
			for(int i =1; i < 10; i++) {
				for(int j =1; j < 10; j++) {
					
					if( (i * j) % 2 == 0 ) {
						System.out.println("반복문 탈출 : " + (i*j));
						break breakOut;
					}
				}
				
			}
		System.out.println("반복문 완전 탈출");
		
		
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		
		/**
		 * Continue 
		 * 
		 * 반복문 작업 도중 continue를 만나면 아래 작업은 무시하고 다음 작업을 진행함.
		 */
		
			for(int i =0; i< 10; i++) {
				if( i % 2 != 0) {
					continue;
				}
				System.out.println("짝수 ::::" + i);
			}

	}

}
