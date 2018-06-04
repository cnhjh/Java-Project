package hm.java01.Day05;

import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

public class WorkDemo {

	public static void main(String[] args) {

		int[] arr = new int[10];
		for (int j = 0; j < arr.length; j++) {     
			arr[j] = (int) (Math.random() * 100);
			System.out.println(arr[j]);
		}
			 int max= arr[0];
			
		for(int i= 1; i < arr.length; i++){
			if (max < arr[i]) {
				max = arr[i];
				

			}
	}
		

		System.out.println("    "+max);
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * //乘法表 for(int i=1;i<=9;i++){ for(int j=1;j<=i;j++){
		 * System.out.print(j+"*"+i+"="+j*i+"\t ");
		 * 
		 * } System.out.println();
		 * 
		 * }
		 */

	}

}
