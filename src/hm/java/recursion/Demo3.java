package hm.java.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 三角数字演示递归详解
 * @author 004
 *
 */
public class Demo3 {
	
	static int theNumber;
	
	public static void main(String[] args) throws IOException {
		System.out.print("Enter a number:");
		theNumber = getInt();
		
		int theAnswer = triangle(theNumber);
		System.out.println("Triangle（计算后的结果）："+theAnswer);
		
	}
	
	//----------------------- 计算 ------------------------
	private static int triangle(int n) {
		System.out.println("第"+n+"次调用triangle()方法：n="+n);
		if(n==1){
			System.out.println("第"+n+"次返回n="+n+"：返回结果1 ,Returning=1 ");
			return 1;
		}else{
			int temp = n+triangle(n-1);
			System.out.println("第"+n+"次返回n="+n+"：上一个返回结果加上"+n+"返回"+temp+" ,Returning="+temp);
			return (temp);
		}
	}

	//---------------- String类型专为int类型返回 -----------------
	private static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

	
	//-------------------- 获取用户输入的数据 ------------------------
	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		System.out.println("输入的s="+s);
		return s;
	}

	
}

//------------------------- 测试输入5 ----------------------------

/*
 * 输入数字5时，输出的结果为：
 * 
	Enter a number:5
	输入的s=5
	
	第5次调用triangle()方法：n=5
	第4次调用triangle()方法：n=4
	第3次调用triangle()方法：n=3
	第2次调用triangle()方法：n=2
	第1次调用triangle()方法：n=1
	
	第1次返回n=1：返回结果1 ,Returning=1 
	第2次返回n=2：上一个返回结果加上2返回3 ,Returning=3
	第3次返回n=3：上一个返回结果加上3返回6 ,Returning=6
	第4次返回n=4：上一个返回结果加上4返回10 ,Returning=10
	第5次返回n=5：上一个返回结果加上5返回15 ,Returning=15
	
	Triangle（计算后的结果）：15

 * 
 */
































