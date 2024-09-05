package day.four.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class GenericTest {

	
	public static <T> void main(String [] args) {
		/**
		 * 		generic
		 *  - Collection에 타입을 지정해주는 것.
		 *  - 예를 들어 List에 String이라는 타입을 지정해서 그 외 참조자료형이 들어오지 못하게 하는것.
		 *  		ex)  List<String> list = new ArrayList<>();
		 *    장점) 기존에 타입을 지정하지 않으면 Object 타입으로 하나하나 타입을 지정해야하는데 그럴 필요가없음
		 *         작업 수가 줄어 속도가 빠름.
		 *         
		 *  - 자바에서 제공하는 제네릭타입 매개 변수 `T`라는게 존재함. 
		 *   T : Type
		 *   E : Element
		 *   K, V : Key, Value
		 *   N : Number\
		 */

		/**
		 * 		generic
		 *  - Object는 하나하나 캐스팅 해줘야하기때문에 코드가 길어짐에따라 불편함이 생김.
		 *  -
		 */
		
		GenericOf g = new GenericOf();
		g.setT(new Object());   // T의 타입을 Object로
	 	g.setT("하나");  			// T의 타입을 String으로

	 	
	 	GenericOf<String> gg = new GenericOf();
	 	gg.setT("asd"); // 위에서 String으로 선언
	 	//gg.setT(123); // String이라서 오류;
	
	 	
	 	
	 	
	 	//==============================================================================================================
	 	
	 	/**
	 	 * 		static으로 선언된 generic 메소드
	 	 *  - 메소드는 <T>를 붙여줌으로서 제네릭이라고 명시
	 	 *  - 리턴타입이 T라고 했으니 입력된 값이 T의 타입을 결정 지음.
	 	 */
	 	String str = GenericOf.getObject("String");
	 	
	 	
	 	//===============================================================================================================
	 	
	 	/**
	 	 *   	List<? extends T> 
	 	 *   - T가 있는 객체 GenericOf를 생성할 때 사용자가 Object 타입을 지정하면 T= Object가 된다.
	 	 *   - ?는 T를 상속받는 인스턴스이다.
	 	 *   - go.setObject(new ArrayList<Stiring>()) 하면 List = ArrayList, ? = String이 된다.
	 	 */
	 	GenericOf<Object> go = new GenericOf<>();	// 현재 go가 가르키는 generic의 T는 Object임.
	 	go.setObject(new ArrayList<String>()); // 그러면 저 ArrayList의 타입인 String이 Object를 상속받는 String이 되는것.
	}
}
