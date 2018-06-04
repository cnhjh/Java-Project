package hm.java02.day02;
/**
 *  字符串支持正则表达式方法二：
 *  String[] split(String regex)
 *  当前字符串按照给定正则表达式满足的部分进行拆分
 *  将拆出来的各部分内容存入一个字符串数组并返回
 * @author soft01
 *
 */
public class String_split {
	public static void main(String[] args) {
	String str = "abc123def456ghi789jkl";
	String[] data = str.split("\\d+");
	System.out.println(data.length);
	for(int i=0;i<data.length;i++){
		System.out.println(data[i]);
	}

	}
}
