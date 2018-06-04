package hm.java01.Day04;
      //猜数字游戏
import java.util.Scanner;

public class Guessing {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = (int) (Math.random() * 1000 + 1);// 1-----1000
		System.out.println(num); // 作弊
		int guess;
		do {
			System.out.println("猜吧:");
			guess = scan.nextInt();//输入数字
			if (guess == 0) {
				break;
			}
			if (guess > num) {
				System.out.println("太大了");
			}
			if (guess < num) {
				System.out.println("太小了");
			}
		} while (guess != num);
		if (guess == num) {
			System.out.println("恭喜你,猜对了！");
		} else {
			System.out.println("下次再来吧！");
		}

		/*
		 * System.out.println("猜吧:"); int guess = scan.nextInt();
		 * 
		 * while(guess!=num){ if(guess==0){ break; } if(guess>num){
		 * System.out.print("太大了"); }else{ System.out.print("太小了"); }
		 * System.out.println(",猜吧:"); guess=scan.nextInt(); } if(guess==num){
		 * System.out.println("恭喜你,猜对了！"); }else{ System.out.println("下次再来吧！");
		 * }
		 */

		/*
		 * 猜数字 有提示大小 Scanner scan = new Scanner(System.in);
		 * 
		 * int num = 520;
		 * 
		 * System.out.println("猜吧"); int guess = scan.nextInt();
		 * 
		 * while(guess!=num||guess==num){ //while(ture); if(guess==num){
		 * System.out.println("恭喜你,才对了！"); break; }if(guess<num){
		 * System.out.println("太小了"); guess = scan.nextInt(); }if(guess>num){
		 * System.out.println("太大了"); guess = scan.nextInt(); } }
		 * 
		 */

		/*
		 * 猜数字 Scanner scan = new Scanner(System.in);
		 * 
		 * int num = 250;//藏起来的数
		 * 
		 * System.out.println("猜吧！"); int guess = scan.nextInt();
		 * 
		 * while(guess!=num){ System.out.println("猜吧"); guess = scan.nextInt();
		 * } System.out.println("恭喜你,才对了！");
		 */
	}

}
