package day.four;

public class StaticTest {

	/**
	 *  		static
	 *   - new를 사용해서 객체를 생성하지 않아도 static영역 메모리에 적재한다.
	 *     ex) Parent.printAge();
	 *   - 메모리의 로딩은 한 번만 한다.
	 *   - 한 번 올라간 static의 값은 모든 인스턴스(서로 다른 객체)에서 공유된다. ( but. 접근제어자를 따름)
	 *   - 필드, 메소드 등 붙여도 된다.
	 *   
	 *   - static은 JVM의 메소드 영역에 저장된다.
	 *   - heap 영역에 저장되는 것이 아님.
	 *   - 객체를 생성할 때, 인스턴스 필드는 heap 영역에 생성되지만, static에 선언된 필드는 메소드영역(static영역)에 저장.
	 *   
	 */
	
	/**
	 * 		(일반)필드, 메소드
	 *  - 객체를 생성하면 해당 객체만 사용이 가능함.
	 *  - default 접근 제어자 default
	 *  - 값을 지정안했기 때문에 0으로 초기화.
	 *  
	 *  	(static)필드, 메소드
	 *  - default 접근제어자, 처음 만들 때 한 번 로딩되고 static 영역에 생성.
	 *  - 객체를 생성하면 필드 또한 heap영역에 만들어지는데, static으로 선언된 것은 static영역에 필드나 메소드를 가르킴.
	 *  
	 *   ** 그러면 따로 heap영역에 static필드를 저장하는 공간이 존재하냐?
	 *     - 아니다. 저장공간은 존재하지않음.
	 *  - static으로 선언된 메소드나 필드는 무조건 static이 붙은거 끼리만 사용이 가능하다.
	 *  - 인스턴스안에 선언된 일반 필드는 메모리에 적재되었다고 판단하기 어렵기 때문에 사용이 불가능.
	 */
	int num;
	static int count;
	static String zero;
	
	public void getNum() {
		System.out.println("일반 메소드  ::::: "+num);
		System.out.println("일반 메소드  ::::: "+count);
		
		// count, num는 사용가능함.
			// reason) 객체를 생성한다고 하면 이미 static영역은 한 번 로딩 되었기 때문에 count나 num은 둘 다 메모리에 존재함.
	}
	
	public static void getCount() {
		System.out.println("static 메소드  ::::: "+count);
		
		//System.out.println("static 메소드  ::::: "+num);
		// num은 안됨.
			// reason) 가장 먼저 static이 로딩 되었기 때문에 아직 인스턴스 안에 존재하는 num이 적재될 거라는 보장이 안됨.
		    //         그렇기 때문에 static 영역에 존재하는 필드나 메소드만 사용이 가능하다.
	}
	
	static {
		// static으로 선언된 값을 초기화 해주는 블럭.
		count = 0;
		zero = "0";
	}	
	
	
	
	
	
	public static void main(String[] args) {
		
		/**
		 *  static Test
		 */
		System.out.println("st 객체 생성");
		StaticTest st = new StaticTest();
		st.num++;
		st.count++;
		
		System.out.println("static test ::::" +  st.num + " "+ st.count);
		
		
		System.out.println();
		
		
		System.out.println("st2 객체 생성");
		StaticTest st2 = new StaticTest();
		st2.num++;
		st2.count++;
		System.out.println("static test ::::" +  st2.num + " "+ st2.count);   // count는 모든 인스턴스에서 공유함.
		
		
		
		 System.out.println();
		 System.out.println("=============================================================");
		 System.out.println();
		 
		 //=============================================================================================================================================//

		 
	
	
	}

}
