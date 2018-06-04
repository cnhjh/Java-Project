package hm.java01.oo.day02;

import java.util.concurrent.SynchronousQueue;

public class TJTest {
    public static void main(String[] args) {
	T t = new T(2,5);
	t.print();
	
    System.out.println("下落后：");
	t.drop();
	t.print();
	
	System.out.println("左移后:");
	t.moveLeft();
	t.print();
	}

}
