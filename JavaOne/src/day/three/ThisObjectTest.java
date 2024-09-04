package day.three;

public class ThisObjectTest {
		/**
		 *  	 은닉
		 *  - 다른 클래스가 접근 못하게 은닉함.
		 *  
		 *   	this
		 *  - 필드를 칭함.
		 *  - this() 혹은 this(n), this(n, str) 등 호출하면 해당 파라미터를 요구하는 생성자를 호출함.
		 *  - 반드시 무조건 첫번째 라인에 적어야한다.													★★★★★★★★★★★★★★★★★★★★★
		 *  - this도 래퍼런스
		 *  - 단순히 같은 클래스 내에서 메소드를 호출해도 this가 있는데 생략해도 가능함.
		 *  		ex) getAge(); -> this.getAge();
		 *  - this는 인스턴스 내 필드나 메소드를 참조함.
		 *  
		 *  
		 *  - this.name ; 	// 필드에 접근
		 *  - this()   		// 생성자에 접근., 생성자 내부에서만 호출 가능.							★★★★★★★★★★★★★★★★★★★★★
		 */
		private int age;
		private String name;
		private String addr;
		

		/**
		 * getter setter 호출
		 *  우클릭 -> source -> generate getter and setter
		 */
		
		public ThisObjectTest(int n) {
			age = n;
		}
		public ThisObjectTest(int n, String name) {
			//age = n;
			this(n);  // ThisObjectTest(int n)을 호출.
			this.name = name;
		}
		public ThisObjectTest(int n, String name, String addr) {
			//age = n;
			//this.name = name;   
					//ThisObjectTest(int n, String name)을 호출.
			this.addr = addr;
			
			
			//this(n, name); // 첫 번째 줄에 호출하지 않아서 오류가 발생함.
		}
		
		
		
	
		
	

}
