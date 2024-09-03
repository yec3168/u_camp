package review;

public class DayOneReivew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 *  	컴파일러 
		 *  : 사람이 작성한 프로그래밍 언어와 기계어 사이에서 다리 역할을 함.
		 *  
		 *  	Java
		 *  1. JVM에 의해서 어느 운영체제에서도 독립적으로 실행이 가능함.
		 *  2. 객체를 생성해서 더 큰 어플리케이션을 완성시키는 oop이다.
		 *  3. Ram을 좀 더 효율적으로 관리하도록 사용하지 않은 메모리를 자동으로 관리해준다.
		 *  4. 오픈 소스 라이브러리가 풍부
		 *  5. 대 소문자를 구별한다.
		 *  
		 *  ** cmd에서 Java 실행 법
		 *   - 컴파일 : javac 클래스명.java 
		 *   - 실행 : java 클래스명
		 *   
		 *   
		 *  JVM, JRE, JDK
		 *  1. JVM : java를 실행하는 가상머신
		 *  2. JRE : JVM + API라는 의미로 JAVA를 실행하는 환경을 구축.
		 *  3. JDK : JRE + 컴파일러 + 라이브러리 etc.. 같이 개발에 필요한 라이브러리 또는 환경을 제공한다.
		 *  
		 *  
		 */
		
		
		 //-----------------------------------------------------------------------------------------------------------------------------//		
		
		
		/**
		 * 		규칙(필수)
		 * 1. 영대소문자를 사용하거나 한글을 사용한다.
		 * 2. 특수문자는 '_' or '$'만 사용한다.
		 * 3. 변수의 첫 문자는 숫자가 와선 안된다. 대신 특수문자나 대문자는 가능.
		 * 4. Java에서 사용되는 예약어(public, int, double ...)를 사용해선 안된다.
		 * 
		 * 		규약
		 * 1. 클래스의 이름은 대문자로 시작한다.
		 * 2. 메소드나 변수명은 소문자로 시작한다.
		 * 3. 두 개 이상의 단어를 결합하여 변수명을 작성하는 경우, 각 단어의 첫글자를 대문자로 하여 구분한다.
		 * 4. 상수에 경우 모두 대문자를 사용한다. 
		 * 		ex) final int DEP_PRFIX = 123;
		 * 5. 상수에서 여러개의 단어를 사용하는 경우 '_'를 사용해서 구분한다.
		 * 		
		 * 
		 * ** 기본 자료형은 소문자로 시작									★★★★★★★★★★★★★★★★★★★★★
		 *  ex) int, double, float
		 * 
		 * ** 참고 자료형은 대문자로 시작.									★★★★★★★★★★★★★★★★★★★★★
		 *  ex) String, Car, Book, Thread
		 */
		
		 int abc = 1; // o
		 int Abc = 1; // o 되긴 하나 첫 시작은 소문자로 하는걸 추천.
		 int _abc = 2; // o
		 int _$abc = 2; // o
		 //int 1_123 = 3; // x 변수명에 첫 시작은 숫자가 와선 안된다.			★★★★★★★★★★★★★★★★★★★★★
		 //int int = 4;  // x 예약어는 작성할 수 없음.					★★★★★★★★★★★★★★★★★★★★★
		 //int public = 4; // x public은 예약어
		 final int PRE_PASS = 5;
		 String str1 = "abc";
		 
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		 
		 
		 /**
		  *  == 과 eqauls
		  *  
		  *  	==
		  *  - '=='는 서로간의 값을 비교하거나 메모리상 주소가 같은지 비교한다.
		  *  - 기본 자료형일 경우 값을 비교
		  *  - 참고 자료형일 경우 서로간의 메모리상 위치를 비교
		  *  
		  *  
		  *  	eqauls
		  *  - 'equals'는 서로간의 값을 비교해서 같은지 아닌지 판별한다.
		  *  
		  *  
		  *  String 과 String객체, 기본자료형
		  *  	
		  *  	기본자료형
		  *  1. 기본자료형(int, double)은 stack영역에 저장된다.
		  *  2. 메모리에 저장할 때는 사용자가 입력한 값을 저장한다.
		  *  
		  *  	String
		  *  1. 참조자료형 String은 heap영역에 String pool에 관리가 된다.
		  *  ** Reference 타입 : 해당영역의 값이 아닌 주소를 참조하는 것.
		  *	 2. stack에는 값이 저장된 pool 영역의 메모리 주소의 값이 들어있다.
		  *  3. 그렇기 때문에 String으로 생성된 두 개의 변수에 같은 값을 넣으면 같은 메모리를 참조한다.
		  *
		  *  	String 객체
		  *  1. heap영역에 생성한다.
		  *  2. 서로서로 다른 객체이기때문에 서로 다른 주소(해시코드)를 가지고 있다.
		  *  3. 그렇기 때문에 두개의 String new 객체를 생성하면 heap에 완전히 다른 영역을 생성하기 때문에 주소가 다르다.
		  */
		
		 int comp_a = 10;
		 int comp_b = 10;
		 
		 System.out.println("comp_a == comp_b(==)  ::::" + (comp_a == comp_b));  // 참고 자료형은 서로간의 값을 비교  true
		 
		 String comp_str1 = "abc";
		 String comp_str2 = "abc";
		 String comp_str3 = "abd";
		 String comp_str4 = new String("abc");
		 String comp_str5 = new String("abc");
		 
		 System.out.println("comp_str1 == comp_str2(==) :::: " + (comp_str1 ==comp_str2)); //  true
		 System.out.println("comp_str1 == comp_str3(==) :::: " + (comp_str1 ==comp_str3)); //  false 	서로 다른 주소
		 System.out.println("comp_str1 == comp_str4(==) :::: " + (comp_str1 ==comp_str4)); //  false 	서로 다른 주소
		 System.out.println("comp_str4 == comp_str5(==) :::: " + (comp_str4 ==comp_str5)); //  false 	서로 다른 주소
		 System.out.println("comp_str1.eqauls(comp_str4)(equals) :::: " + (comp_str1.equals(comp_str4))); // true
		 System.out.println("comp_str4.eqauls(comp_str5)(equals):::: " + (comp_str4.equals(comp_str5))); //  true
		
		 
		 
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		 
		 
		 /**
		  *  리터럴 (literal) : 자동적
		  *  : 자료형없이 값을 넣을 때 JVM이 자동으로 값의 대표적인 자료형으로 변환해서 넣어줌.
		  *  
		  *   정수 : int
		  *   실수 : double
		  *   
		  *   ** 연산작업을 진행하면 자동으로 대표적인 자료형으로 승급함.
		  *   
		  *   캐스케이딩		: 수동적
		  *   : 개발자가 해당 변수의 자료형을 강제적으로 변환하는 작업.
		  *   byte a = (byte) 10;
		  *   
		  *  
		  */
		 
		 byte bt1 = 10; // 10은 리터럴로 자동으로 int형태
		 byte bt2 = 20; // 20 또한 int
		 
		// byte result_bt = bt1 + bt2; // 연산작업시 int형태로 승급하기때문에 error 발생.
		 
		 byte result_bt1 = (byte) (bt1+bt2);
		 int result_bt2 = bt1 + bt2;
		 
		 
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		 
		 
		 /**
		  *  a = a + 1;
		  * 	전치
		  * : 증가하고 대입
		  *  ex) ++a
		  *  
		  * 	후치
		  * : 대입하고 감소
		  *  ex) a--;
		  *  
		  */
		 
		 int aa = 0;
		 System.out.println("aa ::: " + aa);
		 System.out.println("aa++ ::: " + aa++); // 후치 : 출력하고 증가 == 0
		 System.out.println("--aa ::: " + --aa); // 전치 : 감소하고 출력 == 0
		 
		 
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		 
		 /**
		  * 논리 연산자
		  * 
		  * 1. &&, &
		  *  : and라는 의미
		  *  
		  *  && :  앞에서 false가 나오면 뒤에꺼는 pass  -> 뒤 연산을 안하다보니 속도가 빠름.
		  *  & : 앞에서 false가 나와도 뒤에 연산도 확인.
		  *  
		  *  2. ||, |
		  *  : or라는 의미
		  *  
		  *  || : && 와 같음
		  *  | : &와 같음
		  *  
		  *  
		  *  3. !
		  *  : not 
		  *
		  *	 4. ^
		  *  : xor
		  *  
		  */
		 
		 int comp_aa = 0;
		 
		 System.out.println((comp_aa > 0 ) && (comp_aa == 0)); //false
		 System.out.println((comp_aa > 0 ) & (comp_aa == 0)); //false
		 
		 System.out.println();
		 
		 comp_aa =  1;
		 System.out.println((comp_aa-- > 0 ) && (comp_aa++ == 0)); // true // 후위 연산자 즉, a++은 비교 연산자보다 우선순위가 낮음.
		 
		 comp_aa = 1;
		 System.out.println((--comp_aa > 0 ) & (++comp_aa == 0)); // false
		 
		 
		 
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		 
		 /**
		  * 쉬프트 연산자
		  * 
		  * 부호를 유지.
		  *  	>> 오른쪽 쉬프트 ( 나누기)
		  *  	<< 왼쪽 쉬프트 ( 곱하기 )
		  * 
		  * 부호를 무시.
		  * 	>>>
		  * 	<<<
		  *  
		  */
		 
		 System.out.println(10 >> 1); // 5;
		 System.out.println(10 << 2); // 40
		 System.out.println(-10 << 2); // -40
		 System.out.println("-------------------------------");
		 System.out.println(-10 >>> 1); //2147483643
		 
		 
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		    
		 /**
		  * 삼항연산자
		  * 
		  *  (조건문)? 참 : 거짓
		  *  ex) (10 > 5 ) "크다" : "작다"
		  *   = 크다.
		  */
		 
		 System.out.println((10 > 5)? "크다":"작다");
		 
	}

}
