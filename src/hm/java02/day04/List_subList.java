package hm.java02.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取List的子集
 * @author soft01
 *
 */
public class List_subList {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
         System.out.println(list);
         
         /**
          * List subList(int start,int end)
          * 获取指定范围内子集                            
          */
         List<Integer> subList = list.subList(3, 8);//含头不含尾
         System.out.println("sub:"+subList);
         
         //将子集所有元素扩大10倍
         for(int i=0;i<subList.size();i++){
        	 subList.set(i, subList.get(i)*10);
         }
         System.out.println("sub:"+subList);
         /**
          * 对子集的操作就是对原集合对应元素的操作
          */
         System.out.println(list);
         
         /**
          * 将集合中2-8元素删除
          * .clear()//删除
          */
         list.subList(2,9).clear();
         System.out.println(list);
	}
}
