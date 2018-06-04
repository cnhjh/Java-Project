package hm.java02.day04;
/**
 *  增强for循环 又称为：新循环， for each
 *  该循环是自JDK1.5以后推出的一个新的特性
 *  新循环只用来遍历集合或数组使用
 * @author soft01
 *
 */
public class NewForDemo1 {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four","five"};
		
		for(int i=0;i<array.length;i++){//老方法
			String str = array[i];
			System.out.println(str);
		}
		System.out.println();//
		
		for(String str:array){  //使用新循遍历数组
			System.out.println(str);
		}

	}
}
