package hm.java03.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class Student{
	private String name;
	private int age;
	public Student(String name){
		this.name=name;
	}
	public Student(String name,int age){
		this(name);//this.name=name
		this.age=age;
	}
	
}
public class ReflectDemo03 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		//获得类对象
		Class<?> c1 = Class.forName("reflect.Student");
		//Object obj1 = c1.newInstance();
		//通过类对象获得构造函数对象
		Constructor<?> con1 = c1.getDeclaredConstructor(String.class);
		//通过构造函数对象构建类的对象
		Object ob1 = con1.newInstance("老胡"); 
		System.out.println(ob1);
		
		Constructor<?> con2 = c1.getDeclaredConstructor(String.class,int.class);
		Object obj2 = con2.newInstance("告白哥",18);
		System.out.println(obj2);
		//通过反射获得对象属性
		Field f1 = c1.getDeclaredField("name");
		//Field[] fs = c1.getDeclaredFields();
		//设置私有属性可访问
		f1.setAccessible(true);
		//获得ob2对象的f1属性的值
		Object f1Value = f1.get(obj2);
		System.out.println(f1Value);
		
		//设置ob2对象的f1属性的值
		f1.set(obj2, "传奇");
		f1Value = f1.get(obj2);
		System.out.println(f1Value);
		
	}

}


























