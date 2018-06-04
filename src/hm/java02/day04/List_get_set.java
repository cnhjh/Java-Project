package hm.java02.day04;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

/**
 * java.util.list
 * list集合是可重复集。且有序
 * 提供了一套可以通过下表操作元素的方法
 * @author soft01
 *
 */
public class List_get_set {
	public static void main(String[] args) {
		//List<String> list = new LinkedList<String>();
		List<String> list = new ArrayList<String>();
	    list.add("one");
	    list.add("two");
	    list.add("three");
	    list.add("four");
	    System.out.println(list);
	    
	    /**
	     * E get(int index)
	     * 获取给定下标处对应的元素
	     */
	    //获取第二个元素
	    String str = list.get(1);
	    System.out.println(str);
	    
	    for(int i=0;i<list.size();i++){
	    	str = list.get(i);
	    	System.out.println(str);
	    }
	    
	    System.out.println();//
	    
	    /**
	     * E set(int i,E e)
	     * 替换元素操作
	     * 将给定元素设置到指定位置，返回值为原位置对应的元素
	     */
	    String old = list.set(2, "三");
	    System.out.println(list);
	    System.out.println(old);

	}
}
