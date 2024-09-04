package day.three;

public class ObjectTest //extends Object가 되어 있음.
{
	private int data ;
	
	public void setData(int data) {
		this.data =data;
	}
	
	@Override
	public boolean equals(Object obj) { 	// Object obj = new ObjectTest();
//		// TODO Auto-generated method stub
//		return super.equals(obj);
		
		if(obj instanceof ObjectTest) {
			ObjectTest other = (ObjectTest)obj; // 다운캐스팅 
			if(this.data == other.data) // this는  equals 앞에 있던 객체.
				return true;
		}
		return false;
	}
	

	public static void main(String[] args) {
		
		ObjectTest t = new ObjectTest();
		t.setData(10);
		
		ObjectTest t2 = new ObjectTest();
		t2.setData(10);
		
		String s = new String("asd");
		String s2 = new String("asd");
		
		System.out.println(t.equals(t2)); // Object는 equals는 주소비교 -> 오버라이딩 함.
		System.out.println(s.equals(s2)); // String만 값 비교
		

	}


	

}
