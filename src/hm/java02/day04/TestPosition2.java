package hm.java02.day04;

/**
 *  泛型1.5推出的新型特性
 *  泛型也是编译器认可，而非虚拟机认可的
 *  泛型的原型就是Object
 *  泛型只是编译器在编译源代码时帮我们做了些事情：
 *  1:检查实参是否与泛型类型一致
 *  2:获取泛型数据时帮助进行类型转换
 * @author soft01
 *
 */
public class TestPosition2 {
    public static void main(String[] args) {
    // 泛型眼球传递实参必须与泛型一致（编译器会检查）
	Position<Integer> p1 = new Position<Integer>(1,2);
	p1.setX(2);//编译器依然检查
	/**
	 * 由于p1
	 */
	int x1 = p1.getX();
	System.out.println("x1:"+x1);//2
	
	//泛型不指定时就使用原型：Object
	Position p2 = p1;
    System.out.println("x2:"+p2.getX());//2
    
    p2.setX("二");
    System.out.println("x2:"+p2.getX());//二
    
    x1 = p1.getX();//类造型异常
    System.out.println("x1:"+x1);
    
    }
    
}
