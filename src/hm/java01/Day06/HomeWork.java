package hm.java01.Day06;

public class HomeWork {
	public static void main(String[] args) {
		//boolean falg = true;	   //
		int count = 0;                         //j计数器
		for(int num=2;num<=100;num++){
			boolean falg = true;           //假设num是质数
		    for(int i=2;i<=Math.sqrt(num);i++){    //求平方跟
		    	                               //(int i=2;i<num;i++)// 2/3/4/5/6/7
				                                 //for(int i=2;i<num/2;i++)//取一半
			    if(num%i==0){                   //除了1和它本身以外，能被其他自然数整除 则不是质数 
					falg = false;               //改为不是质数
					break;                      //跳出
			    }
			}
		    if(falg){                           //判断的结论  相当于if(falg==ture)  
				System.out.print(num+"\t");  // 占8个位置
				count++;
				if(count%10==0){
					System.out.println();       //够十换行
				
				}
		    }	   
		}
	}
}
