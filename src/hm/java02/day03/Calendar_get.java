package hm.java02.day03;
import java.util.Calendar;

/**
 * Calendar提供了根据给定时间分量获取对应值的方法:
 * int get(int field)
 * 
 * 时间分量对应的是Calendar提供的相应常量。
 * @author adminitartor
 *
 */
public class Calendar_get {

	public static void main(String[] args) {
	Calendar calendar = Calendar.getInstance();
		
		//获取年?
		int year = calendar.get(Calendar.YEAR);
		/*
		 * 月从0开始，即:0表示1月，1表示2月
		 * 月的值有常量对应。
		 */
		int month = calendar.get(Calendar.MONTH)+1;
		/*
		 * 天有不同的时间分量：
		 * DAY_OF_MONTH:月中的天，即:几号
		 * DAY_OF_WEEK:周中的天，即:星期几
		 * DAY_OF_YEAR:年中的天。
		 * DATE:与DAY_OF_MONTH意思一致。
		 */
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year+"-"+month+"-"+day);
		
		int h = calendar.get(Calendar.HOUR_OF_DAY);//时
		int m = calendar.get(Calendar.MINUTE);//分
		int s = calendar.get(Calendar.SECOND);//秒
		System.out.println(h+":"+m+":"+s);
		//查看今天是今年的第多少天?
		int days = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println("今天是今年的第"+days+"天");
		
		//查看今天是周几?
		days = calendar.get(Calendar.DAY_OF_WEEK)-1;
		String[] data = {"日","一","二","三","四","五","六"};
		System.out.println("星期"+data[days]);//星期二

		

	
	}

}
