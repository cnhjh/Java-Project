package hm.java02.day09;
/**
 * 用匿名内部类完成线程的两种方式创建
 * 
 * @author soft01
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//方式一：
		new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("你是谁啊？");
				}
			}	
		}.start();
		
		//方式二：
		new Thread(new Runnable(){
		public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("我是来打劫的！！");
		}
	    }
      }) .start();
	

		
		
//		Thread t2 = new Thread(){
//			public void run(){
//				for(int i=0;i<1000;i++){
//					System.out.println("我是你老母！！");
//				}
//			}
//		};
//	  t1.start();
//		t2.start();
	}
}
