package review.three.extend;


/**
 *  	부모클래스
 *  Parent - ChildOne - ChildTwo 
 *  
 *  
 *  	★★★★상속★★★★★		
 *  - extends의 명령어를 사용한다.
 *  - 하나의 객체만 상속받을 수 있다. ( 단일상속 )
 *  	ex) extends Parent1, Parent2 ( x )
 *  
 *  - 상속받을 때, 필드, 메소드, 이너클래스 등 자식클래스에 할당한다.
 *  - 'private' 와 생성자는 상속받지 않는다.
 *     	reason) private는 자바의 은닉 특징때문에 할당 받지 못한다.
 *              생성자는 해당 클래스의 이름으로 짓기 때문에 다른 클래스 입장에선 메소드로 보이기 때문.
 *              
 *     		생성방법		
 *  - [자료형] 변수명 = new 인스턴스타입();          -> new 인스턴스타입을 [자료형]에 할당받는다.
 *  - 자료형 > 인스턴스 
 *     ex) Parent p = new Parent(); ( o )
 *         Parent p = new ChildOne();  ( o )
 *         Child c = new Parent(); ( x )
 *         
 *      ** 쉽게 생각하면 int에서 long으로 캐스케이팅이 되지만 long에서 int를 캐스케이팅하면 자료의 손실이 일어나는 것처럼
 *         자신보다 상위객체를 할당 받는건 불가능하다.
 *    
 */

public class Parent {
	
	private String name;
	
	/**
	 * 		생성자
	 *  - 생성자는 상속하지 않는다.
	 */
	Parent(){
		System.out.println("Parent 생성자.");
	}
	
	
	/**
	 *  부모클래스의 메소드로 상속받은 자식클래스들은 모두 사용가능하다. ( 단. 접근제어자에 영향을 받음)
	 *  메소드의 기본 접근제어자는 default이다.
	 */
	public void print(String name) {
		System.out.println("Parent클래스의 print ::::  "+ name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public static void main(String [] args) {
			/**
			 *  	부모클래스 입장에서의 객체 생성.
			 *  - 부모클래스는 자식들의 인스턴스를 할당 받는 것이 가능하다.
			 *    ex) Parent p1 = new Parent() ( o )
			 *        Parent p2 = new ChildOne();  ( o )
			 *        Parent p3 = new ChildTwo();  ( o )
			 *  
			 *  
			 *  	다운 캐스케이팅
			 *  - 부모클래스 자료형으로 선언된 객체는 할당받은 인스턴스의 자료형으로 캐스케이팅이 가능하다.
			 *    ex ) ChildOne c1 = (ChildOne) p2  ( o )
			 *         ChildTwo c2 = (ChildTwo) p3  ( o )
			 *         ChildTwo c3 = (ChildTwo) p2 ( x ) // 할당 받지 못해서 다운케이팅이 안됨.
			 *  
			 *  - 이렇게 선언된 c1, c2같은 객체는 Parent의 메소드는 사용할수 있고, ChildOne의 메소드도 사용가능
			 *   reason) 원래 p2는 Parent로 선언되어있지만 ChildOne의 인스턴스를 할당받음.
			 *           현재상태에서 오버라이딩 된 메소드를 제외한 다른 메소드는 사용불가능
			 *           강제 형변환을 통해 해당메소드를 사용할 수 있게되는 것.
			 * 
			 * 		
			 * 		부모클래스(Parent)에게 자식 인스턴스(ChildOne)를 할당
			 *  - Parent p2 = new ChildOne(); 같이 할당 받는다면
			 *  - p2는 Parent부터 시작하기 때문에 Parent의 메소드는 전부 사용 가능 하나, 
			 *     ChildOne에 오버라이딩 된 메소드가 존재한다면 해당 메소드를 대신 실행한다.
			 *  - ChildOne의 생성된 고유 메소드(오버라이딩한 메소드 x)는 실행이 안된다.
			 */
		
		
		// 1. 부모 클래스 부모 인스턴스  = 자기자신을 만든다.
		 Parent p1 = new Parent();
		 p1.setName("변수명 p1 :::: 인스턴스 타입 new Parent");
		 p1.print(p1.name);
		 
		 
		 
		 System.out.println();
		 System.out.println("=============================================================");
		 System.out.println();
		
		 
		 
		// 2. 부모 클래스의 자식 인스턴스
		// 만약 자식클래스의 사용하려는 메소드가 오버라이딩 되어있으면 해당 메소드를 사용한다.
		 Parent p2 = new ChildOne();
		 /**
		  * 먼저. setName()을 ChildOne에서 오버라이딩했는지 확인.
		  * 안했으니 Parent의 setName()을 실행.
		  * p2.name은 Parent의 name임.
		  * childOne의 name도 가지곤 있음. 인스턴스를 할당받았기 때문에. 알고만 있음
		  */
		 p2.setName("변수명 p2 :::: 인스턴스 타입 new ChildOne"); // Parent의 name임.
		 p2.print(p2.name); // print는 ChildOne에 오버라이딩된 print메소드가 사용됨.
		 
		 //p2.childOneUniqueMethod() // 오버라이딩 한 메소드가 아닌 ChildOne의 고유 메소드라 실행 안됨.
		 
		 
		 
		 System.out.println();
		 System.out.println("=============================================================");
		 System.out.println();
		 
		 
		 
		 
		 // 3. 강제케스팅된 클래스 다운캐스팅
		 Parent p3 = new ChildOne();
		 p3.setName("변수명 p3 :::: 인스턴스 타입 new ChildOne");
		 p3.print(p3.name);
		 System.out.println();
		 
		 
		 ChildOne c1 = (ChildOne)p3;
		 //c1.은 자료형이 ChildOne이기 때문에 Parent에 private로 선언된 name을 가져올 수 없음.
		 //c1.print(c1.name);  //c1.name은 ChildOne의 name임.
		 
		 c1.setName("변수명 c1 :::: 강제 케스팅"); 	// 부모로부터 상속받은 메소드이기 때문에 사용가능하나 name은 parent에 있는 private String name이 호출.
		 										// 마찬가지로 setName이 Parent에 정의되어 있기때문에 ChildOne의 name에 저장되지 않는다.
		 
		 c1.print(c1.getName());		// 값이 저장안되서 null임.	값을 넣고 싶으면 ChildOne에서 재정의해야함.	
		 
		 // 자료형이 ChildOne이기 때문에 실행이 가능함.
		 c1.childOneUniqueMethod("변수명 c1 :::: Parent p3을 캐스팅하여 생긴 객체");
		 
		 
		 
		 
		 System.out.println();
		 System.out.println("=============================================================");
		 System.out.println();
		 
		 
		 
		 
		 
		 // 4. A a = new C();
		 Parent p4 = new ChildTwo();
		 //p4.childTwoUniqueMethod(); // 안됨.
		 ChildTwo t2 = (ChildTwo)p4; // 가능
		 t2.childTwoUniqueMethod("변수명 p4를 강제형변환 시킨 t2 :::: ");
	}
}
