package day.five.thread;

public class MyThread implements Runnable{

	/**
	 *  		프로레스 
	 *   - 프로세스는 실행되고 있는 프로그램.
	 *   - 각각 독립적인 메모리 공간을 가지고 있음.
	 *   - 프로세스간의 통신은 상대적으로 느리다.
	 *   -
	 *   
	 *   		쓰레드
	 *   - 프로세스 내 실행되는 작업단위
	 *   - 같은 프로세스에서 다른 쓰레드와 메모리 공간을 공유한다.
	 *   - 멀티 쓰레딩(여러 개의 쓰레드를 병렬로 실행)
	 *   - 속도가 빠름
	 *   - 단일 쓰레드도 있음.
	 */
	
	
	private String name;
	
	MyThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		/**
		 *  1. Runnable을 상속받아서 재정의 해야함.
		 */
		
		for(int i = 0; i < 10; i++) {
			System.out.println(this.name + " : " + i );
		}
		
	}
	
	

	

}
