package hm.java02.day01;

/**
 * int length()
 * 返回当前字符串的长度（字符串个数）
 * 无论文字是英文还是中文，每个字符算一个长度
 * @author soft01
 *
 */
public class String_length {
    public static void main(String[] args) {
	String str = "我爱java";
	int len = str.length();
	System.out.println("len:"+len);//len:6
    }

}
