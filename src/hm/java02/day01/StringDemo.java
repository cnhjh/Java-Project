package hm.java02.day01;
/**
 * String 是不变对象
 * 即：字符串对象一旦创建内容是不可改变的，改变一定要创建新对象
 * JVM对字符串有一个优化：字符串常量池
 * 字符串常量池中会有缓存所有使用字面量形式创建的字符串
 * 对象，一旦发现再次使用己有的字面量创建字符串时会
 * 直接重用自己创建对象。避免内存中出现大量内容一样的字符串对象，
 * 减少内存开销。
 * @author soft01
 *
 */
public class StringDemo {
	public static void main(String[] args) {
	String s1 = "123abc";
	String s2 = "123abc";//重用s1对象
	String s3 = "123abc";//重用s1对象

	System.out.println(s1==s2);//true
	System.out.println(s1==s3);//true
	
	s1 = s1+"!";//修改内容会创建新的对象
	System.out.println(s1);
	System.out.println(s1==s2);//false
	
	/**
	 * 编译器有一个优化措施，当发现一个计算表达式
	 * 所有参与运算的值都是字面量，那么就直接进行
	 * 计算并将结果编译到class文件中。所以下面的
	 * 代码在slass文件中的字样是:
	 * String s4 = "123abc";
	 * 
	 */
	String s4 = "123"+"abc";
	System.out.println(s2+","+s4);
	System.out.println(s2==s4);//true
	
	}
}
