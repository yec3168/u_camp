import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LambdaTest {
	
	
	@Test
	void consumerTest() {
		List<String> asList = Arrays.asList("java", "python", "c", "javascript");
		//1. Anonymous inner class
		asList.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		System.out.println();
		
		//2. lambda method
		asList.forEach((str) ->{
			System.out.println(str);
		});
		
		System.out.println();
		
		//3. method Reference - 람다식의 아규먼트를 생략하고 Body만 구현하기.
		asList.forEach(System.out::println);
	}
	
	@Test @Disabled
	void lambdaTest() {
		// 1. Anonymous inner class
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("출력");
			}
		});
		
		t1.start();
		
		
		// 2. lambda expression
		Thread t2 = new Thread( () ->{
			System.out.println("t2 출력");
		});
		
		t2.start();
		
		
		
	}
}
