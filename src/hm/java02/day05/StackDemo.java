package hm.java02.day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 栈也可以存储一组元素，但是存取元素必须遵循先进后出原则。
 * （FILO）first input 
 * @author soft01
 *
 */
public class StackDemo {
	public static void main(String[] args) {
       Deque<String> stack = new LinkedList<String>();
       /**
        * 入栈操作
        */
       stack.add("one");
       stack.add("two");
       stack.add("three");
       stack.add("four");
       System.out.println(stack);
       
       //出栈操作
       String str = stack.pop();
       System.out.println(str);
       System.out.println(stack);
       
       while(stack.size()>0){
    	   str = stack.pop();
    	   System.out.println(str);
       }
       System.out.println(stack);

	}
}
