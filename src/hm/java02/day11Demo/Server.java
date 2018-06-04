package hm.java02.day11Demo;


import java.io.BufferedReader;
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
 * 
 * @author soft01
 *
 */
public class Server {// server服务器
	private ServerSocket server;//Socket 套接字  被动接电话
	private List<PrintWriter> allOut;//存放所有客户端输出流，用于广播信息
	public Server() throws Exception{//初始化服务端
		try {
			server = new ServerSocket(8088);//端口不能与其他程序申请的端口发生冲突 
			allOut = new ArrayList<PrintWriter>();//往集合添加元素
		} catch (Exception e) {
			//记录日志
			throw e;
		}
	}
	public void start(){//启动服务端
		try {
			/**
			 * ServerSocket提供方法
			 * Socket accept（） 阻塞方法 调用一致的客户端连接
			 */
			while(true){//循环接收
			System.out.println("等待客户端连接。。。");
			Socket socket = server.accept();//监听8088端口
			System.out.println("客户端连接了！");
			Thread t = new Thread(
					new ClientHandler(socket));
			t.start();//启动线程	
		}	
		} catch (Exception e) {
	        e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		Server server;
		try {
			server = new Server();
			server.start();//启动服务端
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务端启动失败");;
		}	
	}
	
	//改线程用于处理指定客户端的交互工作
	public class ClientHandler implements Runnable{	
		private Socket socket;//当线程通过这个Socket与指定客户端交互
		private String host;//客户端的地址信息
		public ClientHandler(Socket socket){
			this.socket = socket;//
			//获取IP地址的字符串形式
			InetAddress address = socket.getInetAddress();
			host = address.getHostAddress();
		}
		
		public void run(){
			PrintWriter pw = null;
			try {
				/**
				 * Socket提供方法：
				 * InputStream getInputStream（）
				 * 获取输入流 读取的字节是远端（客户端）发送过来的数据
				 */
				InputStream in = socket.getInputStream();//获取输入流流
				BufferedReader br = new BufferedReader(//缓冲字符输入流 读取字符串
						new InputStreamReader(in,"UTF-8"));//转换输入流 字节转字符
				
				/**
				 * 通过Socket获取输入流，发送信息给客户端
				 */
				OutputStream out = socket.getOutputStream();
				 pw = new PrintWriter(
						new OutputStreamWriter(out,"UTF-8"),true
						);
				
				//将该客户端的输出流存入共享集合
				synchronized (allOut) {
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
				while((message =br.readLine()) != null){
					System.out.println(host+"说："+message);//显示出所有客户端发送过来的信息
					/*
					 * 将消息发送给所有客户端
					 */
					synchronized (allOut) {
						for(PrintWriter o : allOut){
							o.println(host+"说："+message);//临时
						}
					}		
				}			
			} catch (Exception e) {	
			} finally {
				//处理客户端断开连接厚的操作
				
				//将该了互端从共享中移除
				synchronized (allOut) {
					allOut.remove(pw);		
				}
				}
		}		
	}
}
