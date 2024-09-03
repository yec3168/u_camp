package day2;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 *  배열(Array)
		 *  
		 *  * 배열은 꼭 크기를 적어줘야함.
		 *   ex) int [] array = new int[3]; ( o )
		 *   	 int array [] = new int[3]; ( o )
		 *       int [] array; // 실제 배열 객체는 생성되지 않음.
		 *  * 동일한 자료형만 묶음.
		 *  * 배열은 heap 영역에 생성.
		 *  * 값으로 초기화도 가능함. 한줄에 다 작성해야한다.
		 *    ex) int array [] = {1, 2, 3, 4}  o
		 *            
		 *       int array [];
		 *        array = {1, 2, 3}  x  안됨.
		 *        
		 *  * 생성과 값도 같이 넣을 수 있음.
		 *     ex) int [] array = new int[] {10, 20, 30};
		 *    
		 * 차이점 : 분리가 가능
		 * 
		 *   * 크기는 한번 지정하면 축소나 확장이 불가능. 
		 *   
		 */     
		
		int arr1 [] = new int[4];
		System.out.println(arr1[0]);  //0
		
		
		String [] arr2 = new String[3];
		System.out.println(arr2[1]);  // null
		

		double [] arr3 = new double[4];
		System.out.println(arr3[1]);  // 0.0
		
		char [] arr4 = new char[4];
		System.out.println(arr4[0]); // ' '
		
		
		int [] arr5 = {1, 2, 3, 4};
		
	//**중요	// int [] arr6;          나눠서 안됨. new 필요함.
 	//**	// arr6= {1,2,3}; x
		
		int [] arr7 = new int[] {1, 2, 3, 4}; // 가능
		
		int [] arr8;
		arr8 = new int[] {10, 20, 30, 40};  // arr7 == arr8임. 
		
		System.out.println(Arrays.toString(arr8));
		
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		
		/**
		 * 2차원 배열
		 * 
		 * *마찬가지로 크기는 꼭 지정해야하는데, 예외가 있음.
		 *  ex) int arr [][] = new int[4][4]; // 가능
		 *      int arr [][] = new int[4][]; // 가능
		 *       
		 *       arr[0] = new int[5];
		 *       arr[1] = new int[4]; 
		 *       
		 *      식으로 크기를 지정가능함.
		 *  
		 *  나머진 일반 배열이랑 같은 특징을 지님.
		 */
		
		 int array1 [][] = new int[4][4];
		 int array2 [][] = new int[4][];
		 	
		 array2[0] = new int[4];
		 array2[1] = new int[3]; 
		 array2[2] = new int[] {10,20,30};
		 
		 System.out.println(array2[1].length + " " + Arrays.toString(array1));
		 
		 
		 
		 
		 int [][] array3 = { {1, 2, 3}, {2, 3, 4}};
		 int [][] array4 = new int[][] {{1,2,3},{4, 5}, {6,1,2,3}};
		 
		 for( int [] subArr : array3) {
			 System.out.println(Arrays.toString(subArr));
		 }
		 

	}

}
