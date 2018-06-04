package hm.java01.Day03;
import java.util.Scanner;


public class Cashier {

	public static void main(String[] args) {
	 
		Scanner scar = new Scanner(System.in);
		System.out.println("请输入单价：");
		double  unitPrice = scar.nextDouble();
		
		System.out.println("请输入数量：");
		double amount = scar.nextDouble();
		
		System.out.println("请输入金额：");
		double  money =scar.nextDouble();
		    
		double totalPrice = unitPrice*amount;
	   
		if(totalPrice>=500){   //满500
	    	totalPrice *= 0.8; //打8折
	    }
		
		if(money>=totalPrice){         //付够钱
			double change = money-totalPrice;
			System.out.println("总价为："+totalPrice+",找零为："+change);
		
		}else{              //付钱不够
			System.out.println("ERROR,您给的钱不够！");
		}
  
	  
	}

}
