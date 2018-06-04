package hm.java02.day11Demo;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;



/**
 * 聊天室客户端
 * 
 * @author soft01
 *
 */
public class Client {
     private Socket socket;//Socket电话
     
     //构造方法 初始化客户端 
     public Client() throws Exception{
    	 
    	/*
    	 * 实例化Socket需要传入参数 IP地址和端口
    	 */
    	 try {
			socket = new Socket("localhost",8088);//新建端口
		} catch (Exception e) {
			//记录日志
			throw e;
		}
    	 
     }
     //客户端开始工作方法
     public void start(){
    	 try {
    		 //获取用户输入
    		 Scanner scanner = new Scanner(System.in);
			/**
			 * Socket提供的方法：
			 * OutputStream getOutputStream()
			 * 获取输出流写数据通过网络发送给远端计算机
			 */
    		 OutputStream out = socket.getOutputStream();
    		 PrintWriter pw = new PrintWriter(  //缓冲字符输出流
                         new OutputStreamWriter(out,"UTF-8"),true//转换输出流  字符转字节
    				 );
    		 //接受客户端发送过来的线程启动
    		 ServerHandler handler = new ServerHandler();
    		 Thread t = new Thread(handler);
    		 t.start();

    		 System.out.println("开始骚聊啦！！！！！");
    		 String massage = null;
    		 long time = System.currentTimeMillis()-500;
    		 while(true){
    			 massage = scanner.nextLine();
    			 if(System.currentTimeMillis()-time>=500){
    				 pw.println(massage); 
    				 time = System.currentTimeMillis();
    			 }else{
    				 System.out.println("说那么块干嘛...");
    				 time = System.currentTimeMillis();	 
    			 }
    			 
    			 
    		 }
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 
     }
     public static void main(String[] args) {
		Client client;
		try {
			client = new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
		System.out.println("服务端启动失败");
		}
		
	}
     /**
      * 该线程用来循环读取客户端发送过来的信息并输出到客户端控制台上
      * @author soft01
      *
      */
     private class ServerHandler implements Runnable{
    	 public void run(){//创建线程
    		 try {
    			 InputStream in = socket.getInputStream();
    			 BufferedReader br = new BufferedReader(
    					 new InputStreamReader(in,"UTF-8")
    					 );
    			  
			} catch (Exception e) {
			
			}
    	 }
     }
     
}


