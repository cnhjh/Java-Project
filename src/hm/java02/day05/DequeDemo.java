package hm.java02.day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  双端队列
 *  双端队列接口继承自Queue 接口
 *  常用实现类：java.util.LinkedList
 *  所谓双端队列就是两端都可以做入队=和出队操作
 * @author soft01
 *
 */
public class DequeDemo {
	
	public static void main(String[] args) {
	    Deque<String> deque = new LinkedList<String>();
	    
	    deque.offer("one");
	    deque.offer("two");
	    
	    System.out.println(deque);
	    
	    deque.offerFirst("three");
	    System.out.println(deque);
	    
	    String str = deque.poll();
	    System.out.println(str);
	    System.out.println(deque);
	    
	    str = deque.pollFirst();
	    System.out.println(str);
	    System.out.println(deque);
	    
	    str = deque.pollLast();
	    System.out.println(str);
	    System.out.println(deque);
	    //////////
	    //deque.pollLast("four");
	    	
	    

	}
}
