package review.three.extend;

public class ChildTwo extends ChildOne{

	ChildTwo(){
		// super(); 가 생략됨
		System.out.println("ChildTwo 생성자.");
		
		
	}
	/**
	 * ChildTwo의 print를 오버라이딩 한 것.
	 */
	@Override
	public void print(String name) {
		super.print(name);
	}
	
	public void childTwoUniqueMethod(String msg){
		System.out.println(msg);
	}
}
