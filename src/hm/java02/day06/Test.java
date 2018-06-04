package hm.java02.day06;

import java.io.File;
/**
 * 1：编写一个程序
 * 要求计算1+2+3+4+5+...+99+100并输出结果。
 * 这段代码中不能出现for ， while 关键字
 * 
 * 2：一个人买汽水，1块钱1瓶汽水，3个瓶盖可以换1瓶汽水
 * 2个空瓶可以换一瓶汽水，问：20块钱可以买对少瓶汽水？
 * 
 * 递归调用：
 * 方法内部调用自己的方法的现象称为递归调用。
 * 递归现象允许程序执行到某个阶段时整体重新来过。
 * 使用递归需要注意：
 * 1：方法内部调用自己方法不能100%成立，否则是死循环；
 * 2：递归层次尽量少，因为递归消耗内存可观，运行效率差。
 * 
 * 
 * 
 * 
 * 删除给定的文件或目录
 * @author soft01
 *
 */
public class Test {

	public static void main(String[] args) {
	    File dir = new File("a");
         delete(dir);
	}
     /**
      * 将给定的File表示的文件或目录删除
      * @param dir
      */
	private static void delete(File file) {
	    if(file.isDirectory()){//如果是目录
	    	//先将该目录清空
	    	File[] subs = file.listFiles();
	    	for(File sub : subs){
	    		delete(sub);//递归调用  能不用尽量不用
	    	}
	    }
	    file.delete();    
	}
}
