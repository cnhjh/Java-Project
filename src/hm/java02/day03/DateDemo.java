package hm.java02.day03;
import java.util.Date;

/**
 * java.util.Date
 * Date的每一个实例用于表示一个时间点
 * Date内部维护一个long值，该值是UTC时间，即:
 * 从1970年1月1日 00:00:00 到该Date表示的时间之间所
 * 经过的毫秒
 * 由于Date存在时区及千年虫问题，所以大部分操作时间的
 * 方法都被声明为过时的(操作时间交给Calendar类完成)
 * 
 * @author adminitartor
 *
 */
public class DateDemo {

	public static void main(String[] args) {
		/**
		 * 默认实例化出来的Date表示当前系统时间
		 */
		Date now = new Date();
		//Date重写了toString方法
		System.out.println(now);
		
		/**
		 * Date大部分操作时间的方法都被声明为
		 * 过时方法，实际开发中这样的方法不要
		 * 再使用。
		 */
//		now.getYear();
		
		/**
		 * 获取Date内部维护long值，该值表示
		 * 自1970年元旦到当前Date表示的日期之间
		 * 所经过的毫秒
		 */
		long time = now.getTime();
		System.out.println(time);
		
		//查看25天以后是哪天?
		time += 25*1000*60*60*24L;
		
		now.setTime(time);
		System.out.println(now);

	}

}
