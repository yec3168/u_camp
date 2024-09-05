package day.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionTest {
	
	
	/**
	 *  Collections
	 *  - 길이가 정해져있지 않고 동적인 길이를 가짐.
	 *  - 객체의 집합( 객체만 저장할 수 있음, 기본자료형은 안됨.)
	 *  
	 * 		1. List ( ArrayList, LinkedList, vector, Stack )
	 *  - 순서가 있고, 중복을 허용
	 *  - 
	 *  
	 *  	2. set ( HashSet )
	 *  - 집합, 순서가 없고, 중복을 허용하지 않음.
	 *  
	 *  
	 *  	3. Map ( HashMap, HashTable, Properties )
	 *  - key, value로 이루어짐.
	 *  - key는 중복이 안됨.
	 *  -
	 */
	public static void main(String[] args) {
		
		/**
		 * 		 List
		 *  - 객체만 저장가능함.
		 *  - 중복가능, 순서가 있음.
		 *  - 정수나, 실수로 넣는다고 해도 객체로 변환해서 add 해줌.
		 *    ex) list.add(1);  == list.add(new Integer(1));   -> Boxing이라고 함.
		 */
		List list = new ArrayList();
		list.add("asd");
		list.add(new String("asd"));
		list.add("asd");
		list.add(new Integer(1));
		System.out.println(list.toString());
		
		// 1. 리스트의 index에 접근하여 한 개씩 출력.
		for(int i =0;  i< list.size(); i++) {
			System.out.print(list.get(i)+ " ");
		}
		
		System.out.println("\n\nfor-each");
		// 2. for-each
		for(Object index : list) {
			System.out.print(index+" ");
		}
		
		
		System.out.println("\n\n asList 테스트");
		/**
		 *  	asList
		 *  - add, remove는 안됨
		 *  - set하여 재설정하는 것은 가능. 
		 */
		List<Object> asList = Arrays.asList(1, 2, 3, 4, 5);
		//asList.add(5); // asList로 만들면 final이라서 불변.
		System.out.println(asList.toString());
		
		
		
		 System.out.println();
		 System.out.println("=============================================================");
		 System.out.println();
		 
		 
		 
		 //=============================================================================================================================================//
		 
		 
		 
		 
		
		/**
		 * 		Set
		 *  - 객체만 저장
		 *  - 중복x 순서 x
		 *  - 값을 비교함. 주소가 아님.
		 */
		
		Set set = new HashSet();
		set.add("asd");
		set.add(new String("asd"));
		set.add("asd");
		set.add(new Integer(1));
		
		System.out.println(set.toString());
		
		// 1. Iterrator 사용
		Iterator iter = set.iterator(); // set의 자원을 가져오기 위해사용. 
		// hasNext() == false면 종료
		while(iter.hasNext()) {
			System.out.print(iter.next()+"  ");
		}
		
		System.out.println("\n\n set ");
		//2. for-each
		for(Object obj : set) {
			System.out.print(obj + " ");
		}
		
		
		
		System.out.println();
		System.out.println("=============================================================");
		System.out.println();
		 
		
		
		
		
		 //=============================================================================================================================================//
		
		
		/**
		 * 		Map
		 * - 객체만 저장
		 * - key의 값은 중복이 x
		 * - 순서는 사용하는 인스턴스(객체)에따라 다름.
		 * - 일단 HashMap은 없음.
		 */
		
		// 1. iterator
		Map map = new HashMap();
		map.put("string", "asd");
		map.put("string", "asd");
		map.put("string", "eas"); //값들이 재설정.
		map.put("first", new String("asd") );
		map.put("second", new StringBuffer("asd"));
		
		System.out.println(map.toString());
		
		// 1. keyset을 가져옴
		Set mapSet = map.keySet();
		iter = mapSet.iterator();
		while(iter.hasNext()) {
			Object obj = iter.next();
			System.out.print(obj +" "+ map.get(obj) + "/ ");
		}
		
		
		// 2. for-each  
		mapSet= map.keySet();
		System.out.println("\n\n set ");
		//2. for-each
		for(Object obj : mapSet) {
			System.out.print(obj + " " + map.get(obj)+ "/ ");
		}
		
		
	}

}
