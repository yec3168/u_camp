package day3_abs;

public abstract class SupAbsTest {

	/**
	 * 		abstract
	 *  - 하나라도 abstract가 있으면 불안전한 클래스로 클래스에도 붙여줘야함.
	 *  - 그 반대도 비슷함 클래스에 abstract가 있으면 메소드에도 붙여줘야함.
	 *   	* but. 만약에 메소드 내부에 구현을 하면 abstract 안붙여도 됨.
	 *  - 형태를 잡아주는 틀을 만들어 줌.
	 *  - 생성자는 존재함.
	 *  - 필드나 내부 메소드도 구현 가능.
	 *  - private는 안됨. 
	 *  - default가 public
	 *  
	 *  - extends로 상속받기때문에 하나의 부모클래스만 상속가능함.
	 *  
	 */
	public abstract void one();
	
	public void two() {
		System.out.println("abstract에서 구현된 메소드");
	}

}
