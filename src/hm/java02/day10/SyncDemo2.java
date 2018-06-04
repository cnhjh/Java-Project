package hm.java02.day10;
/**
 * 有效的缩小同步范围可以在保证并发安全的前提下提高并发的效率。
 * @author soft01
 *
 */
public class SyncDemo2 {
    public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void  run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void  run(){
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}
}
class Shop{
	public  void buy(){
		try {
			Thread t = Thread.currentThread();//获取运行这个方法的线程
			System.out.println(t.getName()+"：正在选衣服。。。");
			Thread.sleep(5000);
			
			/*
			 * 同步块可以更精确的控制需要同步执行的代码片段。有效缩小同步
			 * 范围提高并发效率，但是需要注意，同步块需要指定“同步监视器”即：
			 * 上锁的对象，要保证需要同步运行该段代码的线程看到的该对象是同一个
			 */
			synchronized(this){
			System.out.println(t.getName()+"：正在试衣服。。。");
			Thread.sleep(5000);
			}
			
			System.out.println(t.getName()+"：结帐离开");
			
		} catch (Exception e) {
		}	
	}
}
