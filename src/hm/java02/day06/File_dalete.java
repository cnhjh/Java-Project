package hm.java02.day06;

import java.io.File;

/**
 * 删除文件
 * @author soft01
 *
 */
public class File_dalete {
	public static void main(String[] args) {
		/**
		 * 将当前文件目录中的test.txt文件删除
		 */
       File file = new File("."+File.separator+"test.txt");
       if(file.exists()){
    	   file.delete();//删除文件
    	   System.out.println("删除文件成功!");
    	  
       }else{
    	   System.out.println("该文件不存在！");
       }
	}
}
