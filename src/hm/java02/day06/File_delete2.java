package hm.java02.day06;

import java.io.File;

public class File_delete2 {
	public static void main(String[] args) {
	 /**
	  * 将当前目录下的demo目录删除
	  * 直接指定文件名或目录名，那么该文件或目录默认是在当前目录中
	  * 即： File dir = new File("deme");
	  * 等同：File dir = new File("./deme");
	  * 
	  * 删除一个目录的前提条件是该目录必须是一个空目录才可以将其删除
	  */
		File dir = new File("demo");
		if(dir.exists()){
			dir.delete();
			System.out.println("删除完毕！");		
		}else{
			System.out.println("该目录不存在！");
		}

	}
}
