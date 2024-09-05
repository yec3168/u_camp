package review.three.abstracts;

/**
 *  	abstract
 *  - 추상클래스, 추상메소드라고 부름.
 *  - 하나라도 추상메소드가 존재하면, 클래스에도 abstract를 꼭 붙여줘야함.
 *  - 그 반대도 비슷함 클래스에 abstract가 있으면 메소드에도 붙여줘야함.
 *   	* but. 만약에 메소드 내부에 구현을 하면 abstract 안붙여도 됨.
 *  - 인터페이스와 마찬가지로 불안전한 메소드를 정의하는 것. (구현되지 않아서 상속받은 클래스에서 구현해야함)
 *  
 *  - 생성자와 필드, 내부 메소드 구현가능.
 *  - default가 public이며, private는 안된다.
 *  - class이기 때문에 하나의 클래스만 상속이 가능하다. 
 *  	참고) 인터페이스는 implements로 여러 개 가능.
 *  
 */
public abstract class AbsAnimal {
	
	AbsAnimal(){
		System.out.println("AbsAnimal의 생성자입니다.");
	}
	
	/**
	 *  	불안전한 메소드
	 *  - 상속한 클래스에 세부적인 내용을 구현해줘야하는 메소드.
	 *  - 클래스에 abstract가 붙었기에 불안전한 메소드에도 abstract를 붙여줘야함.
	 *  - default가 public임.
	 */
	abstract void cry();
	
	
	/**
	 * 		구현된 메소드
	 *  - 구현된 메소드라 상속받은 클래스에서 재정의를 해도 되고 안해도 됨.
	 */
	public void eat() {
		System.out.println("AbsOne에서 구현 된 메소드." + " 냠냠");
		
	}
}
