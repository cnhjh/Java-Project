package hm.java02.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室服务端
 * @author soft01
 *
 */
public class Server {// server服务器
	/*
	 * 运行在服务器端的ServerSocket主要负责两个工作；
	 * 1：向系统申请服务端口，客户端就是通过这个端口与服务器应用程序建立连接的。
	 * 
	 * 2：监听服务器端口，一旦客户端通过该端口尝试连接时，
	 *   ServerSocket就会实例化一个Socket与该客户端通讯
	 */
   private ServerSocket server;
   
   /*
    * 存放所有客户端的输出流，用于广播消息
    */
   private List<PrintWriter> allOut;
   
   public Server() throws Exception{//初始化服务端
	   try {
		   
		   /*
		    * 实例化ServerSocket时需要指定服务器端口，
		    * 客户端就是通过这个端口与服务器建立连接的
		    * 
		    * 该端口不能与系统其他程序申请的端口冲突，
		    * 否则会抛出异常:address already in use.
		    */
		server = new ServerSocket(8088);
		//往集合添加元素
		allOut = new ArrayList<PrintWriter>();
	} catch (Exception e) {
	    throw e;//throw 投, 掷, 抛
	}
	   
   }
   
   public void start(){//服务端开始工作 启动服务端
	   try {
		   /*
		    * ServerScoket提供方法：
		    * Socket accept();
		    * 该方法是一个阻塞方法，调用后会一致等待客户端的连接，一旦一个
		    * 客户端通过ServerSocket申请的端后建立连接，那么accept方法会
		    * 返回一个Socket实例，通过该Socket实例可以与建立连接的客户端进行通讯
		    */
		   while(true){
		       System.out.println("等待客户端连接...");
		       Socket socket = server.accept();
		       System.out.println("一个客户端连接了！");
		       
		       // 一旦连上 启动一个线程来处理该客户端交互  同时接收多个客户端
		       ClientHandler handler = new ClientHandler(socket);
		       Thread t = new Thread(handler);
		       t.start();
		   }

	} catch (Exception e) {
        e.printStackTrace();
	}
   }
   
   public static void main(String[] args) {
	   try {
		   Server server = new Server();
		   server.start();
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("服务端连接失败！");
	}

   }
   
   
   /**
    * 该线程任务是用于处理与指定客户端交互工作
    * @author soft01
    *
    */
   private class ClientHandler implements Runnable{
	   
	   //当线程通过这个Socket与指定客户端交互
	   private Socket socket;
	   private String host;
	   public ClientHandler(Socket socket){//new一个socket的同时传过来
		   this.socket = socket;
		   //
		   InetAddress address = socket.getInetAddress();
		   //获取IP地址的字符串形式
		   host = address.getHostAddress();
	   }
	   
	   
	   public void run(){
		   PrintWriter pw = null;
		   try {
			   /*
			    * Scoket提供方法：
			    * InputStream getInputStream()
			    * 通过获取的输入流读取的字节就是来自远端发送过来的数据，
			    * 对于服务器端而言，远端指的就是客户端。
			    */
			   InputStream in = socket.getInputStream();//获取输入流
			   InputStreamReader isr = new InputStreamReader(in,"UTF-8");//缓冲字符输入流 读取字符串
			   BufferedReader br = new BufferedReader(isr);//转换输入流 字节转字符
			   
			   /*
			    * 通过Socket获取输出流，用于将消息发送给客户端
			    */ 
			  OutputStream out =  socket.getOutputStream();
			  OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");//包装，转换为字符流
			  pw = new  PrintWriter(osw,true);
			  
			  //将该客户端的输出流存入共享集合  
			  synchronized (allOut) {//不可以用this---方法所属对象
				  allOut.add(pw);
			}
			
			   
			   
			   String message = null;
			   /*
			    * 使用br.readLine读取客户端发送过来的一行字符时，该方法会处于阻塞状态，直到客户端真实
			    * 发送过来一行，这里才会返回。
			    * 但是当客户端断开连接时，br.readLine会根据客户端不同操作系统有不同反馈。
			    * 当windows的客户端断开，br.readLine方法会抛出异常。
			    * 放Linux的客户端断开，br.readLine方法会返回null。
			    */
			   while((message = br.readLine()) != null){
				   System.out.println(message);//查看所有客户端输入的内容
				   
				   //将消息转发给所有客户端
				   /*
				    * 线程在遍历集合时的操作要与集合的增删原数互斥
				    */
				   synchronized (allOut){
				   for(PrintWriter o : allOut){
					   o.println(host+"说："+message);
				   }
				   }
			       //System.out.println(host+"说："+message);
			       //将读到的内容再回复给客户端（临时测试用）
			       // pw.println(host+"说："+message);
			   } 
		} catch (Exception e) {
		    
		} finally {
			//处理客户端断开连接后的操作
			
			//将该客户端的输出流从共享集合中移除
			synchronized (allOut) {
				allOut.remove(pw);
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
	   }
   }
   
}
