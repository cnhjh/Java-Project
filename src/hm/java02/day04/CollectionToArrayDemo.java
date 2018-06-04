package hm.java02.day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合转换为数组
 * Collection提供了相关方法：toArray（）
 * 可以将当前集合转换为一个数组
 * @author soft01
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
	    Collection<String> c = new ArrayList<String>();
	    c.add("one");
	    c.add("two");
	    c.add("three");
	    c.add("four");
	    System.out.println(c);

	  //  Object[] array = c.toArray(); 不常用
	    String[] array = c.toArray(new String[c.size()]);
	    System.out.println("len:"+array.length);
	    for(String str : array){
	    	System.out.println(str);
	    }
	}
}
