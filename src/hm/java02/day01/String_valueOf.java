package hm.java02.day01;
/**
 * String提供了一系列重载的valueOf方法
 * valueOf是静态方法，作用是将java其他类型转换为字符串
 * @author soft01
 *
 */
public class String_valueOf {
	public static void main(String[] args) {
		int i= 123;
		String istr = String.valueOf(i);
		System.out.println(istr+4);
		
		double d= 123.123;
		String dstr = String.valueOf(d);
		System.out.println(dstr+4);
		
		istr = i+"";
		//System.out.println();

	}
}
