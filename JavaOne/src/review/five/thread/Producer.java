package review.five.thread;

import java.util.ArrayList;
import java.util.List;

/**
 *  Threadㄹ를 상속받아서 진행해도 되지만, Runnable을 사용하는 개발자끼리의 약속.
 */
public class Producer implements Runnable{
	
	Data data;
	
	Producer(Data data){
		this.data = data;
	}
	
	/**
	 * Runnable 인터페이스의 Run 메소드를 오버라이딩
	 *
	 */
	@Override
	public void run() {
		
		
//		for(int i = 0; i < 10; i ++) {
//			data.plusData((int)(Math.random()*45)+1) ;
//		}
		
		
		for(int i =0 ; i <10; i++) {
			int d = (int)(Math.random()*45)+1;
			data.plusData(d) ;
			
			System.out.println("꺼내온 데이터 : " +  d );
		}
	}

}
