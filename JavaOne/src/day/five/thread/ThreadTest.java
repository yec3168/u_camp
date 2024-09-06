package day.five.thread;

public class ThreadTest {

	public static void main(String[] args) {
		
		System.out.println("main start");
		MyThread t1 = new MyThread("쓰레드 1");
		MyThread t2 = new MyThread("쓰레드 2");
		
		/**
		 *  	Thread(Runnable r) 
		 *  
		 *  - Main도 쓰레드이기때문에 각각 독립적으로 실행됨.
		 *  - start()메소드를 사용하여 쓰레드를 시작함.
		 *  - Runnable을 사용해야함.
		 *  - 쓰레드는 동시성과 병렬성의 특징을 가지고 수행.
		 *  - 자신의 작업이 모두 끝나야 종료.
		 *  
		 *   Thread.sleep(1000) // 메인 쓰레드를  1초간 쉬게 함.
		 */
		Thread thread1 = new Thread(t1);   // Thread(Runnable r) 
		Thread thread2 = new Thread(t2);
		
		// thread1.run()을 하면 스케줄러가 작업을 하는게 아니라 main이 함.
		thread1.start();
		thread2.start();
		
		
		System.out.println("main end");
		
		/**
		 *  		쓰레드 lifeCycle
		 *  1. 인스턴스를 만들면 Thread는 `Ready()` 상태
		 *  2. start() 메소드를 사용하면 쓰레드는 Runnable 상태로 전이됨( run )
		 *      ** cpu에 할당받을 준비는 되어있지만, 실제로 실행되고있는지는 스케줄러의 결정에 따라 다름.
		 *  	** 스케줄러에 의해서 병렬적으로 실행되는지 아니면 Lock을 사용해서 하는지 정해짐.
		 *    	
		 *      2-1. Lock (Synchronized)
		 *         - thread1이 run 상태이면 Lock을 걸어 다른 쓰레드가 해당 자원을 사용못하게 막음
		 *         - run()을 정지 시키고 다른 쓰레드를 작업하면 thread1 = wait(), thread2 = run()이 됨. 
		 *         - 동시성 문제를 해결해줌.
		 *         - 따로 yield() 나 다른 명령어를 쓰지 않는 이상 작업이 완료될 때까지 다른 쓰레드가 해당 자원을 접근못함
		 *           즉, 하나의 작업이 온전하게 끝낼수 있도록 보장해줌.
		 *         **(Synchronized (key) ) : 동시에 같은 자원을 사용하는 경우 자원의 충돌을 방지하기 위해서, 혹은 중요한 작업을 먼저 수행시키기 위해서.
		 *           - 메소드에 붙일 수 있음
		 *           	ex) synchronized(this) // this는 원래 생략.
		 *           - block에 붙일 수 있음
		 *           	ex) synchronized(key){
		 *           		}
		 *         
		 *      2-2. 병렬
		 *         - 동시에 진행. 
		 *         
		 *  3. Run()이 완료하면 Terminated 완전히 끝남.
		 *  
		 *  
		 *  
		 *  		작업이 3개,		코어가 4개인 경우
		 *  	- 코어(쓰레드)가 4개이기 때문에 작업 3개는 수행하고 한 개는 wait
		 */
		
		
		//===============================================================================================================
		
		
		/**
		 *  		쓰레드의 속성
		 *  
		 *   1. 개수
		 *   - activeCount()하면 실행시키고 있는 쓰레드를 확인함
		 *   - 죽은것들은 확인 안함.
		 *   2. 우선순위
		 *   - default가 5임 중요도가 높으면 먼저 실행함.
		 *   3. 데몬
		 *   - 일반적인 쓰레드는 자신의 작업이 끝나야 프로세스가 종료되는 반면, 데몬은 일반쓰레드가 모두 종료되면 데몬쓰레드도 종료.
		 *   
		 */
		
	}

}
