package day.four;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Test02 {

	public static void main(String[] args) {
		/**
		 *  1. 10 ~ 19사잉의 임의 수 10개를 발생.
		 *  2. 리스트에 저장
		 *  3. 리스트에 저장된 값 중 짝수를 제거.
		 *  4. 최종결과를 출력.
		 */
		
		// 1. 10~19 사이의 값을 10개 저장.
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add((int)random.nextInt(10)+10);
			
		}
		
		// 2. 10개 저장한 리스트 확인.
		System.out.println(list.toString());
		

		
		//3. 짝수를 제거. iterator 사용.
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			if((int)iter.next() % 2 == 0)
				iter.remove();
		}
		
		
		//3. 짝수를 제거 get 사용.
		for(int i =0; i < list.size();  i++) {
			if((int)list.get(i)% 2  == 0) {
				list.remove(i--);
			}
		}
		
		System.out.println(list.toString());
	}

}
