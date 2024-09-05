package day.four.generic;

import java.util.ArrayList;

public class OneTest {

	public static void main(String[] args) {
		
		/**
		 *   	One - two - three 
		 */
		
		
		//===================================================================================================================
		
		
		/**
		 *    - o라는 인스턴스의 T는 One임.
		 *    - One은 최상위 부모
		 *    
		 *     setObject( List< ? extends T> ) 
		 *       - ?가 올수 있는 건 T의 자식클래스와 자기 자신이다.
		 *     	1. T = One
		 *      2. ? = One, Two, Three	
		 *       ex) o.setObject( new ArrayList<Two>());
		 *     
		 *     setObject ( List< ? super T> )
		 *       - ?가 올 수 있는건 T의 부모 클래스와 자기 자신이다.
		 *       1. T = One
		 *       2. ? = One 
		 *     	

		 */
		//extends
		OneGeneric<One> o = new OneGeneric<>();
		o.setObjectExtends(new ArrayList<One>());			//가능	
		o.setObjectExtends(new ArrayList<Two>());			//가능
		o.setObjectExtends(new ArrayList<Three>());			//가능
		
		// super
		o.setObjectSuper(new ArrayList<One>()); 			//가능
		//o.setObjectSuper(new ArrayList<Two>());			//x 	super는 부모클래스. two는 one의 자식클래스임
		
		
		
		
		
		
		//===================================================================================================================
		
		
		
		
		
		/**
		 *    - t라는 인스턴스의 T는 Two임.
		 *    -	t는 One의 자식이며 Three의 부모.
		 *    
		 *    
		 *     setObject( List< ? extends T> ) 
		 *       - ?가 올수 있는 건 T의 자식클래스와 자기 자신이다.
		 *     	1. T = Two
		 *      2. ? = Two, Three	
		 *       ex) o.setObject( new ArrayList<Three>());
		 *     
		 *     setObject ( List< ? super T> )
		 *       - ?가 올 수 있는건 T의 부모 클래스와 자기 자신이다.
		 *       1. T = Two
		 *       2. ? = One, Two
		 *       
		 *       
		 */
		OneGeneric<Two> t = new OneGeneric<>();
		
		// extends
		//t.setObjectExtends(new ArrayList<One>());			//x	
		t.setObjectExtends(new ArrayList<Two>());			//가능
		t.setObjectExtends(new ArrayList<Three>());			//가능
		
		// super
		t.setObjectSuper(new ArrayList<One>()); 			//가능
		t.setObjectSuper(new ArrayList<Two>());				//x 	super는 부모클래스. two는 one의 자식클래스임
		//t.setObjectSuper(new ArrayList<Three>());			//x

		
		
		
		
		//===================================================================================================================
		
		
		
		
		/**
		 * 		static 메소드 사용.
		 *  - static이라고 선언된 메소드는 자료형을 꼭 지정해줘야한다.
		 *  - 현재 OneGeneric클래스의 print 메소드는 리턴 타입이 T이고 파라미터도 T임.
		 *  	ex) String str = OneGeneric.print("String 타입");
		 *  		** T = String임.
		 *  
		 *   
		 */
		String str = OneGeneric.print("String 타입");
		System.out.println(str);
		
		
		
		
		//===================================================================================================================
		
		
		/**
		 *   	메소드 사용 주의사항
		 *   - 인스턴스를 생성하고 인스턴스에서 제공하는 메소드를 사용하면 오류가 발생할 수 있음.
		 *    ex)  o2.method("hello");
		 *    		
		 *    		public <T> void method(T t){  
		 *    			t.length() // error
		 *    		}
		 *   - t에는 int가 올 수 있기 때문에 error
		 */
		OneGeneric<One> o2 = new OneGeneric<>();
		o2.method("hello"); 
		
		
		
		// =====================================================================================================================
		
		/**
		 *  	객체 생성 시 제네릭 타입을 지정하지 않으면 해당 객체의 최상위 객체를 지정.
		 *  	
		 *  	ex ) class A{}
					 class B extends A{}
					 class C extends B{}
					 
					 class D <T extends B>{
 					 private T t;
					 public T get() {
					 	return t;
					 }
					 public void set(T t) {
					 	this.t = t;
					 }
				}
				
				D d = new D(); == D<B> d = new D<>();

		 */
		
		
		
		// ppt 22확인
		
	}

}
