package hm.java02.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入自己的生日，然后输出其生日当天是当年的
 * 第几天以及星期几?
 * @author adminitartor
 *
 */
public class Test2 {

	public static void main(String[] args)throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入您的生日:");
		String birthStr = scanner.nextLine();
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd");
		Date birth = sdf.parse(birthStr);	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birth);	
		//查看是当年的第几天?
		int days = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println("您生日那天是"+calendar.get(Calendar.YEAR)+"年的第"+days+"天");
		//周几
		days = calendar.get(Calendar.DAY_OF_WEEK)-1;
		String[] data = {"日","一","二","三","四","五","六"};
		System.out.println("那一天是星期"+data[days]);//星期二
		

	}

}
