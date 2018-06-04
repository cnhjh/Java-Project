package hm.java02.day01;
/**
 * int indexOf(String str)
 * 查找给定字符串在当前字符串中的位置。若当前字符串
 * 不含有给定的内容则返回值为-1
 * @author soft01
 *
 */
public class String_indexOf {

	public static void main(String[] args) {
		//              0123456789012345
		String str = "thinking in java";
         //查看“in”在当前字符串中的位置?
		int index = str.indexOf("in");
		System.out.println(index);
		
		//从指定位置开始检索
		index = str.indexOf("in",3);//从“n”开始  第4个
		System.out.println(index);
	
		//检索最后一次出现的位置
		index = str.lastIndexOf("in");
		System.out.println(index);
	}

}
