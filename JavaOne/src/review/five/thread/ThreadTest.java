package review.five.thread;

public class ThreadTest {

	public static void main(String[] args) {
		
		Data d = new Data();
		
		Producer p1 = new Producer(d);
		Producer p2 = new Producer(d);

		Consumer c1 = new Consumer(d);
		Consumer c2 = new Consumer(d);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(c1);
		Thread t4 = new Thread(c2);
		
		/**
		 *   	메인 메소드
		 *   - 다른 쓰레드와 마찬가지로 쓰레드처럼 돌음
		 *   - 자신의 작업만 신경쓰기때문에 다른 쓰레드 작업이 끝나든 말든 상관 없음.
		 */
		System.out.println("Main 쓰레드 시작");
		
		/**
		 *  순서가 없고 어느 쓰레드가 진행하다가 멈추고 다른쓰레드가 진행. 
		 *  
		 *  - 쓰레드가 제대로 도는지 확인하기 위해서 main쓰레드를 1초 잠들게 만듬.
		 */
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		
		try {
			Thread.sleep(1000);
			System.out.println(d.list);
		}catch(Exception e) {
			System.out.println("1초간 잠듦");
		}
		
		
		
		System.out.println("Main 쓰레드 종료");
		
		// 이미 죽은 쓰레드들 시작하려고하면 안됨
//		t1.start();
		
		
		// 다시 쓰레드를 생성하고 start해야함.
		t1= new Thread(p1);
//		t1.start();
		
	}
	
}
