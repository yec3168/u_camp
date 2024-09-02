
public class OperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * 연산자 중 하나라도 실수가 존재하면 값은 실수로 나온다.
		 */
		System.out.println(10 + 12);
		System.out.println(10- 2);
		System.out.println(10/3); 
		System.out.println(10%3);
		

		System.out.println(10 + 0.5);
		System.out.println(10 - 0.5);
		System.out.println(10 / 0.5);
		System.out.println(10 % 0.5);
		
		
		System.out.println(10.0 + 5);
		System.out.println(10.0 - 5);
		System.out.println(10.0 / 5);
		System.out.println(10.0 % 5);
		
		
		
		 //-----------------------------------------------------------------------------------------------------------------------------//		
	
		int b = 0;
		/**
		 *  ++
		 *  변수 = 변수+1
		 */
		System.out.println(++b); // 증가하고 출력. 	=1 (전치형)
		System.out.println(b--); // 출력하고 감소.	=1 (후치형)
		System.out.println(b);	 //				=0
		
		
		 //-----------------------------------------------------------------------------------------------------------------------------//
		
		/**
		 * 논리연산자
		 *  
		 *  && = and
		 *  || = or
		 *  ! = not
		 *  ^ = xor
		 */
		
		System.out.println(true ^ (5==5)); // true xor true == false;
		System.out.println(false ^ (5==5)); // false xor true = true;
		
		int a = 0;
		System.out.println( (a++) == (++a)); // 1 = 2 false
		System.out.println( a++ == a++); // 1 = 2  false
		
		
		 //-----------------------------------------------------------------------------------------------------------------------------//
		
		/**
		 * 연산자 우선순위
		 * && vs &
		 */
		int c = 0;
		System.out.println( (++c < 0) && (c--==0)); 
		System.out.println(c); //1
		
		c=0;
		System.out.println( (++c < 0) & (c--==0));
		System.out.println(c); //0
		
		
		 //-----------------------------------------------------------------------------------------------------------------------------//
		
		/**
		 * 쉬프트 연산자
		 */
		
		System.out.println(10 >> 1); // 5 오른쪽 쉬프트 1번 움직여라
		System.out.println(10 << 2); // 40 왼쪽으로 쉬프트 2번 움직여라
		
		System.out.println(-10 >> 1); // -5 부호를 유지한체 오른쪽 쉬프트 1번
		
		System.out.println(-10 >>> 1); // 2147483643 부호를 무시. 오른쪽 쉬프트 1번
		
		
		
		/**
		 * 삼항 연산자.
		 */
		System.out.println((5>3)? "크다":"작다");
	}

}
