package day.three;

/**
 * 		상속
 *  - 부모 클래스의 필드, 메소드, 이너클래스 등 자식클래스에 포함.
 *  - 생성자는 상속 되지 않는다. 															★★★★★★★★★★★★★★★★★★★★★
 *  - 자바는 단일 상속만 가능.
 *  
 *   *UML(Unified Modeling language) :  시스템을 모델로 표현해주는 대표적인 모델링 언어	
 *  
 *   장점
 *   1. 중복을 제거함.
 *   2. 다형적 표현이 가능함.
 *   
 *   
 *   	명령어
 *    extends
 *    - 다중 상속이 불가능
 *    		ex) extends 부모클래스1, 부모클래스2   -> (x)
 *    
 *    ** 주의.  implement는 클래스와 인터페이스간의 관계. 즉. 인터페이스를 클래스에서 구현하는 것.
 *   
 *   
 *  	 상속
 *  - 현재 extends를 사용하여 SuperTest를 상속받는 상태.
 *  - 그러면 SuperTest에 있는 메소드, 필드 등을 사용가능하다.
 */

public class SubTest extends SuperTest{
	
	/**
	 * 	- 상속을 받더라도 부모클래스의 생성자는 호출을 하지 않는다.
	 *    reason) 1. 일단 생성자는 클래스 이름과 동일 해야하는데 다름
	 *    		  2. 그렇기에 생성자는 메소드로 인식하는데 return 타입이 없기때문에 상속받지 않는다.
	 *    
	 *  - 따로 super() 메소드를 호출하여 부모클래스의 생성자를 호출해야함. 따로 호출하지 않아도 자동으로 추가된다.
	 *  
	 *   	중요
	 *   - 부모클래스의 생성자가 여러 개면 자식클래스에서 인자를 넣어 원하는 생성자를 호출 할 수 있다.
	 *   - 만약 따로 super을 통해 명시하지 않으면 부모클래스의 기본생성자가 자동으로 생성되어 호출된다.
	 */
	
	SubTest(){
		super(); // 보모클래스의 생성자를 호출., 없더라도 자동으로 추가
		System.out.println("SubTest :::: 생성자"); 
	}
	
	public void zzz() {
		System.out.println("자식 클래스(sub)의 zzz 메소드"); 
	}
	
	
	/**
	 * 부모클래스의 메소드를 상속받아 자식클래스에서 재정의 한 것.
	 * 
	 *  접근제어자는 부모클래스보다 크거나 같아야함.
	 *   ex) 부모클래스의 접근제어자가 default라면, 자식클래스는 default 혹은 public protected가 되어야함.
	 *   
	 *  return 타입도 부모클래스보다 높으면 안됨
	 *   ex) 부모가 int인데 자식이 Object이면 안됨.
	 *   
	 *  
	 *  대신 private로 선언된 메소드는 자식클래스에서 overriding 못한다.
	 *   
	 */
	@Override // 붙여도 되고 안붙여도 됨. 붙이면 더 좋음.
	public void aaa() {
		
		//super.aaa(); // 부모클래스의 aaa
		System.out.println("super의 aaa 메소드를 오버라이딩하여 작성하는 메소드입니다.");
	}

	public static void main(String [] args) {
		SubTest sub = new SubTest();
		sub.zzz(); //자식클래스 내부 메소드
		sub.aaa(); //부모클래스 내부 메소드
		
		
	}
}
