package hm.java01.Day03;

import java.util.Scanner;

public class CommandBySwitch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		
	
	
	    System.out.println("请选择功能：1.显示全部记录2.查询全部记录0.下次再来吧！");
		int  command = scan.nextInt();
		switch(command){
			case 1:
			System.out.println("显示全部记录");
			break;
			case 2:
			System.out.println("查询全部记录0");
			break;
			case 0:
			System.out.println("下次再来吧！");
			break;
			default:
			System.out.println("输入错误！");
			
		}
		
		
		
		/*
		Scanner scan =new Scanner(System.in);
		
		System.out.println("请选择功能：1.显示全部记录2.查询全部记录0.下次再来吧!");
		int command = scan.nextInt();
		
		switch(command){
		case 1:
			System.out.println("显示全部记录");
			break;
		case 2:
			System.out.println("查询全部记录");
			break;
		case 0:
			System.out.println("下次再来吧!");
			break;
	    default:
	    	System.out.println("输入错误！");
			}
		
		*/
	}

}
