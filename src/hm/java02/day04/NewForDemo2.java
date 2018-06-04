package hm.java02.day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 使用新循环遍历集合
 * @author soft01
 *
 */
public class NewForDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		c.add("#");
		c.add("five");
		System.out.println(c);
		/**
		 * 新循环并非新的语法，这是编译器认可而非虚拟机认可的。
		 * 编译器在编译源代码时发现使用新循环集合时会将代码改变为使用迭代器遍历
		 * 所以需要注意，使用新循环遍历集合时不要使用集合的方法修给元素
		 */
		for(Object o:c){//使用新循环遍历集合
			String str = (String)o;
			System.out.println(str);
		//	if("#".equals(str)){
		//		c.remove(str);
		//	}
		}
		//System.out.println(c);
	}
}
