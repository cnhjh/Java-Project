package hm.java02.day06;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个文件
 * @author soft01
 *
 */
public class File_createNewFile {
	public static void main(String[] args) throws IOException {
		File file = new File("."+File.separator+"test.txt");
		/**
		 * boolean exists()
		 * 判断当前File表示的文件或目录是否真实存在
		 */
		if(!file.exists()){
			/**
			 * 创建文件
			 */
			file.createNewFile();
			System.out.println("创建文件成功！");
		}else{
			System.out.println("该文件已存在");
		}

    }
}
