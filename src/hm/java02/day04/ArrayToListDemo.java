package hm.java02.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * 数组转换为集合使用数组的工具类Arrays，其提供类一个静态方法asList
 * 需要注意，只能转换为List集合
 * @author soft01
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
	    String[] array = {"one","two","three","fuor"};
	    List<String> list = Arrays.asList(array);
	    System.out.println(list);
	    
	    //对集合元素操作就是对原数组对应元素的操作
	    list.set(1, "2");
	    System.out.println(list);
	    for(String str : array){
	    	System.out.println(str);
	    }
	    
	    /**
	     * 不可以直接添加元素，这会导致原数组扩容，而扩容就不能标示
	     * 原数组，所以这样的操作不受支持
	     */
	    //list.add("five");
	    //System.out.println(list);
	   /**
	    * 向添加元素，需另行创建一个新集合
	    */
       List<String> list2 = new ArrayList<String>(list);
       System.out.println("list2:"+list2);
       list2.add("five");
       System.out.println("list2:"+list2);
	}
}
