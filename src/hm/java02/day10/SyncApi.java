package hm.java02.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 将集合或Map转换为线程安全的
 * @author soft01
 *
 */
public class SyncApi {
	public static void main(String[] args) {
		/*
		 * ArrayList,LinkedList都不是线程安全的
		 */
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("tow");
		list.add("three");
		/*
		 * 将给定的List集合转换为线程安全的
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		/*
		 * HashSet不是线程安全的
		 */
		Set<String> set = new HashSet<String>(list);
		//将给定的Set集合转换为线程安全的
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		/*
		 * HashMap也不是线程安全的
		 */
		Map<String,Integer> map = new HashMap<String,Integer>();
		//将给定的Map转换为线程安全的
		map = Collections.synchronizedMap(map);
		
		/*
		 * 线程安全的集合也不与迭代器遍历该集合的操作互斥。
		 * 但是迭代器要求遍历的过程中不断通过集合的方法增删元素，否则会抛出异常，
		 * 所有在多个线程间有这样的操作时，需要自行维护遍历集合与集合
		 * 元素操作间的互斥关系
		 */
	}
}
