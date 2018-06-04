package hm.java01.Day05;
    import java.util.Arrays;
public class MaxOfArray {

	public static void main(String[] args) {
	  
		int[] arr = new int[10];
	   
		
	   for(int i=0;i<arr.length;i++){   //   遍历所有元素    arr.length=10
			arr[i]=(int)(Math.random()*100);  // 随机生成 0--99
		 System.out.println(arr[i]);          // 
		   }
		
	   int max = arr[0];                 //假设第一个最大
	   for(int i =1;i<arr.length;i++){    //遍历剩余元素
		   if(arr[i]>max){            //若剩余元素大于max则交换
			   max = arr[i];        //修改最大值max为
		   }
	   }
		System.out.println("最大值为"+max);
        //System.out.println(arr.length); //  数组访问    输出数组长度/个数 
	    System.out.println();//
	   
	    //输出最小数在最后一个元素的位置
        arr = Arrays.copyOf(arr,arr.length+1);//数组的扩容
        arr[arr.length-1] = max;    //输出最小数在最后一个元素的位置
        for(int i = 0;i<arr.length;i++){
        	System.out.println(arr[i]);
        	
        }

	}

}
