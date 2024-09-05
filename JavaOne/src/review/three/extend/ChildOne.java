package review.three.extend;

public class ChildOne extends Parent{
	
	private String name;
	/**
	 * 		super, super()
	 * 
	 *  1. super
	 *  - 부모 클래스를 의미하는걸로 필드나 메소드를 가져온다.
	 *  	ex) super.print()
	 *  
	 *  2. super()
	 *  - 부모클래스의 생성자를 의미하는 것으로 자식클래스의 생성자에 자동으로 추가된다.
	 *  - 만약 자식메소드에 생성자가 없다면 컴파일시 기본생성자를 생성하여 자동으로 추가.
	 *  - 부모클래스의 파라미터가 존재하는 생성자`만` 있다면, 자식클래스에 필수적으로 생성자를 생성하여 super(3)처럼 값을 할당해야한다.
	 *  - 기본생성자일 경우 생략이 this()와 마찬가지로 생략이 가능하다.
	 */
	ChildOne(){
		// super(); 가 생략됨
		System.out.println("ChildOne 생성자.");
	}
	
	/**
	 * 			오버라이딩
	 * - 부모클래스에서 작성된 메소드를 재정의.
	 * - 어노테이션을 붙이면 가독성이 좋아지지만 안붙여도 문제는 없음
	 * - 컴파일러가 자동으로 메소드명이 같고 파라미터도 같은 메소드를 찾으면 해당 메소드를 실행시키기에 문제없다.
	 * - private 메소드는 오버라이딩이 안됨.
	 * 
	 * - 오버라이딩 메소드의 접근 제어자는 부모클래스보다 크거나 같아야한다.
	 *  ex) Parent.aa() 가 default면  child.aa()는 public, protected, default여야함.
	 * - return 타입도 부모클래스보다 높으면 안됨.
	 *  ex) aa()의 return 타입이 String 인데 Child Object면 ( x 
	 *  )
	 */
	@Override // 붙여도 되고 안붙여도 되는데, 붙이는게 가독성에 좋음
	public void print(String name) {
		System.out.println();
		System.out.println("ChildOne클래스의 print ::::  "+ name);
	}
	
	public String getName() {
		return name;
	}
	
	public void childOneUniqueMethod(String msg){
		System.out.println(msg);
	}
	
	
	
	
	
	
	
	public static void main(String [] args) {
		
		
		// 1. 자식클래스에게 부모클래스 할당이 되는지.
		
		//ChildOne c1 = new Parent(); // 부모클래스를 할당받는 것은 안됨.
		
		
		
		// 2. 자식(부모)의 자식클래스.
		/**
		 *  먼저 ChildTwo의 생성자를 호출
		 *  super()호출하여 ChildOne의 생성자 호출
		 *  super()호출하여 Parent 생성자 호출.
		 */
		ChildOne c1 = new ChildTwo();
		c1.setName("변수명 c1 :::: 인스턴스 타입 new ChildTwo");
		c1.childOneUniqueMethod("변수명 c1 :::: 인스턴스 타입 new ChildTwo이며 자료형은 ChildOne");
	
		
		System.out.println();
		System.out.println("=============================================================");
		System.out.println();
		 
		
		
		// 3. 업 캐스케이팅.
		/**
		 *   	업 캐스케이팅
		 *   - 자식클래스의 객체를 만들고 부모클래스에 강제 형변환 시키는 것.
		 *     ex) ChildOne c1 = new ChildTwo();
		 *         Parent p1 = (Parent)c1; // 가능.
		 *         
		 *             == Parent p1 = new ChildOne(); 라는 의미와 비슷.
		 */
		 ChildOne c2 = new ChildTwo();
		 Parent p1 = (Parent)c2; // 가능.
		 //System.out.println(c2.name);
		 
		 //p1.childOneUniqueMethod(); // 안됨.
		 //System.out.println(p1.name); // p1은 Parent의 name을 가르킴. 근데 작업공간에 ChildOne이라서 못가져오는 것.
		 
		 p1.print("변수명 p1 :::: ChildOne c1을 업 캐스케이팅하여 print 메소드를 호출함");
		 
		
		 ChildOne c3 = new ChildOne();
		 Parent p2 = (Parent)c3; // 가능.
		
		 p2.setName("새로설정.");
		 p2.print("asd");  
		 //System.out.println(p2.name); // Parent의 name을 가르키는 것.
		 							  	// 원래 c3는 ChildOne타입이면서 parent의 자식클래스이기 때문에.
		 								// parent로 강제 형변환으로 업 캐스팅이 진행해도 문제가 없음.
		 								// 근데 Parent라고 해도 현재 작업하는 공간이 ChildOne이기 때문에 p2.name이 오류가 발생함.
	
	
		 
	}
	
	
}
