package hm.java02.day03;
import java.util.Calendar;

/**
 * void add(int field,int value)
 * 对指定时间分量加上给定的值，若给定的值是负数则是
 * 减去。
 * @author adminitartor
 *
 */
public class Calendar_add {
	public static void main(String[] args) {
	
		Calendar calendar = Calendar.getInstance();/*
		 * 计算3年2个月零25天以后是哪天?
		 */
		//加年
		calendar.add(Calendar.YEAR, 3);
		//加月
		calendar.add(Calendar.MONTH, 2);
		//加天
		calendar.add(Calendar.DAY_OF_YEAR, 25);
		System.out.println(calendar.getTime());

		//设置为当周的周五日期
		calendar.set(Calendar.DAY_OF_WEEK, 
				     Calendar.FRIDAY);
		System.out.println(calendar.getTime());
		//计算前一天
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		System.out.println(calendar.getTime());
		
		
		/*
		 * int getActualMaximum(int field)
		 * 返回给定时间分量所允许的最大值
		 * 参照日期为当前Calendar所表示的日期
		 */
		//查看那个月的月底是几号?
		int days = calendar.getActualMaximum(
						Calendar.DAY_OF_MONTH
				   );
		System.out.println("当月月底是"+days+"号");

	}
}
