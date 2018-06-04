package hm.java02.day08;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * 字符流
 * 字符流与字节流的区别在于读写单位为：字符
 * 但是字符流底层本质还是读写字节，只是字符与字节的转换工作交给了字符流来完成
 * 
 * Reader是所有字符输入流的父类，规定了读取字符的相关方法
 * Writer是所有字符输出流的父类，规定了写出字符的相关方法
 * 
 * 
 * 转换流
 * InputStreamReader,OutputStreamWriter
 * 他们是字符流的一对常见实现类 
 * @author soft01
 *
 */
public class OutputStreamWriter_writer {
    public static void main(String[] args) throws IOException {

    	OutputStreamWriter osw = 
    			new OutputStreamWriter(
    			new FileOutputStream("osw.txt"),"UTF-8"
    			);
		
		osw.write("丑八怪哎哎哎哎哎哎啊");
		osw.write(",在这暖昧的时代。");
		System.out.println("写出完毕！");
		osw.close();
		
		
		
	}
}
