package hm.java02.day10;
/**
 * 静态方法的使用synchronized,那么一定是具有同步效果
 * 
 * 静态方法上锁的对象是该方所属的类对象
 * 实际上JVM在加载一个类的class文件时，会实例化一个Class类型的实
 * 例去保存该类的信息（属性，方法等）。所以JVM中每个加载过的类都有且只
 * 有一个Class的实例用于表示它，这个Class的实例就是该类的类对象
 * 
 * @author soft01
 *
 */
public class SyncDemo3 {
    public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				Boo.dosome();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				Boo.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}
class Boo{
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+"正在运行dosome");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t.getName()+"运行dosome方法完毕");
	}
}