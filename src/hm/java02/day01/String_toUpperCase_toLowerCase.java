package hm.java02.day01;
/**
 * String_toUpperCase()
 * String_toLowerCase()
 * 将当前字符串中的英文部分转换为全大写和全小写
 * @author soft01
 *
 */
public class String_toUpperCase_toLowerCase {
    public static void main(String[] args) {
		String str = "我爱java";
		
		String upper = str.toUpperCase();//转换为大写
		System.out.println(upper);
	
		String lower = str.toLowerCase();//转换为小写
		System.out.println(lower);

	}
}
