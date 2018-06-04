package hm.java01.core;

/**
 * 我的工具
 * @author 胡景皓-2018
 */
public class Utils {

	/**
	 * 判断是否为质数
	 * @param num
	 * @return 结果为true则是质数
	 */
	public boolean primeNumber (int num) {
		boolean falg = true;           //假设num是质数
	    for(int i=2;i<=Math.sqrt(num);i++){    //求平方跟
	    	                                //(int i=2;i<num;i++)// 2/3/4/5/6/7
			                                //for(int i=2;i<num/2;i++)//取一半
		    if(num%i==0){                   //除了1和它本身以外，能被其他自然数整除 则不是质数 
				falg = false;               //改为不是质数
				break;                      //跳出
		    }
		}
		return falg;
	}
	
	/**
	 * 冒泡排序:升序
	 * @param arr
	 * @return
	 */
	public int[] bubbleSortS(int[] arr) {
		for(int i=0;i<arr.length;i++){			
		    for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int c = arr[j];
					arr[j]=arr[j+1];
					arr[j+1] = c; 
				}
			}
		}
		return arr;
	}
	/**
	 * 冒泡排序:降序
	 * @param arr
	 * @return
	 */
	public int[] bubbleSortJ(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1-i; j++) {
				if(arr[j+1]>arr[j]) {
					int c = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = c;
				}
			}
		}
		return arr;
	}
	
	/**
	 * a = Arrays.copyOf(a,a.length+1); //数组的扩容
	 * 2018-04-11
	 * @param arr int数组
	 * @return 返回最大值
	 */
	public int maxOfArray(int[] arr) {
		int max = arr[0];    
		for(int i =1;i<arr.length;i++){    //遍历剩余元素
		    if(arr[i]>max){            //若剩余元素大于max则交换
			    max = arr[i];        //修改最大值max为
		    }
	    }
		return max;
	}
	/**
	 * 
	 * @param arr
	 * @return 返回最小值
	 */
	public int minOfArray(int[] arr) {
		int min = arr[0];    
		for(int i =1;i<arr.length;i++){    //遍历剩余元素
		    if(arr[i]<min){            //若剩余元素大于max则交换
		    	min = arr[i];        //修改最大值max为
		    }
	    }
		return min;
	}
	
	/**
	 * 
	 * 判断是否为闰年
	 * 三目/条件运算符:boolean?数1:数2
	 * 				 flag?"是闰年":"不是闰年"
	 * @param year 
	 * @return 返回true时闰年
	 */
	public boolean leapYear(int year) {
		boolean flag = (year%4==0 && year%100!=0) ||  year%400==0;
		return flag;
	}
	
	
}
