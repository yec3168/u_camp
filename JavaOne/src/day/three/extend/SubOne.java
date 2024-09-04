package day.three.extend;

public class SubOne extends Super{

	
	SubOne(){
		//super()가 생략.
		System.out.println("SubOne의 생성자 ::::");
	}
	
	
	/**
	 * Super의 print를 오버라이딩
	 */
	
	void print() {
		System.out.println("SubOne ::::" );
	}
	
	
	void unique_method() {
		System.out.println("SubOne에만 존재하는 unique_mehtod");
	}
	
	
	public static void main(String [] args) {
		
	}
}
