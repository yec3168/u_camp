package review.two;

import java.util.Arrays;

public class DayTwoReview {

	public static void main(String[] args) {
		
		/**
		 *  	조건문
		 *  1. if
		 *  
		 *  2. switch
		 *   - switch는 break를 안해놓으면 조건에 맞는 모든 명령어 실행.
		 *   
		 */
		
		
		if(10 > 5) {
			System.out.println("크다");
		}
		
		int switch_int = 20;
		switch(switch_int){
		case 10:
			System.out.println(10);
			 
		case 20:
			System.out.println(20);
			break;
		default:
			System.out.println("그 외");
		}
		
		
		
		
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		
		
		/**
		 * 		반복문
		 * 1. for
		 *  - for( 변수, 조건식, 증감식)
		 *     ex) for(int i = 0; i < 10; i++){}
		 *     	   for( ;  ;){} // 무한반복
		 *  - 최소 0번부터 무한반복까지 가능
		 *  - 보통 제한을 걸어서 사용할 때 주로 사용.
		 * 2. while
		 *  - while(조건식){}
		 *  - 최소 0번부터 무한반복까지 가능
		 *  - 주로 몇번 반복을 돌려야할지 모를 때 사용.
		 * 
		 * 3. do-while
		 * - do {
		 * 	 } while(조건)
		 * - 무조건 1번은 실행함.
		 * 
		 * 4. for-each
		 *  - 배열이나 리스트 반복을 돌릴 때 많이사용함.
		 *   ex) int [] arr = { 1, 2, 3, 4}
		 *    for( int index : arr) {}
		 */
			System.out.print( "for :::: ");
			for(int i = 0; i < 5; i++) {
				System.out.print(i +" ");
			}
			System.out.println();
			
			
			
			
			System.out.print( "while :::: ");
			int i=0;
			while(i < 5) {
				System.out.print(i++ +" ");
			}
			
			System.out.println();
			
			
			
			
			System.out.print("do while :::: ");
			i =0;
			do {
				System.out.print(i++ +" ");
			}
			while(i < 5);
			
			System.out.println();
			
			
			
			
			System.out.println("for-each :::: ");
			int arr [] = {1, 2, 3, 4, 5};
			for(int index : arr) {
				System.out.print(index++ +" ");
			}
			
			System.out.println();
			
			
			
			 //-----------------------------------------------------------------------------------------------------------------------------//	
			
			
			/**
			 * 		제어문
			 * 	1. break
			 * - 해당 반복문을 중단하는 목적.
			 * 
			 *  2. continue
			 * - continue 후 작업은 무시하고 다시 반복문 처음으로 돌아감.
			 * 
			 *  3. 다중 반복문 break;
			 * - 반복문이 여러 개일 경우, breakPoint를 설정하여 조건에 따라 모든 반복문을 끝냄.
			 * - break or continue와 함께 씀.
			 */
			
			System.out.print("break :::: ");
			for(int k = 1; k < 10; k++) {
				if(k % 5 == 0)
					break;
				System.out.print(k +" ");
			}
			
			System.out.println();
			
			
			
			System.out.print("continue :::: ");
			for(int k = 1; k < 10; k++) {
				if(k % 5 == 0)
					continue;
				System.out.print(k +" ");
			}
			
			System.out.println();
			
			
			System.out.print("breakPoint (break)  :::: ");
			bp:
				for(int k = 1; k < 10; k++) {
					for(int j = 1; j < 10; j++) {
						if(( k * j) % 2 == 0){ // 완전히 중단.
							break bp;
						}
						System.out.print(k*j+" ");
					}
				}
			System.out.println();
			
			


			System.out.print("breakPoint (continue)  :::: ");
			bp:
				for(int k = 1; k < 10; k++) {
					for(int j = 1; j < 10; j++) {
						if(( k * j) % 2 == 0){
							// k * 2를 만나는 순간 반복문 중단. 처음으로 돌아감 ( 바로 위 반복문)
							continue bp;
						}
						System.out.print(k*j+" ");
					}
				}
			
			System.out.println();
			
			
			
			 //-----------------------------------------------------------------------------------------------------------------------------//	
			
			
			
			/**
			 * 		배열
			 *  - 배열 선언 시 꼭 크기를 선언 해야 함.
			 *  - 동일한 자료형 끼리의 집합.
			 *  - 배열은 heap 영역에 생성.
			 *  - int자료형일 경우 생성 하면 '0'으로 초기화
			 *  - String은 null로 초기화.
			 *  
			 *   ex) int arr [] = new int[4];
			 *       int [] arr = new int[4];
			 *       int [] arr = {1, 2, 3, 4}
			 *       int arr[] = new int[]{1, 2, 3, 4}
			 *       
			 *       
			 *       int arr[];
			 *       arr = new int[]{1, 2, 3, 4} 		★★★★★★★★★★★★★★★★★★★★★
			 *       
			 *       여기까지 다 가능.
			 *       ---------------------------------------------
			 *       
			 *       int arr[] =new int[] ;		//x
			 *       
			 *       
			 *       int arr[];
			 *       arr = {1, 2, 3, 4}   		//x		★★★★★★★★★★★★★★★★★★★★★★
			 *       
			 *   
			 */
			
			int [] arr1 = new int[4];
			int arr2 [] = new int[4];
			System.out.println("int형 배열의 초기값 ::::: " + arr1[0]);
			System.out.println("배열 전부 출력 :::: " + Arrays.toString(arr2));
			
			int arr3[] = {1, 2, 3, 4, 5};
			System.out.println("배열 초기화 값 지정 :::: " + Arrays.toString(arr3));
			
			int arr4[] = new int[] {1,2,3,4,5,6,7};
			System.out.println("배열 선언과 동시에 초기화 :::: " + Arrays.toString(arr4));
			
			
			
			 //-----------------------------------------------------------------------------------------------------------------------------//	
			
			
			/**
			 *  	이차원 배열
			 *  - 일차원 배열의 특징을 비슷하게 가지고 있음.
			 *  - 크기를 꼭 지정해야하는 것은 맞지만, 경우에 따라 안 정해도 됨.
			 *  
			 *   ex)  int arr [][] = new int[3][3];  // 일반적인 선언문.
			 *   
			 *   	  int arr [][] = new int[4][];
			 *        arr[0] = new int[4];
			 *        arr[1] = new int[2];
			 *        arr[2] = new ont[3];
			 *        
			 *      * 위와 같이 크기를 자유롭게 지정 가능.  But. 크기를 지정안한 arr[3]은 사용 불가.
			 *   		
			 */
			
			int array1 [][] = new int[3][3];
		
			System.out.print("2차원 배열 전부 출력 :::: " );
			for(int aa [] : array1) {
				System.out.print(Arrays.toString(aa) + " ");
			}
			
			System.out.println();
			
			
			
			int array2[][] = new int[5][];
			array2[0] = new int[1];
			array2[1] = new int[3];
			array2[2] = new int[5];
			array2[3] = new int[4];
			//array[4] == null로 나옴,	길이는 exception
			System.out.print("2차원 배열 크기 지정 출력 :::: " );
			for(int aa [] : array2) {
				System.out.print(Arrays.toString(aa) + " ");
				
			}
			
			System.out.println();
			
			
			
			
			int array3[][] = { {1,1,1}, {2, 2}};
			System.out.print("2차원 배열 초기화 :::: " );
			for(int aa [] : array3) {
				System.out.print(Arrays.toString(aa) + " ");
			}
			
			System.out.println();
			
			
			 //-----------------------------------------------------------------------------------------------------------------------------//	
			
			
			
			/**
			 *  	클래스
			 *   - 객체를 생성하기 위한 툴
			 *   
			 *   1. 절차 지향형
			 *  - 순서대로 진행.
			 *  
			 *   2. 객체 지향형
			 *  - 객체 단위로 이리저리 움직이면서 실행.
			 *  
			 *  
			 *  	접근 제어자
			 *  
			 *  1. public :  모든 패키지에서 자유롭게 접근 가능
			 *  2. protected : 같은 패키지에서 사용가능하며, 상속받은 자식 클래스 사용가능
			 *  3. default : 같은 패키지에서만 사용가능
			 *  4. private : 같은 클래스에서만 사용가능.
			 */ 
			 
			
			// DayTwoClassTest에 생성자가 생성되었기때문에, 해당 파라미터에 맞춰서 인스턴스를 생성해야함.
			// 만약, 지키지않는다면 Error 발생.
			DayTwoClassTest dayTwo = new DayTwoClassTest("test", 12); // 생성자 접근. 기본 생성자 생성 x
			 
			
			// 1. 일반 public 메소드 접근
			dayTwo.setAddress("서울시");
			System.out.println("public 메소드 접근 :::: "+ dayTwo.getAddress());
			
			
			// 2. static private 메소드 접근
			//DayTwoClassTest.print();   // private는 같은 클래스에서만 접근 가능하기때문에 호출 불가능.
			
			
			
			//3. static public 메소드 접근
			System.out.println("static public 접근 :::: " + DayTwoClassTest.getSalary());
			
			
			
			
			
			
			
	}

}
