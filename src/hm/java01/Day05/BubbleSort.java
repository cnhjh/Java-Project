package hm.java01.Day05;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		   for(int i=0;i<arr.length;i++)
		   {   //   遍历所有元素    arr.length=10
				arr[i]=(int)(Math.random()*100);  // 随机生成 0--99
			    System.out.println(arr[i]);          // 
		   }
		
		   
		   
		   for(int i=0;i<arr.length;i++)
		   {			
			   for(int j=0;j<arr.length-1-i;j++)
			   {
				if(arr[j]>arr[j+1])
				{
					int c = arr[j];
					arr[j]=arr[j+1];
					arr[j+1] = c; 
					
				}
			   }
				
			
		   }
		  System.out.println("升序排序后：");
		  for(int i=0;i<arr.length;i++)
	      System.out.print(arr[i]+" ");
    }	
}	
	
	


