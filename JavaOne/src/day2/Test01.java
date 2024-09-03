package day2;

public class Test01 {

	public static void main(String[] args) {
		
		
		/**
		 *  문제 1.
		 *  구구단 중 3단에 대한 실행 결과
		 */
		
		int number = Integer.parseInt(args[0]);
		
		for(int i = 1; i < 10; i++) {
			System.out.println(number + " X "+ i + " = " + number*i);
		}
		
		
		/**
		 * 문제 2.
		 * 100~ 200 까지 소수를 추출하라
		 */
		
	
		System.out.println("다중 반복문으로 소수 찾기.");
		
		for(int i =100; i <= 200; i++) {
			int count = 0;
			for (int j = 1; j <= i; j++) {
				if(i % j == 0) {
					count +=1;
					if( count > 2)
						break;
				}
			}
			if (count == 2)
				System.out.print(i +" ");
		}
		
		
		System.out.println("breakout");
		
		breakout:
			for(int i =100; i < 200; i++) {
				for(int j = 2; j < i /2; j++) {
					if(i % j == 0)
						continue breakout;
				}
				System.out.print(i + " ");
				
			}
		
		
		
		
		
		
	}

}
