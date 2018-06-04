package hm.java02.day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列，存取元素必须遵循先进先出原则
 * 常用实现类：LinkedList
 * @author soft01
 *
 */
public class QeuueDemo {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		/**
		 * boolean offer（E e）
		 * 将给元素进行“入队”操作，将元素添加到队列末尾
		 */
            queue.offer("one");
            queue.offer("two");
            queue.offer("three");
            queue.offer("four");
            System.out.println(queue);
            
            /**
             * E poll（）
             * 从对列获取元素（出队操作）
             * 执行后该元素会从队列中删除
             */
            String str = queue.poll();
            System.out.println(str);
            System.out.println(queue);
            
            /**
             * E peek()
             * 引用首元素（获取首元素后并不会将该元素从队列中删除）
             *
             */
            str = queue.peek();
            System.out.println(str);
            System.out.println(queue);
            
            //使用迭代器遍历队列
            for(String s:queue){
            	System.out.println(s);
            }
            System.out.println(queue);
            
            //自行遍历则是一次性
            while(queue.size()>0){
            	String e = queue.poll();
            	System.out.println(e);
            }
            System.out.println(queue);
	}
}
