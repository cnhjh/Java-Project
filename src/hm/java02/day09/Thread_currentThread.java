package hm.java02.day09;
/**
 * 线程提供了一个静态方法:
 * static Thread currentThread（）
 * 该方法可以获取运行这个方法的线程
 * 
 * java中所有代码都是靠线程运行的，main方法也不利外。
 * 只不过运行main方法的线程不是有我们创建的。
 * 
 * @author soft01
 *
 */
public class Thread_currentThread {
    public static void main(String[] args) {
    	//获取运行main方法的线程
    	Thread main = Thread.currentThread();
    	System.out.println("运行main方法的线程是："+main);
    	dosome();
   
  	Thread t = new Thread(){
		public void run(){
			Thread t = Thread.currentThread();
					System.out.println("自定义线程:"+t);
					dosome();
		}
	};
  	t.start();
    }
    
	public static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println("运行dosome的方法的线程是:"+t);
	}
  
}
