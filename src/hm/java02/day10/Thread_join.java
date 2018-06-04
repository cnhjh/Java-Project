package hm.java02.day10;
/**
 * 线程提供了一个方法：join
 * join可以协调线程间同步运行。
 * @author soft01
 *
 */
public class Thread_join {
	//表示图片是否下载完毕
	private static boolean isFinish = false;
	
    public static void main(String[] args) {
    	/*
    	 * 当一个方法的局部局部内部类中需要引用该方法的其他局部变量时，该变量必须是final的
    	 * 
    	 * 在这里maim方法的局部内部类show中箱引用main方法的其他
    	 * 局部变量download，那么download就必须是final的
    	 * JDK1.8之后的内存问题被重新定义，不再有这个问题，所以就不再需要上述设定
    	 */
    	final Thread download = new Thread(){//局部匿名内部类
    		public void run(){
    			System.out.println("down:开始下载图片......");
    			for(int i=1;i<=100;i++){
    				System.out.println("down:"+i+"%");
    				try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
					   e.printStackTrace();
					}
    			}
    			System.out.println("down:下载完毕");
    			isFinish = true;
    		}
    	};
    	
    	Thread show = new Thread(){
    		public void run(){
    			System.out.println("show:开始显示图片！");
    			//先等待下载线程将图片下载完毕
    			/*
    			 * 当show线程调用download线程的join方法时，show线程进入阻塞状，
    			 * 直到download执行完毕才会解除阻塞继续执行后续代码
    			 */
    			try {
					download.join();//jdk1.8之前--语法要求download必须是final的 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    			
    			if(!isFinish){
    				throw new RuntimeException("图片没有下载完毕！");
    			}
    			System.out.println("show:图片显示完毕！");
    		}		
    	};
        download.start(); 
        show.start();
    	 
		
	}
}
