package hm.java02.day10;
/**
 * 互拆锁
 * 
 * @author soft01
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Foo foo = new Foo();
		Thread t1 = new Thread(){
				public void run(){
					foo.methodA();
				}
		};
		Thread t2 = new Thread(){
			public void run(){
				foo.methodB();
			}
	    };
		t1.start();
		t2.start();
	}
}
class Foo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+"正在运行A方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t.getName()+"运行A方法完毕");
	}
	public  void methodB(){
		Thread t = Thread.currentThread();
		synchronized(this){
		System.out.println(t.getName()+"正在运行B方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t.getName()+"运行B方法完毕");
		}
	}
}