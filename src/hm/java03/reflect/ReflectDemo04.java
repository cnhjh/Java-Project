package hm.java03.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Teacher{
	private String name;
	public void setName(String naem){
		this.name = name;
	}
	public String getName(){
		return name;
	}
			
}
public class ReflectDemo04 {
   public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
	  Class<?> c1 = Class.forName("reflect.Teacher");
	  Object obj1 = c1.newInstance();
	  //通过类对象获得方法对象
	  Method m1 = c1.getDeclaredMethod("setName", String.class);//构建参数对象(方法对象)
	  //执行方法对象(动态执行)
	  //执行obj1对象的m1方法，传参为“傻逼”
	  Object result = m1.invoke(obj1, "傻逼");
	  Method m2 = c1.getDeclaredMethod("getName");
	  //执行obj1对象m2方法
	  result = m2.invoke(obj1);
	  System.out.println(result);
	  
	  
	  
}
}




























