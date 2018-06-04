package hm.java02.day02;


/**
 * String replaceAll(String regex.String String)
 * 将给定字符串中满足正则表达式的部分替换为指定字符串
 * @author soft01
 *
 */
public class String_replanceAll {

	public static void main(String[] args) {
	String str = "abc123def456ghi789jkl";
	/**
	 * 将数字部分替换为"#NUMBER#"
	 */
	String str1 = str.replaceAll("\\d+", "#NUMBER#");
	System.out.println(str1);
	
	/**
	 *将字母部分替换为"#CHAR#"
	 */
	
	String str2 = str.replaceAll("[a-zA-Z]+", "#CHAR#");
	System.out.println(str2);
	
	
	
	}

}
