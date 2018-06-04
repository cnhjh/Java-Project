package hm.java02.day04;
/**
 * 测试泛型的使用
 * @author soft01
 *
 */

public class TestPosition {
	public static void main(String[] args) {
	
	    Position <Integer> p1 = new Position<Integer>(1,2);
	
		System.out.println("p1:"+p1);
	    p1.setX(2);
	    int x1 = p1.getX();
	    System.out.println("x1："+x1);
	    System.out.println("p1:"+p1);

	    Position <Double> p2 = new Position<Double>(1.1,2.2);
	    System.out.println("p2:"+p2);
	    p2.setX(2.2);
	    double x2 = p2.getX();
	    System.out.println("x2："+x2);
	    System.out.println("p2:"+p2);
	    
	    Position <String> p3 = new Position<String>("一","二");
	    System.out.println("p3:"+p3);
	    p3.setX("二");
	    String x3 = p3.getX();
	    System.out.println("x3："+x3);
	    System.out.println("p3:"+p3);
	    
	}
}
