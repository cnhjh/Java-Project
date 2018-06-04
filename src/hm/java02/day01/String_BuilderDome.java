package hm.java02.day01;


/**
 * java.lang.StringBuilder
 * 由于String在java中的优化倾向于重用性，这就导致频繁
 * 修改字符串对于性能的损耗是非常可观的。为此，java提供
 * 了一个专门用来修改字符串内容的类:StringBuilder
 * StringBuilder内部维护一个可变的字符数组，所有操作
 * 均在该数组中完成。速度快，内存消耗小。
 * StringBuilder提供了一套用于修改字符串内容的方法。
 * 所以在实际开发中，所有修改字符串操作都应当使用
 * StringBuilder来完成。
 * 
 * @author adminitartor
 *
 */
public class String_BuilderDome {

	public static void main(String[] args) {
		String str = "好好学习java";
		StringBuilder builder = new StringBuilder(str);
		/**
		 * 好好学习java
		 * 好好学习java，为了找个好工作
		 * StringBuilder  append（string str)
		 * 向当前字符串末尾追加给定内容
		 */
		builder.append(",为了找个好工作");
		//打桩
		str = builder.toString();
		System.out.println(str);//好好学习java,为了找个好工作
		System.out.println(builder.toString());//好好学习java,为了找个好工作
		
		/**
		 *  好好学习java，为了找个好工作
		 *  好好学习java，就是为了改变世界
		 *  
		 *  Stringbuilder replace(int s ,int e,String str)
		 *  当前字符串中指定范围内的内容替换为给定的
		 *  字符串
		 */
		builder.replace(9, 16,"就是为了改变世界");
		System.out.println(builder.toString());//好好学习java,就是为了改变世界
		
		/**
		 *  好好学习java，就是为了改变世界
		 *  就是为了改变世界
		 *   Stringbuilder delete(int s,int e)
		 *   将当前字符串中指定范围内的字符串删除
		 */
		builder.delete(0,9);
		System.out.println(builder.toString());//就是为了改变世界
		
		/**
		 * 就是为了改变世界
		 * 活着，就是为了改变世界
		 * Stringbuilder insert(0,"活着,")
		 * 在指定位置插入指定内容
		 */
		builder.insert(0, "活着,");
		System.out.println(builder.toString());//活着,就是为了改变世界
		
		/**
		 * 反转字符串
		 */
		builder.reverse();//反转字符串
		System.out.println(builder.toString());//界世变改了为是就,着活
		
		builder.setLength(1);
		System.out.println( "builder="+builder.toString());
	}

}
