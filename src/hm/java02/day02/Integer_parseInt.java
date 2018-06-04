package hm.java02.day02;
/**
 *  包装类有一个静态方法：parseXXX（String str）
 *  可以将给定的字符串转换为对应的基本类型。但是前提该字符串表示的内容
 *  是该基本类型可以保存的值。
 * @author soft01
 *
 */
public class Integer_parseInt {
	public static void main(String[] args) {
	String str = "123";
	
	int i = Integer.parseInt(str);
	System.out.println(i+1);
	
	double d = Double.parseDouble(str);
	System.out.println(d+1);
    
	} 
}