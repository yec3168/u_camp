package day.four;


/**
 * final로 선언된 클래스는 상속이 안된다
 */
final class FinalClassTest{
	
}
public class FinalTest //extends FinalClassTest
{

	/**
	 *  	final
	 *  - 값을 변경하지 못하게 하는 것.
	 *  - 필드, 메소드 지역변수, 클래스에 붙일 수 있음.
	 *    ** 메소드에 사용하는 경우, 오버라이딩이 안된다.
	 *    ** class에 사용하는 경우, 자식클래스를 만들 수 없다.
	 *    ** 변수에 사용하는 경우, 상수가 된다.
	 *  - final로 붙은 상수는 대문자로 선언하고 '_'로 구분한다.  // 권고임. 안해도 됨.
	 *    ex) final String DEP_PREFIX = "DEP";
	 *    
	 *  - final은 보통 메모리영역에 저장되나, 인스턴스 final은 heap 영역에 저장된다.
	 */
	
	/**		
	 * 		필드
	 * - 필드는 값을 지정을 안한다면(Blank fianl), 생성자에서 꼭 지정해야함.
	 * - Blank final은 생성자에서만 지정가능.
	 * - 값을 변경 할 수 없음.
	 */
	final int ONE = 10;  // 상수
	final int TWO;  // 명시적으로 값을 지정안한다면. ( Blank final)
	 				// 필드에서 지정을 안하면 생성자에서 꼭 지정을 해야함. 
	
	FinalTest(){
		TWO = 20;
	}
	
	
	/**
	 * final로 선언된 메소드는 상속을 하더라도 오버라이딩이 안된다.
	 */
	public final void print() {
		System.out.println("final로 선언된 메소드");
	}
	
	public static void main(String[] args) {
		
		FinalTest ft = new FinalTest();
		//ft.ONE = 100;  // final이라서 변경이 x
		ft.print();
	}

}
