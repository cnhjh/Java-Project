package hm.java.recursion;

/**
 * 三角数字   
 * 第5个三角数字：5+4+3+2+1 = 15
 * 第n个三角数字： = (n*n+n)/2  
 * @author 004
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		Demo1 d = new Demo1();
		//求第7项的值
		int i = d.triangle(7);
		System.out.println(i);//28

	}
	
	public int triangle(int i){
		int total=0;
		int n = 1;
		while(n <= i){
			total = total + n;
			//System.out.println(total);
			//			1
			//			3
			//			6
			//			10
			//			15
			//			21
			//			28
			++n;
		}
		return total;
	}
}

// ------------------- 循环七次图解 -------------------
	

//		*
//		1
//		列
//第1次 	=1
	
//		*
//		**
//		12
//		列
//第2次	1+2=3	
	
//		*
//		**
//		***
//		123
//		列
//第3次	3+3=6
	
//		*
//		**
//		***
//		****
//		1234
//		  列
//第4次  6+4=10
	
//		*
//		**
//		***
//		****
//		*****
//		12345
//		  列
//第5次	10+5=15	
		
//		*
//		**
//		***
//		****
//		*****
//		******
//		123456
//		    列
//第6次	15+6=21
	
//		*
//		**
//		***
//		****
//		*****
//		******
//		*******
//	    1234567
//	           列
//第7次  21+7=28		
	


