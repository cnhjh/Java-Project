package hm.java02.day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 删除集合元素
 * boolena remove（E e）
 *   
 * @author soft01
 *
 */
public class Collection_remove {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(1,2));
		System.out.println(c);
		
		Point p = new Point(1,2);

		/**
		 * remove方法也是根据元素equals比较的结果进行删除的。
		 */
		c.remove(p);//remove只删除一个
		System.out.println("删除完毕!");
		System.out.println(c);

	}
}
