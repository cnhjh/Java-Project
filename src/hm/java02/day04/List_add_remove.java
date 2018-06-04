package hm.java02.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List支持使用下标操作元素方法二
 * @author soft01
 *
 */
public class List_add_remove {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
	    list.add("one");
	    list.add("two");
	    list.add("three");
	    list.add("four");
	    System.out.println(list);

	    /**
	     * void add（int index,E e)
	     * 将给定元素插入到指定位置
	     */
	    //[one,2,tow,three,four]
	    list.add(1,"2");
	    System.out.println(list);
	
	    
	    /**
	     * E remove(int index)
	     * 将给定位置的元素从集合中删除并将该元素返回
	     */
	    //[one,2,three,four]
	    String old = list.remove(2);
	    System.out.println(list);
	    System.out.println(old);
	 
	    
	}
}
