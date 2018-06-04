package hm.java02.day03;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * 该类可以按照给定的日期格式将Date与String之间
 * 相互转换。
 * @author adminitartor
 *
 */
public class SimpleDateFormat_format {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);		
		/*
		 * 希望按照:
		 * 2017-07-25 10:30:22
		 * yyyy-MM-dd HH:mm:ss
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*
		 * Date->String
		 * 
		 * String format(Date date)
		 * 按照SimpleDateFormat指定的日期格式将
		 * 给定的Date转换为字符串
		 */
		String str = sdf.format(now);
		System.out.println(str);

	}

}
