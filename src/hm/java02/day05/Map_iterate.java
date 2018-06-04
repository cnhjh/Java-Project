package hm.java02.day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map的遍历
 * 遍历Map有三种方式：
 * 1：遍历所有的kep
 * 2：遍历每一组键值kep_Value对（Entry）
 * 3：遍历所有的Value（不常用）
 * @author soft01
 *
 */
public class Map_iterate {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();//有序LikedHashMap
		//      key   value
		map.put("语文",99);
		map.put("数学",98);
		map.put("英语",99);
		map.put("物理",97);
		map.put("化学",96);
		/**
		 * 遍历所有的key：
		 * Set<K> keySet()
		 * 将当前Map中所有的key以一个Set集合形式返回
		 * 所以遍历这个Set集合就等同于遍历了所有的key
		 */
		Set<String> keySet = map.keySet();
		for(String key:keySet){
			System.out.println("key:"+key);
		
		}
		/**
		 * 获取每一组键值对
		 * 在Map内部，每一组键值对是用Map内部类Entry的实例表示的（Entry是接口，
		 * 不同的Map实现类都实现了Entry用于表示一组键值对）
		 * Set<Entry> entrySet（）
		 * 将当前Map中所有的键值随（若干Entry实例）存入一个Set集合并返回。
		 */
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		for(Entry<String,Integer> e : entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
			
			//System.out.println("key:"+value);
			System.out.println();
			System.out.println("key:"+key);
			System.out.println("value:"+value);
		}
		
		
		/**
		 * 遍历所有value
		 * Collection<V> valuse()
		 * 将当前Map中所有的vlaue存入一个集合后返回 
		 */
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println("value:"+value);
		}

	}
}
