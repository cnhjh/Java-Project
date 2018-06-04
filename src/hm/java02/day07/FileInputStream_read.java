package hm.java02.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件输入流
 * @author soft01
 *
 */
public class FileInputStream_read {
    public static void main(String[] args) throws IOException {
    	FileInputStream fis = new FileInputStream("fos.txt");
    	
    	byte[] data = new byte[200];
    	
    	int len = fis.read(data);
    	
    	String str = new String(data,0,len,"UTF-8");
    	System.out.println(str);
    	
    	fis.close();
    	
	}
}
