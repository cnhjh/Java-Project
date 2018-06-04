package hm.java01.Day05;
          //数组
public class ArrayDemo {  
  
	public static void main(String[] args) {


		
		int[] arr = new int[10];//0.0.0.0.0.0.0.0.0.0
//		arr[0] = 5;
//		arr[1] = 2;
//		arr[2] = 0;
		int[] arr1 ={2,5,8};//2.5.8
		int[] arr2 = new int[]{2,5,8};//2.5.8
		int[] arr3 = new int[3];//0.0.0
		int[] arr4 = new int[] {0,0,0,0,0,0,0,5,2,0};
		
		
		arr3[0] = 100;
		arr3[1] = 200;
		arr3[2] = 300;
		//arr3[4] = 400;//
		
		for(int i=0;i<arr.length;i++){
			arr[i] = i;
			System.out.println(arr[i]);
		}
		
		System.out.println(arr3.length);
		System.out.println(arr3[arr3.length-1]);
		
		
		
	}
}