package hm.java02.day10;
/**
 * 守护线程
 * 守护线程也称为后台线程
 * 
 * 默认建出来的线程都是前台线程，若设置为后台线程可以通过线程提供的方法setDaemon来完成。
 * 
 * 后台线程使用上与前台线程一样，但是在结束时机上有一点不同的.即：
 * 当一个进程结束时，所有正在运行的后台线程都会强制结束。而进程的结
 * 束是当一个进程中所有前台线都结束时结束。
 * 
 * 所以将来开发中可以将一直保持运行的任务，但是可以随着程序一同结束的放在后台线程上运行。
 * @author soft01
 *
 */
public class Thread_setDaemon {
	public static void main(String[] args) {
		Thread  rose = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {	
					}
				}
				System.out.println("rose:啊啊啊啊啊啊啊啊aaaaa");
				System.out.println("呱了!");
			}
		};
		
		Thread jack = new Thread(){
			public void run(){
				while(true){
					System.out.println("jack:you jump!i jump");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {		
					}
				}
			}	
		};
		
	
		rose.start();
		/*
		 * 设置为守护线程必须在线程启动前完成
		 */
		jack.setDaemon(true);
		jack.start();
 
	}
}
