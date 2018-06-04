package hm.java02.day08;
/**
 * 异常常用方法
 * @author soft01
 *
 */
public class Exception_API {
    public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "abc";
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			//输出错误堆栈信息
		//	e.printStackTrace();
			
			//获取错误信息
			String message = e.getMessage();
			System.out.println(message);//给用户看
		}
		System.out.println("程序结束了");
    	
	}
}
