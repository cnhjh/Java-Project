package core.demo;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random()*100);
			System.out.println(arr[i]);
		}
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1-i; j++) {
				if(arr[j+1]>arr[j]) {
					int a = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = a;
				}
			}
		}
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		
	}

}
