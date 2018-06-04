package hm.java02.day01;
/**
 * String trim()
 * 去除字符串两边的空白字符
 * @author soft01
 *
 */
public class String_trim {
	public static void main(String[] args) {
	    String str = "  hello         ";
	    System.out.println(str);
	  
	    str = str.trim();//去除字符串两边的空白字符
        System.out.println(str);
	}
}
