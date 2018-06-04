package hm.java01.Day03;

import java.util.Scanner;
 
public class AgeRange {
          
	public static void main(String[] args) {
		Scanner scar = new Scanner(System.in);
		System.out.println("请输入单价：");
		double  unitPrice = scar.nextDouble();
		
		System.out.println("请输入数量：");
		double amount = scar.nextDouble();
		
		System.out.println("请输入金额：");
		double  money =scar.nextDouble() ;
		          
		double totalPrice1 = unitPrice*amount;//商品总价
		double totalPrice2 = unitPrice*amount*0.8;//折后商品总价
		double change1 = money-totalPrice1; //找零
		double change2 = money-totalPrice2; //折后找零
		
		String discount = totalPrice1 >= 500?"享受8折优惠折后总价为："+totalPrice2+",找零为："
				+change2:"不享受打折优惠,总价为："+totalPrice1+ ",找零为："+change1;
				
		System.out.println(discount);    
		
		
		
		/*
		System.out.println("请输入年份：");
		int year = scar.nextInt();
        boolean  flag = (year%4==0 && year%100!=0) || year%400==0;
        String str = flag ? year+"年是润年":year+"年不是润年";
        System.out.println(str);
        */		
		 
		
		
		
		
		
		
		/*
		 * System.out.println("请输入年龄：");
		 
		Scanner scar = new Scanner(System.in);
		int age = scar.nextInt();

	   System.out.println(age<=18 && age<=50);
	*/
	}

}
