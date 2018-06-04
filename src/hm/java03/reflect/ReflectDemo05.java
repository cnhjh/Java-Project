package hm.java03.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectDemo05 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	//泛型只在编译时有效，运行时无效
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		Class<?> c = list.getClass();//
		Method m = c.getDeclaredMethod("add", Object.class);//方法对象
		m.invoke(list, 100);
		System.out.println(list);
	}
}
