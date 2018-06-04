package hm.java02.day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.SynchronousQueue;

/**
 * boolean contains(E e)
 * 判断当前集合是否包含给定元素
 * @author soft01
 *
 */
public class Collection_contains {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		System.out.println(c);
		
		Point p = new Point(1,2);
		/**
		 * 集合判断给定元素是否包含的标准是看给定元素与集合现
		 * 有元素是否存在equals比较为true的。有，则认为包含
		 */
		boolean contains = c.contains(p);
		System.out.println("contains:"+contains);
		

	}
}
