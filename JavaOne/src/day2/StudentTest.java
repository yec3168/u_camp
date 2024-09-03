package day2;

public class StudentTest {
	/**
	 * 인스턴스 : 실제로 메모리에 적재되어 사용돠는 객체
	 * 클래스 : 객체를 만들기위한 틀
	 *
	 * 추상화 : 특징을 뽑아 추출하는 작업.
	 *
	 */
	public static void main(String[] args) {
		
		Student s = new Student("기본생성자", 22); // 객체를 new를 통해 생성했기때문에 메모리상에 존재하여 이제부터 '인스턴스'라고 불린다.
		
				// 필드 접근.
		System.out.println(s.name);
		System.out.println(s.age);
		//System.out.println(s.address);  // address는 private이기 때문에 접근할 수 없음. 객체를 생성하더라도 private은 Stduent클래스 안에서 사용가능하다.
		
		
		
				// 메소드(행동) 접근
		s.sleep();
		System.out.println(s.getAge()); // public으로 선언된 메소드
		
		/**
		 * 메소드 static이기 때문에 객체 생성 없이 사용 가능.
		 * 그리고 static메소드 안에서 필드를 사용하려면 필드 또한 static으로 선언.
		 * 
		 * static으로 선언된 필드는 private여도 직접적인 접근은 불가능함.
		 */
		System.out.println(Student.getWeight()); 
		
		
		s.getRegion(); //메소드 내 변수(지역변수)접근
		
		
	}	

}
