package day.four;

public class StringTest {
	
	/**
	 *  	String
	 *  - 불변의 객체.
	 *  - 공식문서에 final로 선언되어 있어서 값이 변경이 안됨.
	 *  - concat같은 메소드가 안됨.
	 *  - 하지만 값을 재정의하는 것은 가능함.
	 *  	ex) String s = "abc";
	 *  		s.concat("def"); // 안됨.
	 *  		
	 *  		String s = "abc";
	 *          s= "def"; //가능.
	 *          
	 *          
	 *  - string은 heap영역에 string pool에 값이 저장되어 있고, 해당 주소를 stack영역에 저장 됨.
	 *  - String s1이랑 s2가 같은 문자열 "abc"를 가지고 있으면 spring pool에 저장된 "abc"주소를 같이 참조함.
	 *  
	 *  	ex) String s1 = "abc";
	 *  		String s2 = "abc";
	 *   		
	 *   		s1 == s2 (true)  		// 서로 주소가 같음
	 *   		s1.equals(s2) (true)	// 서로 값이 같음.
	 *   
	 *   
	 *   	new String
	 *   - 일반 String과 달리 heap영역에 저장함.
	 *   - new를 통해 인스턴스를 만들 때 마다 서로 다른 영역을 만들기 때문에 서로 다른 주소를 가르키고 있음.
	 *   
	 *   	ex ) String s1 = new String("abc");
	 *   		 String s2 = new String("abc");
	 *   
	 *   		s1 == s2 (false)		// 서로 주소가 다름.
	 *   		s1.eqauls(s2) (true) 	// 서로 값이 같음.
	 *   	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 *  concat처럼 값을 이어 붙이는 것은 String의 불변의 속성 때문에 값이 변경이 안된다.
		 */
		System.out.println("String의 concat메소드 사용.");
		String s = "100";
		s.concat("200");
		System.out.println("s.concat(200) :::: " + s);
		
		
		
		 System.out.println();
		 System.out.println("=============================================================");
		 System.out.println();
		
		 
		 
		 //=============================================================================================================================================//
		 
		 System.out.println("String 값 재할당.");
		 String s2 = "abc";
		 System.out.println(s2 == args[0]); // falseargs는 new String느낌
		 System.out.println(s2.equals(args[0])); //true
		 s2 = "def";
		 System.out.println(s2);  
		
		
		 
		 
		 System.out.println();
		 System.out.println("=============================================================");
		 System.out.println();
		 
		//=============================================================================================================================================//
		 
		 
		 /**
		  *  	StringBuilder
		  *  - 가변의 Stirng
		  *  - 값을 변경이 가능함.
		  */
		 
		 StringBuilder sb = new StringBuilder("asd");
		 System.out.println(sb.append("qwe"));
		 System.out.println(sb.insert(0, "!!!!!"));
		 System.out.println(sb.toString());
		 
		 
		 
		 System.out.println();
		 System.out.println("=============================================================");
		 System.out.println();
		 
		//=============================================================================================================================================//
		 
		 
		 /**
		  *  	String vs StringBuffer vs StringBuilder 속도 테스트
		  *  
		  *   String < StringBuffer < StringBuilder
		  *   
		  *   but. StringBuilder는 속도는 빠르지만 쓰레드의 안전성을 보장하지 않음.
		  */
		 
		 timeCheckString(); //String
		 System.out.println("=============================================================");
		 timeCheckStringBuffer(); //StringBuffer;
		 System.out.println("=============================================================");
		 timeCheckStringBuilder();  // StringBuilder;
		 
		 
		
		 
	}
	
	public static void timeCheckStringBuffer() {
		 Long start = System.currentTimeMillis();
		 StringBuffer buffer = new StringBuffer("");
		 for(int i =0; i < 100000; i++) {
			 buffer.append(i);
		 }
		 Long end = System.currentTimeMillis();
		 
		 System.out.println(end - start);
	}
	public static void timeCheckStringBuilder() {
		Long start = System.currentTimeMillis();
		 StringBuilder builder = new StringBuilder("");
		 for(int i =0; i < 100000; i++) {
			 builder.append(i);
		 }
		 Long end = System.currentTimeMillis();
		 
		 System.out.println(end - start);
	}
	public static void timeCheckString() {
		Long start = System.currentTimeMillis();
		 String s0 = "";
		 for(int i =0; i < 100000; i++) {
			 s0 += i;
		 }
		 Long end = System.currentTimeMillis();
		 
		 System.out.println(end - start);
	}

}
