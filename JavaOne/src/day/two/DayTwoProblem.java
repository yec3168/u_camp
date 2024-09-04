package day.two;

import java.util.Arrays;
import java.util.Random;

public class DayTwoProblem {

	public static void main(String[] args) {
		
		/**
		 * 로또 발생기를 작성하라.
		 * 1~45사이의 임의의 수 6개 추출. 그 수를 배열에 저장
		 * (중복은 없어야한다.)
		 * 
		 * int number = (int)(Math.random() * 45) + 1;
		 */
		
		
		// 1. Random 객체 사용.
		Random random = new Random();
		
		int [] lotto = new int[6];
		int i =0;
		breakOut:
		while(true) {
			if (i >= 6) break;
			int num = (random.nextInt(45)) +1;
			for( int index : lotto) {
				if(index == num)
					continue breakOut;
			}
			lotto[i++] = num;
			
		}
		System.out.println(Arrays.toString(lotto));
		
		
		// 2. 문제대로
		
		lotto = new int[6];
		i = 0;
		breakOut:
		while(true) {
			if(i >= 6)
				break;
	
			int num = (int)(Math.random()*45)+1;
			for( int index : lotto) {
				
				if(index == num)
					continue breakOut;
			}
			lotto[i++] = num;
			
		}
		System.out.println(Arrays.toString(lotto));
		
		
		// boolean 사용.
		lotto = new int[6];
		i = 0;
		while(true) {
			if(i >= 6)
				break;
			int num = (int)(Math.random()*45)+1;
			boolean find = true;
			for(int index : lotto) {
				if(index == num) {
					find = false;
					break;
				}
			}
			if(find)
				lotto[i++] = num;
		}
		System.out.println(Arrays.toString(lotto));
		
		
	}

}
