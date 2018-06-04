package hm.java02.day11;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



/**
 * 聊天室客户端
 * @author soft01
 *
 */
public class Client {
	/*
	 * java.net.Socket
	 * 套接字，Socket封装了TCP协议，使用它可以与远端计算机通讯。
	 */
    private Socket socket;
   
    /**
     * 构造方法，用来初始化客户端
     */
    public Client() throws Exception{
    	/**
    	 * 实例化Socket时需要传入两个参数:
    	 * 1:服务器端计算机的地址信息（IP地址），通过它可以找到网络上的服务端计算机
    	 * 2:服务器计算机上运行的服务器端应用程序申请的服务端口
    	 * 
    	 * 通过IP地址可以找到服务器端的计算机，通过端口可以连接到
    	 * 运行在服务器端计算机上的服务器端应用程序
    	 * 
    	 * 实例化Socket的过程就是连接服务器端的过程
    	 * 若服务器端无响应，实例化过程会抛出异常
    	 * 
    	 * 端口号是一个整数，2字节内的整数0-65535，
    	 * 但3000以内的端口号不要使用，因为紧密的绑定着系统程序，
    	 * 和世界上流行的应用程序。10000以上也很少被使用
    	 */
    	try {
			socket = new Socket("176.114.27.19",8088);//localhost 176.114.27.20
		} catch (Exception e) {
			//记录日志
		    throw e;//抛出异常
		
		}

    }
   
    /**
     * 客户端开始工作的方法
     */
    public void start(){
    	try {
    		//用来获取用户输入
    		Scanner scanner = new Scanner(System.in);
    		
			/*
			 * Socket提供方法:
			 * OutputStream getOutputStream()
			 * 通过获取的输出流写出的数据就可以通过网路发送
			 * 给远端计算机，对于客户端而言远端就是服务器端.
			 */
    		OutputStream out =socket.getOutputStream();
    		OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
    		PrintWriter pw = new PrintWriter(osw,true);
    		
    		//接收客户端发送过来消息的线程启动
    		ServerHandler handler = new ServerHandler();
    		Thread t = new Thread(handler);
    		t.start();
    		
    		System.out.println("请开始聊天吧！");
    		String message = null;
    		long time = System.currentTimeMillis()-500;
    		while(true){
    			message = scanner.nextLine();
    			if(System.currentTimeMillis()-time>=500){//如果PPQO<
    				 pw.println(message);
    				 time = System.currentTimeMillis();//刷新时间
    			}else{
    				System.out.println("你说话太快......");
    				time = System.currentTimeMillis();//刷新时间 一直太快一直说不出
    			}
    		}

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args){
    	Client client;
		try {
			client = new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务端启动失败！");
		}
    }
    
    /**
     * 该线程专门用来循环读取服务端发送过来的消息并输出到客户端的控制台上
     */
    private class ServerHandler implements Runnable{
    	public void run(){
    		try {
    			
    	
//				BufferedReader br = new BufferedReader(
//						new InputStreamReader(
//								socket.getInputStream(),"UTF-8"
//								)
//						);
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
    			
				String message = null;
				while((message = br.readLine()) != null){
					System.out.println(message);
				}
			} catch (Exception e) {
		
			}
    	}

    	
    }
}
