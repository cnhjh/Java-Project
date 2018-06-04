package hm.java02.day02;
/**
 * 用来测试Point重写Object的相关方法
 * @author soft01
 *
 */
public class TestPoint {
	public static void main(String[] args) {
	Point p = new Point();
	p.setX(1);
	p.setY(2);
	/**
	 * Object 定义了toString方法，该方法返回当前的句柄，即：类名@地址
	 * 通常情况下，我们需要使用一个类toString方法时
	 * 就应当重写该方法，返回一个更有意义的字符串
	 */
    String str = p.toString();
	//句柄
	System.out.println(p.toString());
    /**
     * System.out.println(Object)
     *  该方法输出给定对象toString返回的字符串到控制台
     */
    System.out.println(p);
    System.out.println(str);
   
    
    
	Point p2 = new Point();
	p2.setX(1);
	p2.setY(2);
	
	System.out.println(p2);
	System.out.println(p==p2);
	
	System.out.println(p.equals(p2));
	}
}
