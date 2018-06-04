package hm.java02.day02;
/**
 * 包装类
 * java为8个基本类型分别定义了8个包装类
 * 包装类是为了解决基本类型不能直接参与面向对象开发的问题
 * @author soft01
 *
 */
public class IntergerDemo1 {
	public static void main(String[] args) {
	//基本类型转换为包装类
	Integer i1 = new Integer(1);
	Integer i2 = new Integer(1);
    System.out.println(i1==i2);
    System.out.println(i1.equals(i2));
    
    //  推荐使用valueOf进行转换
    Integer i3 = Integer.valueOf(127);
    Integer i4 = Integer.valueOf(127);
    System.out.println(i3==i4);
	System.out.println(i3.equals(i4));
	
	//Double的valueOf是直接new的
	Double d1 = Double.valueOf(1.1);
	Double d2 = Double.valueOf(1.1);
	System.out.println(d1==d2);
	System.out.println(d1.equals(d2));
	
	double d = d1.doubleValue();
	System.out.println(d);
	
	float f = d1.floatValue();
	System.out.println(f);
	
	int i = d1.intValue();
	System.out.println(i);
	}
}
