package hm.java02.day09;
/**
 * 线程优先级
 * 对于线程调度工作，线程不能干涉，即:
 * 线程只能被动的等待分配CPU时间片，而不能主动获取。
 * 可以通过修改线程优先级来最大程度改善获取CPU时间片的几率，
 * 理论上，线程优先级越高的线程获取CPU时间片的次数越多。
 * 线程的优先级有10个级，分别用整数1-10表示，
 * 其中最低1级，最高10级，5为默认值。
 * @author soft01
 *
 */
public class Thread_setPriority {
    public static void main(String[] args) {
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("max");
				}
			}
		};
		
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("min");
				}
			}
		};
		
		Thread nor = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("nor");
				}
			}
		};
		
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MAX_PRIORITY);

		
		max.start();
		min.start();
		nor.start();
	}
}
