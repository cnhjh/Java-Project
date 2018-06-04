package hm.java02.day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型在集合中的应用
 * 泛型用来规定集合中的元素类型
 * @author soft01
 *
 */
public class CollectionDome {
	public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        System.out.println(c);
        
        Iterator<String> it = c.iterator();
        while(it.hasNext()){
        	String str = it.next();
        	System.out.println(str);
        }
        
        for(String str : c){
        	System.out.println(str);
        }

	}

}
