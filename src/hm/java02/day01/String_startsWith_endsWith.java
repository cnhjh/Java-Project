package hm.java02.day01;
/**
 * boolean startsWith(String str)
 * boolean endsWith(String str)
 * 判断当前字符串是否以给定的字符串开始或结尾
 * @author soft01
 *
 */
public class String_startsWith_endsWith {
	public static void main(String[] args) {
	    String str = "thing in java";
	    
	    boolean starts = str.startsWith("thi");
	    System.out.println("starts:"+starts);
	    
	    boolean ends = str.endsWith("ava");
	    System.out.println("ends:"+ends);
	    
	}
}
