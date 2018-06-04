package hm.java02.day06;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * java.io.File
 * File的每一个使用例用于表示文件系统中的一个文件或目录
 * 
 * 使用File可以：
 * 1.访问该文件或目录的属性（名字，大小，修改日期等）
 * 2.操作文件或目录（创建，删除）
 * 3.若表示的是目录，可以查看该目录的子项信息
 * 
 * 但不能访问一个文件中的数据
 * @author soft01
 *
 */
public class FileDemo {
    public static void main(String[] args) {
		/*
		 * 在java程序中使用路径时，尽量使用相对路径
		 * 这样可以避免平台差异
		 * 
		 * “.”表示当前目录，在eclipse中当前目录指的是
		 * 当前类所在项目的根目录
		 * 
		 * File提供了一个常量：separator
		 * 它表示一个受系统支持的目录层级分割
		 */
    	File file = new File("."+File.separator+"demo.txt");
    	
    	String name = file.getName();
    	System.out.println("名字："+name);
    	
    	long length = file.length();
    	System.out.println("大小"+length+"字节");
    	
    	/**
    	 * boolean canRead()
    	 * boolean canWrite()
    	 * boolean isHidden()
    	 */
    	boolean cr = file.canRead();
    	boolean cw = file.canWrite();
    	System.out.println("可读："+cr);
    	System.out.println("可写："+cw);
    	boolean ih = file.isHidden();
    	System.out.println("是否隐藏："+ih);
    	
    	/*
    	 * 
    	 */
    	long time = file.lastModified();//时间  毫秒
    
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日，HH：mm：ss");
    	System.out.println(sdf.format(time));
	}
}
