package hm.java02.day03;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar
 * 日历类，是一个抽象类，定义了相关常量以及日历相关操作
 * 日期的方法。
 * 常用实现类:GregorianCalendar 即：阳历
 * 
 * Calendar提供了一个静态方法:getInstance，该方法可以
 * 根据当前系统所在地区获取一个适用的实现类。
 * @author adminitartor
 *
 */
public class Calendar_getInstance {

	public static void main(String[] args) {
		/*
		 * 默认创建出来也表示当前系统时间
		 */
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(calendar);
		
		/*
		 * 将Calendar表示的日期用Date形式表示
		 * Calendar提供了方法:
		 * Date getTime()
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		
		/*
		 * 使当前Calendar表示给定的Date所表示的日期
		 */
		calendar.setTime(date);
		
		

	}

}
