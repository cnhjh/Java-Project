package hm.java02.day09;
/**
 * 多线程
 * 多线程允许我们可以”同时“执行多行代码
 * 
 * 实际上多线程是并发运行的，即：JVM中的线程调度会为多个线程分配”CPU时间片“，
 * 并将这些时间尽了能均匀的分配给线程，当一个线程获取时间片后，该线程的任务代码
 * 被CPU执行，其他线程属于等待状态。这种宏观上同时运行而微观上走走停停的现象称为并发。
 * 
 * java中的线程是由Threead的创建的实例表示。
 * 而Threwad的创建有两种方式：
 * 1：继承Thread并重写run方法
 * 
 * 
 * @author soft01
 *
 */
public class TheradDemo1 {
    public static void main(String[] args) {
    	Thread t1 = new MyThread1();
    	Thread t2 = new MyThread2();
    	/*
    	 * 启动线程是调用线程的start方法，而不要直接调用run方法。
    	 * start方法的作用是将该线程纳入线程调度。一旦start方法执行完毕后，
    	 * 那么该线程的run方法会很快被运行（只要获取了CPU时间片）
    	 * 
    	 * 线程间是并发运行代码，两段代码间不存在先后运行概念。
    	 * 
    	 * 有先后顺序运行多段代码称为：同步执行（体现在单线程上）
    	 * 多线程在运行多段代码时是：异步运行（各自执行各自的）
    	 * 
    	 */
    	t1.start();
    	t2.start();
    	
	}
}
/**
 * 另一种创建线程的方式虽然定义简单，但也存在一些不足：
 * 1：由于java是单继承的，这经常导致在实际开发中，为了复用一个类的方法，
 *   我们需要继承那个类，而自身有希望是一个线程时导致的继承冲突。
 * 2：继承了线程需要重写run方法来定义该线程执行的任务代码，这样导致了线  
 *   程与执行的任务有一个必然的耦合关系，不利于线程的重用。
 * 
 * @author soft01
 *
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊？");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("我是查水表的！！！！！");
		}
	}
}
