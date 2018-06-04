package hm.java02.day10;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池、线程池主要解决两个问题：
 * 1：控制线程数量。因为线程数多了，会导致内存开销大，严重时会
 *   导致系统瘫痪，并且由于线程数量会导致CPU过度切换，拖慢系统响应
 * 2：重用线程
 * @author soft01
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
	//	BlockingQueue<String> queue = new linkedBlockingQueu();
		//创建固定大小线程
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable runn = new Runnable(){
				public void run(){
					
					try {
						Thread t = Thread.currentThread();
						System.out.println(t.getName()+"正在执行任务！");
						Thread.sleep(5000);
						System.out.println(t.getName()+"任务执行完毕--------");
					} catch (InterruptedException e) {
						System.out.println("线程被中断了！");
					}
				}
			};
		    threadPool.execute(runn);
			System.out.println("指派了一个任务给线程池");

		}
     	threadPool.shutdown();//
		System.out.println("停止线程池！");
	}

}
