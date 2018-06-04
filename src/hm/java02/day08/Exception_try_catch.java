package hm.java02.day08;
/**
 * java异常处理机制中的try_catch
 * @author soft01
 *
 */
public class Exception_try_catch {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try{
		    String str = "a";//
		    System.out.println("字符串长度:"+str.length());//字符串长度
		    System.out.println("第一个字符："+str.charAt(0));//查看第一个字符
		    System.out.println(Integer.parseInt(str));//转换为int型
		    
		    //try块中出错代码以下的内容都不在运行
		    System.out.println("!!!!!!!!");//不运行
		    
		    
        }catch(NullPointerException e){//如果程序不报错 catch 不运行
        	System.out.println("出现了空指针！");
	    }catch(StringIndexOutOfBoundsException e){
	    	System.out.println("字符串下标越界了！");
	    	/*
	    	 * catch可以定义多个，根据不用异常有不同处理办法时，应当分别捕获这些异常。
	    	 * 但应当养成一个好习惯，在最后catsh最大的异常Exception，这样可以避免因
	    	 * 为代码抛出一个未知的异常导致程序中断。
	    	 * 当捕获的异常存在继承关系时，应当将子类异常在上先行捕获，父类异常在下。
	    	 * 
	    	 */
	    }catch(Exception e){
	    	System.out.println("反正就是错了！");
	    }
		
		System.out.println("程序结束了！");
	}

}
