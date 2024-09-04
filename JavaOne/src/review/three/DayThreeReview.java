package review.three;

public class DayThreeReview {
	
	/**
	 * 		this
	 *  - this는 래퍼런스 이다.
	 *  - 메소드나 필드를 참조한다.
	 *  - 보통 생략이 가능하나, 파라미터의 변수명과 필드의 변수명이 같을 경우 구분하기 위해서 this를 붙여준다.
	 *     ex) getAge = this.getAge()
	 *     	   
	 *     	   int age; //필드
	 *     	   public void setAge(int age){
	 *     			this.age = age // 붙여줘야하는 경우.
	 *     		}
	 *   - this는 가장 가까운것부터 찾는다.
	 *         
	 *  
	 *  	this()
	 *  - 생성자를 가르킴
	 *  - 반드시 첫 번째 줄에 작성해야한다.
	 *  - 생성자 내부에서만 호출이 가능하며, 생략이 가능하다.					★★★★★
	 *      But. 해당 클래스내 개발자가 작성한 파라미터가 필요한 생성자가 있을 경우, this(n)처럼 적어줘야한다. 
	 */
	
	
	private String name;
	private int age;
	
	DayThreeReview(){
		System.out.println("생성자 테스트");
	}
	DayThreeReview(String name){
		this.name = name;
	}
	DayThreeReview(String name, int age){
		this(name);     // 생성자를 호출.
		this.age = age; // 필드에 접근
	}
	
	
	
	 //---------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	public void setAge(int age) {
		//이 메소드에는 생성자를 호출하지 않음.
		
		this.age = age; // 필드에 접근
	}

	
	/**
	 * 		오버라이딩
	 *  - 부모클래스에 작성된 메소드를 자식클래스에서 재정의 하는 것을 말한다.
	 *  - 인터페이스나 추상클래스에 작성된 불확실한 메소드를 자식클래스에서 구현하는 것.
	 *  - 상속에서 더 자세히 설명.
	 * 
	 * 		오버로딩
	 *  - 오버로딩은 메소드명은 같으나, 파라미터가 다른 경우를 말함.
	 *  - 부모클래스에서 print()라는 메소드가 있고 자식클래스에 print(int a)가 있으면 자식클래스 메소드도 오버로딩.
	 * 
	 *  ======================================================================================
	 * 
	 * 		a instanceOf b
	 * 	- a 와 b의 객체가 같은지 확인해줌.
	 *  - 해당 자료형과 new instance로 다운캐스팅이 되는지까지 확인.
	 *    ex) Parent p = new Child();
	 *    
	 *       p instanceof Parent  	//true
	 *       p instanceof Child		//true
	 *       
	 *  
	 *  =======================================================================================
	 *       
	 *       Object
	 *   - 객체들의 최 상위 부모
	 *   - 모든 클래스는 Object를 상속받고 있다.
	 *   - Object.equals는 원래 데이터 값이 같은지 확인하기 위해서 만들어졌지만 지금은 주소값이 같은지 확인한다.
	 *   
	 *   	
	 *   	Object.equals(Object o)
	 *   - 기존의 equals는 원래 값을 비교하려는 목적으로 작성되었으나 현재는 주소값을 비교하는 목적으로 사용됨.
	 */
	@Override
	public boolean equals(Object obj) {
		
		/**
		 *  	super
		 *  - 부모클래스를 호출한다는 의미
		 *  - this가 자기 자신을 의미한다면 super는 부모.
		 */
		//return super.equals(obj);
		
		/**
		 *  instanceOof
		 */
		if(obj instanceof DayThreeReview) {
			DayThreeReview  castingObject = (DayThreeReview)obj;
			if(this.age == castingObject.age)
				return true;
		}
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		// Object의 equals 테스트
		DayThreeReview d1 = new DayThreeReview();
		d1.setAge(10);
		
		DayThreeReview d2 = new DayThreeReview();
		d2.setAge(10);
		
		System.out.println("d1.equals(d2) :::: " + d1.equals(d2));  //true 오버라이딩해서 사용함.
		
		
		// 원래 equals
		
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println("s1.equals(s2) :::: " + s1.equals(s2));  // true 해당 메소드는 값을 비교.
	}

}
