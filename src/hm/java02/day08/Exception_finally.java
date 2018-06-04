package hm.java02.day08;
/**
 * finally块
 * finally块只能定义在异常捕获机制的最后一块
 * finally能确保无论try块中的代码是否抛出异常，finally块中的代码都会被执行。
 * 
 * 所以finally块中的代码通常都是无关乎程序是否报错都要运行的代码。
 * 比如在IO中，关闭流操作就应当放在finally块中确保执行。
 * @author soft01
 *
 */
public class Exception_finally {
	public static void main(String[] args) {
		System.out.println("程序开始了!");
		try{
			String str = "";
			System.out.println(str.length());
			
		} catch(Exception e){
			System.out.println("程序出错了！");
		} finally {
			System.out.println("finally中的代码运行了！");
		}
		
		System.out.println("程序结束了!");
	}
}
