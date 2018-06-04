package hm.java03.reflect;

/**
 * 反射
 */
class Point{
	private int x;
	private int y;
}
/**
 *  
 */
public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
    	//编译时就已经确定会创建哪个“类的对象“
    	//这个过程我们称之为 静态过程
		Point p1 = new Point();//类的实例(类的对象)
		
		//获取Point类的“类对象“  三种方式(第三种最终要)
		Class<?> c1 = p1.getClass();
		Class<?> c2 = Point.class;//类名.class
		//重点记住如下类的加载方式！！！！！！！！！！！！！！！！！！！
		Class<?> c3 = Class.forName("reflect.Point");//包名.类名
		
		System.out.println(c1 == c2);//true
		System.out.println(c2 == c3);//true
		//FAQ 类类加载时会有对应的加载器，
		//如何发现此类对应的类加载器是谁
		ClassLoader loader = c3.getClassLoader();
		System.out.println(loader);//AppClassLoader
		ClassLoader  pLoader = loader.getParent();
		System.out.println(pLoader);//ExtClassLoader
		ClassLoader ppLoader = pLoader.getParent();
		System.out.println(ppLoader);//null   返回值是:(BootstartClassLoader) C和C++写的
		
		//各加载器的职责
		//1.BootstarpClassLoader (jdk/jre/lib包中的jar文件)
		//2.ExtClassLoader(jdk/jre/lib/ext包中的jar文件) 
		//3.AppClassLoader(自己写的类)
		//类加载器拓展：我们也可以自定义类加载器(继承ClassLoader)
		
	}
}

















