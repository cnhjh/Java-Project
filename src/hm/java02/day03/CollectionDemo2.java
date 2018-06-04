package hm.java02.day03;

import java.util.ArrayList;
import java.util.Collection;

import hm.java02.day02.Point;

/**
 * 集合存放的是元素的引用
 * @author adminitartor
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();	
		Point p = new Point();
		p.setX(1);
		p.setY(2);
		//将p对象存入集合
		c.add(p);		
		System.out.println("c:"+c);
		System.out.println("p:"+p);		
		p.setX(2);
		System.out.println("p:"+p);
		System.out.println("c:"+c);//[(?,2)]

	}
}
