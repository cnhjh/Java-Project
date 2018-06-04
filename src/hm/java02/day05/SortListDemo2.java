package hm.java02.day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序含有自定义类型元素的List集合
 * @author soft01
 *
 */
public class SortListDemo2 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();

		list.add(new Point(3,4));
		list.add(new Point(2,7));
		list.add(new Point(1,1));
		list.add(new Point(5,8));
		list.add(new Point(4,2));
		System.out.println(list);
		/**
		 * sort 方法需要集合元素必须实现Comparable接口，否则无法排序
		 */
		Collections.sort(list);
		System.out.println(list);
	}
}
