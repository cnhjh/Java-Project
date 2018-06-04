package hm.java02.day08;

/**
 * finally两道面试题: 
 * 面试题1:见下面的代码
 * 
 * 面试题2:请简述:final,finally,finalize
 * 
 * @author soft01
 *
 */
public class Demo1 {
	/*
	 * finalize方法是Object定义的方法该方法时GC在 
	 * 当前对象即将被回收时调用。意味着该方法执行后当
	 * 前对象就被GC释放资源。
	 * 
	 */
	protected void finalize() throws Throwable {
	}
	
	public static void main(String[] args) {
		System.out.println(test("0") + "," + test("") + "," + test(null)
		);
	}
	public static int test(String str) {
		try {
			return 0;
		} catch (StringIndexOutOfBoundsException e) {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}
}
