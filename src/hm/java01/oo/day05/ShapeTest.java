package hm.java01.oo.day05;

//求一组图形的最大面积
public class ShapeTest {
	public static void main(String[] args) {
    //Shape s = new shape();//编译错误。抽象类不能创建对象
    Shape[] shapes = new Shape[4];//创建Shape数组对象
    shapes[0] = new Circle(5);
    shapes[1] = new Circle(3);
    shapes[2] = new Square(6);	
    shapes[3] = new Square(8);	
    maxArea(shapes);	
}
    
public static void maxArea(Shape[] shapes){
	  double max = shapes[0].area();//获取第一个面积     假设最大
	  System.out.println(max);
	  int maxIndex = 0;//最大面积下标
	  for(int i=1;i<shapes.length;i++){
		  double area = shapes[i].area();
		  if(area>max){
			  max=area;
			  maxIndex=i;
		  }
		  System.out.println(area);
		  System.out.println(maxIndex);
		  System.out.println("循环了"+i+"次");
		  System.out.println();
	  }
	  System.out.println("最大面积是"+max+",下标为"+maxIndex);
}
}
abstract class Shape{
    protected double c;//本类 子类 同包类   周长
   	public abstract double area();//抽象方法
}
class Circle extends Shape{//圆形
	public Circle(double c){
		this.c=c;
	}
    public double area(){//重写抽象方法
    	System.out.println("圆形面积");
		return 0.0796*c*c;
	}
}
class Square extends Shape{//矩形
	public Square(double c){
		this.c=c;
	}
    public double area(){//重写抽象方法
    	System.out.println("矩形面积");
		return 0.0625*c*c;
	}
}

