package hm.java02.day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * 遍历集合元素
 * 
 * Collection提供用于遍历集合元素的方法:
 * 该方法会返回一个可以用于遍历当前元素的迭代器
 * 
 * java.util.Iterator
 * 迭代器，本身是一个接口，规定了所有迭代器遍历集合的统一方法，
 * 不同的几个实现类都提供类一个迭代器的实现类用于遍历自身，
 * 我们无需关注具体迭代器的名字，只需要将它看做是Iterator使用即可
 * 
 * 使用迭代器遍历集合遵循：
 * 问，取，删的步骤
 * 其中删除操作不是必须的
 * @author soft01
 *
 */
public class Collection_iterator {
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
		//遍历集合
		Iterator it = c.iterator();
		/**
		 * boolean hasNext(）
		 * 通过迭代器判断集合是否还有元素可以遍历
		 */
		while(it.hasNext()){
			/**
			 * E next（）
			 * 取出集合中下一个元素
			 */
			String str = (String)it.next();
			System.out.println(str);
			
			if("#".equals(str)){
				/**
				 * 使用迭代器遍历集合的过程中
				 * 不能通过集合的方法增删元素
				 * 否则迭代器在下次遍历元素时会抛出异常。
				 * 可以通过迭代器提供的remove方法删除
				 * 通过next获取的元素
				 */
				//c.remove(str);
				it.remove();
				
			}
		}
		
		System.out.println(c);
		

	}
}
