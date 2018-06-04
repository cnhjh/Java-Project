package hm.java01.Day04;
   import java.util.Scanner;
   
public class LeapYear {
     
	public static void main(String[] args) {
	   Scanner scan = new Scanner(System.in);
	   
	   System.out.println("请输入年份：");
	   int year = scan.nextInt();
	   if((year%4 == 0 && year%100 != 0) || year%100 == 0){
		   System.out.println(year+"是润年");
	   }else {
		   System.out.println(year+"不是润年");
	   }
	    }

}
