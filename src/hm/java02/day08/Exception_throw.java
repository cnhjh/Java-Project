package hm.java02.day08;
/**
 * throw 用于抛出一个异常
 * 通常两种情况会要求抛出一个异常：
 * 1：当前方法中出现了一个满足语法要求，但是不满足业务逻辑要求的情况时， 
 *   可以当做一个异常抛出给调用者，通知其这样的操作不允许。
 * 2：当前方法代码中确实出现了异常，但是该异常不应当有当前方法来解决时可以将其抛给调用者
 * @author soft01
 *
 */
public class Exception_throw {
	public static void main(String[] args) {
		Persons p = new Persons();
		/*
		 * 当调用的一个方法好友throws声明异常抛出时，编译器会检查调用
		 * 该方法的代码有没有处理该异常，没有则编译不通过。
		 * 1：通过try-catth捕获该异常
		 * 2：在当前方法上继续使用shrows声明该异常的抛出
		 */
		try {
			p.setAge(50);
		} catch (IllegalAgeException e) {
			e.printStackTrace();
		}
	System.out.println(p.getAge());          	
	}
}
class Persons{
	private int age;
	
	public int getAge(){
		return age;
	}
	public void setAge(int age) throws IllegalAgeException{
		if(age<0 || age>100){
			/*
			 * 当一个方法中使用throw抛出一个异常时（除了RuntimeException及其子类异常）
			 * 编译器要求必须在该方法上使用throws声明这类异常的抛出。否则编译不通过
			 */
			throw new IllegalAgeException("年龄不合法");
			//throw new RuntimeException("年龄不合法");//运行时异常
		}
		this.age = age;
	}
	
}
    
