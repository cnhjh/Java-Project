package hm.java02.day03;

import java.util.Calendar;

/**
 * void set(int field,int value)
 * 对指定时间分量设置给定的值
 * @author adminitartor
 *
 */
public class Calendar_set {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();		
		/*
		 * 设置各时间分量，使Calendar表示:
		 * 2008-08-08 20:08:08
		 */
		//设置年
		calendar.set(Calendar.YEAR, 2008);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
//		calendar.set(Calendar.MONTH, 7);
		
		calendar.set(Calendar.DAY_OF_MONTH, 8);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 8);
		calendar.set(Calendar.SECOND,8);
		
		System.out.println(calendar.getTime());
		
		
		calendar.set(Calendar.DAY_OF_WEEK, 3);
		System.out.println(calendar.getTime());

	}
}
