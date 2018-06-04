package hm.java02.day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程提供了一个静态方法 static void sleep(long ms) 该方法将运行当前方法的线程阻塞指定毫秒
 * 
 * @author soft01
 *
 */
public class Thread_sleep {
	public static void main(String[] args) {
		
    	
    	/*
    	 * 实现电子表功能
    	 * 每秒钟在控制台输出系统时间，格式：
    	 * 16：55：32
    	 */

    	while(true){
            try {
            	System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
          }
		
//		Date now = new Date();
//    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//    	while(true){
//        try {
//        	String str = sdf.format(now);
//        	System.out.println(str);
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//      }
    	
    	
    	  
	}
}
