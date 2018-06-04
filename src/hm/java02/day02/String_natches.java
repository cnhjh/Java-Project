package hm.java02.day02;

import java.util.Scanner;

/**
 *字符串支持正则表达式的方法之一：
 *boolean natches（String regex）
 *使用给定的正则表达式验证字符串是否满足格式要求
 *满足则返回true
 *需要zhuyi，给定的正则表达式无论是否加了边界符（^……$）都是进行全匹配验证
 * @author soft01
 *
 */
public class String_natches {

	public static void main(String[] args) {
		/**
		 * 邮箱正则表达式：
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\.[a-zA-Z]+)+
		 */
	    Scanner scan = new Scanner(System.in);
	    System.out.println("请输入邮箱地址：");
		String email = scan.nextLine();
		//String email = "fancq@tedu.cn"；
		
		// 或者String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";
		String regex = "/w+@/w+(\\.[a-zA-Z]+)+";
		boolean match = email.matches(regex);
		
		if(match){
			System.out.println("是邮箱");
		}else{
			System.out.println("不是邮箱");
		}
		

	}

}
