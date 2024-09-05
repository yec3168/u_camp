package review.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * final 선언된 클래스는 상속이 안됨.
 */
final class FianlClassTest{
	
}
public class DayFourReview {

	/**
	 *  	static
	 *  - static(메소드) 영역에 적재한다.
	 *  - 메모리 로딩은 한 번만 한다. 										★★★★★★★
	 *  - 한 번 로딩 된 static의 값은 모든 인스턴스가 공유하여 사용한다. ( 접근제어자에 따라 다름)
	 *  - heap영역에 저장된 인스턴스들은 static 필드의 영역을 가지고있지 않는다. 	★★★★★★★
	 *  - 필드, 메소드 등 붙여서 사용한다.
	 *  - new 인스턴스 말고 클래스를통해 필드를 가져올 수 있다.
	 *  		ex) Parent.name;
	 *  - 
	 */
	
	/**
	 * 		(일반)필드, 메소드
	 * 	- 접근 제어자 default
	 *  - 초기값 지정안하면 default 값으로 자동 초기화.
	 *  
	 *  	(static) 필드, 메소드
	 *  - 접근제어자 default
	 *  - 처음 만들 때 한 번로딩되고 메소드(static)영역에 생성
	 *  - static필드가 존재하는 객체를 생성하면 따로 static필드를 저장하는 공간이 존재하지않음.
	 */
	int num;
	static int count;
	static String zero;
	
	static {
		// 여기서 초기화가 가능.
		zero = "0";
	}
	
	/**
	 * 		final
	 * - 값을 변경하지 못하게 되는 것.
	 * - 필드, 메소드, 지역변수, 클래스 등 붙이는게 가능
	 * 		메소드 : 오버라이딩 불가
	 * 		필드	: 한번 설정 후 변경 불가. 상수가 된다.
	 * 		클래스 : 상속이 안됨, 자식클래스를 생성할 수 없다.
	 * - 상수는 대문자로 적고 '_'로 구분
	 * - 변수 클래스 메소드 final은 메모리영역에 저장되나, 인스턴스 final은 heap영역에 저장된다.
	 * 
	 * 
	 * 		필드
	 *  - final로 선언된 필드에 초기값을 지정을 안한다면 `생성자`에서`만` 지정할 수 있다
	 *  		== Blank final이라고 한다.
	 *  - 한 번 지정하면 바꿀 수 없음.
	 */
	final String sleep = "zzz";
	final String cry;
	
	DayFourReview(){
		cry = "야옹~";
	}
	
	
	public static void main(String[] args) {
		
		// static test
		System.out.println("DayFourReview 객체 생성");
		DayFourReview four1 = new DayFourReview();
		four1.num++;
		four1.count++;
		System.out.println("DayFourReview1 test ::::" +  four1.num + " "+ four1.count);
		
		System.out.println("DayFourReview2 객체 생성");
		DayFourReview four2 = new DayFourReview();
		four2.num++;
		four2.count++;
		System.out.println("DayFourReview2 test ::::" +  four2.num + " "+ four2.count);
		
		
		
		
		System.out.println("\n\n=============================================================");
			
		
		
		
		DayFourReview four3 = new DayFourReview();
		//four3.sleep = 'wake up'; // final이라 변경 x
		System.out.println(four3.cry);
		
		
		System.out.println("\n\n=============================================================");
		
		
		
		/**
		 * 			String
		 * - 불변의 객체
		 * - append나 replace같은 메소드를 사용해도 값은 바뀌지 않는다.
		 * - 값의 재설정은 가능하다.
		 * 
		 *	 		ex) String s = "abc";
		 *  			s.concat("def"); // 안됨.
		 *  		
		 *  			String s = "abc";
		 *         		s= "def"; //가능.
		 *         
		 * - String은 heap영역에 String pool 영역에 저장되어 있다.
		 * - String s1과 s2가 같은 값 "abc"를 가지면, s1과 s2는 같은 참조값을 가진다.
		 * 
		 * 			ex) String s1 = "abc";
		 *  		String s2 = "abc";
		 *   		
		 *   		s1 == s2 (true)  		// 서로 주소가 같음
		 *   		s1.equals(s2) (true)	// 서로 값이 같음.
		 *   
		 *   
		 *   	new String
		 *  - heap 영역 자체에 저장함.
		 *  - new 를 통해 인스턴스를 생성하는 경우 서로 다른 참조값을 가지게 된다.
		 *  
		 *  
		 *  	ex ) String s1 = new String("abc");
		 *   		 String s2 = new String("abc");
		 *   
		 *   		s1 == s2 (false)		// 서로 주소가 다름.
		 *   		s1.eqauls(s2) (true) 	// 서로 값이 같음.
		 */
		
		 System.out.println("Stirng에 concat test");
		 String s1 = "abc";
		 s1.concat("cde");
		 System.out.println(s1);
		 
		 System.out.println("Stirng에 재할당 test");
		 s1= "cde";
		 System.out.println(s1);
		 
		 
		 
		 
		 
		 
		 System.out.println("\n\n=============================================================");
			
		 
		 /**
		  * 		Collections
		  *  - 배열과 달리 길이가 정해져 있지 않고 동적인 길이를 가짐.
		  *  - 객체의 집합이라 객체만 저장
		  *  	list.add(1) -> list.add(new Integer(1)) 라는 의미.
		  *  
		  *  
		  *  1. List (ArrayList, LinkedList, vector, Stack)
		  *  - 순서가 있고, 중복을 허용.
		  *  
		  *  2. Set( HashSet, SetTree)
		  *  - 중복이 없고, 순서가 없음.
		  *  
		  *  3. Map( HashMap, HashTable)
		  *  - key, value로 이루어져 있고
		  *  - key는 중복이 안됨
		  */
		 
		 
		 //=================================================================================================
		 
		 
		  /**
		   * 	1. List
		   *  - 중복이 가능하며 순서가 있다.
		   *  - 정수나 실수, 문자같은 기본자료형은 객체형태로 변환해서 넣어진다.
		   *  		ex) list.add(10.0) = list.add(new Double(10.0));
		   *  	  *이것을 Boxing이라고 한다.
		   *  			 unBoxing은 반대
		   *   
		   *  - .add를 사용한다.
		   *  - collections는 size
		   *  
		   */
		 
		 // list는 따로 제네릭을 등록시키지 않아서 Object이다.
		 List list = new ArrayList();
		 list.add(1);
		 list.add(new Double(10.0));
		 list.add(1);
		 list.add("asd");
		 System.out.println(list);
		 
		 // asList는 final로 add나 remove는 안되지만, set을 사용하여 재설정하는 것은 가능   ★★★★★★★
		 List aslist= Arrays.asList(1, 2, 3, 4, 5);
		 //aslist.add(6); // exception 발생.
		 aslist.set(0, 100);
		 System.out.println(aslist);
		 
		 
		 
		 System.out.println("\n\n=============================================================");
			
		 
		 /**
		  * 	2. Set
		  *  - 순서가 없고, 중복이 없음
		  *  - 값을 비교.
		  *  - .add를 사용한다.
		  */
		 Set set= new HashSet();
		 set.add(1);
		 set.add(new Double(10.0));
		 set.add(1);
		 set.add("asd");
		 System.out.println(set); // 중복인 1이 사라지고 순서가 없음.
		 
		 
		 
		 System.out.println("\n\n=============================================================");
			
		 
		 /**
		  * 	3. Map
		  *  - key, value로 이루어져 있다
		  *  - key는 중복되어선 안된다.
		  *  - 객체에 따라 순서가 있는게 있고 없는게 있다.
		  *  
		  *  - .put을 사용한다.
		  */
		 
		 Map map = new HashMap();
		 map.put("one", 1);
		 map.put("two", 10.0);
		 map.put("three", "abc");
		 map.put("one", 2);
		 
		 System.out.println(map.toString()); // 값이 재설정 됨.
		 
		 
		 
		 System.out.println("\n\n=============================================================");
			
		 /*
		  *  	for-each와 Iterator
		  *  - Collections의 요소들을 하나씩 꺼낼 때 사용하는 것.
		  *  
		  */
		 
		 // 1. for-each
		 System.out.println("for-each");
		 
		 System.out.println("list 요소");
		 for(Object index : list) {
			 System.out.print(index + " ");
		 }
		 System.out.println("\n");
		 
		 
		 System.out.println("set 요소");
		 for(Object index : set) {
			 System.out.print(index + " ");
		 }
		 System.out.println("\n");
		 
		 
		 System.out.println("Map 요소");
		 Set mapSet = map.keySet();
		 for(Object index : mapSet) {
			 System.out.print(index + " : "+  map.get(index)+" / " );
		 }
		 System.out.println("\n");
		 
		 
		 System.out.println("\n\n=============================================================");
			
		 // 2. Iterator
		 System.out.println("Iterator");
		 
		 System.out.println("list 요소");
		 Iterator iter= list.iterator();
		 while(iter.hasNext()) {
			 System.out.print(iter.next() + " ");
			 // iter.remove(); // list의 값이 바로 삭제 됨.
		 }
		 System.out.println("\n");
		 


		 System.out.println("set 요소");
		 iter= set.iterator();
		 while(iter.hasNext()) {
			 System.out.print(iter.next() + " ");
			 // iter.remove(); // list의 값이 바로 삭제 됨.
		 }
		 System.out.println("\n");
		 
		 


		 System.out.println("list 요소");
		 mapSet = map.keySet();
		  iter= mapSet.iterator();
		 while(iter.hasNext()) {
			 Object index = iter.next();
			 System.out.print(index + " : "+  map.get(index)+" / " );
			 // iter.remove(); // list의 값이 바로 삭제 됨.
		 }
		 System.out.println("\n");
		 
		 
		 
		 System.out.println("\n\n=============================================================");
			
		 
		 /**
		  *  	제네릭 Collections
		  *  - 기존까진 타입이 Object라 다양한 객체가 들어갔는데, 자료형을 제한함으로써, 오류를 줄이고 캐스팅의 문제를 줄이는 것을 말한다.
		  *  	ex) List<String> strList = new ArrayList<>();
		  *  
		  *  - strList는 이제 String 객체만 들어와야하는 List이다.
		  */
		 List<String> strList = new ArrayList<>();
		 strList.add("asd");
		// strList.add(1); // error
	}

}
