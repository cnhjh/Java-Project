package hm.java02.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将一个字符串解析为Date
 * @author adminitartor
 *
 */
public class SimpleDateFormat_parse {

	public static void main(String[] args)throws ParseException {
		String str = "2008-08-08 20:08:08";
		
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*
		 * String->Date
		 * 将给定的字符串按照SimpleDateFormat指定的
		 * 日期格式解析为一个Date对象
		 */
		Date date = sdf.parse(str);
		
		System.out.println(date);//Fri Aug 08 20:08:08 CST 2008


	}

}
