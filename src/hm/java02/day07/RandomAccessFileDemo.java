package hm.java02.day07;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用RAF读写基本类型数据，以及RAF对指针的操作
 * @author soft01
 *
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
	RandomAccessFile raf = new RandomAccessFile("raf.dat","rw");
	/*
	 * long getFilePointer()
	 * 获取RAF当前指针的位置
	 */
	//创建出来时，指针在文件开始
	long pos = raf.getFilePointer();
	System.out.println("pos："+pos);
	
	int imax = Integer.MAX_VALUE;
	/*
	 *                            vvvvvvvv
	 * 01111111 11111111 11111111 11111111
	 */
	raf.write(imax>>>24);//经最高八位移到最低八位
	System.out.println("pos："+raf.getFilePointer());
	raf.write(imax>>>16);
	System.out.println("pos："+raf.getFilePointer());
	raf.write(imax>>>8);
	System.out.println("pos："+raf.getFilePointer());
	raf.write(imax);
	System.out.println("pos："+raf.getFilePointer());
	/*
	 * void eriteInt(int d）
	 * 将int值对应的4个字节一次性写出
	 */
	raf.writeInt(imax);
	System.out.println("pos："+raf.getFilePointer());
	raf.writeLong(123L);
	System.out.println("pos："+raf.getFilePointer());
	raf.writeDouble(123.123);
	
	/*
	 * void seek（long pos)
	 * 移动指针到指定位置
	 */
	//将指针移动到文件开始
	raf.seek(0);
	System.out.println("pos:"+raf.getFilePointer());
	/*
	 * 连续读取4个字节，并返回对应的int值
	 * EOF  end of file
	 */
	int d = raf.readInt();
	System.out.println("imax:"+d);//int最大值
	System.out.println("pos："+raf.getFilePointer());
	
	//读取long
	//1.先将指针移动到long值的起始位置
	raf.seek(8);
	long l = raf.readLong();
	System.out.println("long:"+l);
	
	System.out.println("pos："+raf.getFilePointer());
	
	//读取double
	double dou = raf.readDouble();
	System.out.println("double:"+dou);
	
	System.out.println("pos："+raf.getFilePointer());
	
	System.out.println("写出完毕!");
	raf.close();

	}
}
