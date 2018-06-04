package hm.java02.day02;
/**
 * JAVA 1.5的时候推出了一个新的特性
 * 自动拆装箱
 * 该特性是编译器认了的，而非虚拟认可。
 * 该特性的作用是编译器会在编译源代码时将基本类型与
 *  包装类之间补充代码进行转换，这样省区了程序员编写代码时在两者之间赋值时需要添加
 */

public class IntegerDemo3 {
	public static void main(String[] args) {
		/**
		 * 触发了自动拆箱特性
		 * 编译器会补充代码：
		 * int i = new Integer(123).intValue();
		 * 将包装类转换为基本类型
		 */
		int i = new Integer(123);
		System.out.println(i);
		
		/**
		 * 触发了自动装箱特性
		 * 编译器会补充代：
		 * Integer in = Integer.ValueOf(i);
		 * 将基本类型转换为包装类
		 */
		Integer in = i;
		System.out.println(in);

	}
}
