package review.five.thread;

import java.util.ArrayList;
import java.util.List;

public class Data {
	
	List<Integer> list = new ArrayList<>();
	
	/**
	 *  list에 데이터를 추가
	 *  
	 *  
	 *   * synchronized : 현재 A라는 쓰레드가 작업중이면 다른 쓰레드가 접근을 못함.
	 * @param data
	 */
	public synchronized void plusData(Integer data) {
		
		list.add(data);
		
		notify();
	}
	
	
	/**
	 *  list에 마지막에 들어온 데이터를 제거.
	 *
	 *
	 *   * synchronized : 현재 A라는 쓰레드가 작업중이면 다른 쓰레드가 접근을 못함.
	 * @throws InterruptedException 
	 */
	public synchronized int removeData() throws InterruptedException {
		if(list.isEmpty()) {
			wait();
		}
		
		notify();
		return list.remove(list.size()-1);
	}
	
	
	
}
