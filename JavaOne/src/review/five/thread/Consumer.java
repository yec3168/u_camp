package review.five.thread;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable{
	
	Data data ;
	
	Consumer(Data data){
		this.data = data;
	}
	
	/**
	 * Runnable 인터페이스의 Run 메소드를 오버라이딩
	 */
	@Override
	public  void run() {
		
		for(int i = 0; i < 10; i++) {
			try {
				System.out.println(" 입력 : " +  data.removeData() );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
