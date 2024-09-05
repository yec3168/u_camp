package day.four.generic;

import java.util.List;

/**
 *  		Generic
 *  - 제네릭 T에는 어떠한 객체든 들어올 수 있음.
 *  - 클래스 변수 명 <T>를 붙여줌
 *  
 */
public class GenericOf <T>{

	private T t;
	
	public GenericOf() {
		
	}
	
	public GenericOf(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}
	
	public void setT(T t) {
		this.t = t;
	}
	
	  /**
	   * static으로 선언된 T는 호출할 때 T가 무슨 타입인지 모른다.
	   *  GenericOf.getObject 해도 T가 뭔지 모름.
	   */
	public static <T> T getObject(T t){
		return t;
	}
	
	
	/**
	 *  	와일드 카드
	 *  - ?는 T이거나 T의 자식들
	 *  
	 *  
	 *   List < ? extends T>
	 *    One <- two <- three
	 *  -  ex) T가 Two일 때, ? 는 Two, three
	 *  	   
	 */
	public void setObject(List<? extends T> t) {
		if( t != null && t.size() >0 )
			this.t = t.get(0);
	}

	/**
	 *  	와일드 카드
	 *  - ?는 T이거나 T의 부모
	 *  
	 *  
	 *   List < ? super T>
	 *    One <- two <- three
	 *  -  ex) T가 Two일 때, ? 는 Two, One
	 *  	   
	 */
	public void setObject2(List<? super T> t) {
		
	}
}
