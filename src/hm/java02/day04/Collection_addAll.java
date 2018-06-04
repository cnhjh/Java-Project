package hm.java02.day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 *  集合的集合操作
 * @author soft01
 *
 */
public class Collection_addAll {
	public static void main(String[] args){
	    Collection c1 = new HashSet();
	    c1.add("java");
	    c1.add("c++");
	    c1.add("php");
	    System.out.println(c1);
	    
	    Collection c2 = new ArrayList();
	    c2.add("c#");
	    c2.add(".net");
	    c2.add("java");
	    System.out.println(c2);
	    /**
	     * boolean addAll（Collection c)
	     * 将给定集合中的所有元素添加到当前集合中
	     * 
	     */
	    boolean tf = c2.addAll(c1);
	    System.out.println(c2+":"+tf);
	    
	    Collection c3 = new ArrayList();
	    c3.add("c#");
	    c3.add("c++");
	    c3.add("android");
	    System.out.println("c3:"+c3);
	    /**
	     * boolean containsAll(Collection c)
	     * 判断当前集合是否包含给定集合中所有元素
	     */
	    boolean contains = c2.containsAll(c3);
	    System.out.println("全包含："+contains);
	    //removeAll
	    c2.removeAll(c3);
	    System.out.println(c2);

	}
}
