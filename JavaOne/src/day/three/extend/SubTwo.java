package day.three.extend;

public class SubTwo extends SubOne{
	
	
	SubTwo(){
		//super()가 생략. -> SubOwn생성자 호출.
		System.out.println("SubTwo의 생성자 ::::");
	}
	

	/**
	 * SubOwn의 print를 오버라이딩
	 */
	
	void print() {
		System.out.println("SubTwo ::::" );
	}
	
	
	void unique_method2() {
		System.out.println("SubTwo에만 존재하는 unique_method2");
	}
	
	
	public static void main(String [] args) {
			
	}
}
