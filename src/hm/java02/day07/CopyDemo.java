package hm.java02.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流复制
 * @author soft01
 *
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
		/*
		 * 使用文件输入流将源文件中所有的字节顺序的读取出来再用文件输出流
		 * 写入到另一个文件中完成复制操作
		 */
        FileInputStream fis = new FileInputStream("fos.txt");
        FileOutputStream fos = new FileOutputStream("fos_02.txt");
        byte[] buf = new byte[1024*10];
        int len = -1;
        while(  (len=fis.read(buf))!= -1){
        	fos.write(buf,0,len);
        System.out.println("复制完毕");
       
        }
        fis.close();
        fos.close();
        
        
	}
}
