package hm.java02.day08;
/**
 * 自定义异常
 * 自定义异常通常用来说明业务逻辑级别的异常
 * 
 * 年龄不合法异常
 * 
 * @author soft01
 *
 */


public class IllegalAgeException extends  Exception{

	private static final long serialVersionUID = -8241398737954702031L;


	public IllegalAgeException() {
		super();
	}
	public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public IllegalAgeException(String message, Throwable cause) {
		super(message, cause);
	}
	public IllegalAgeException(String message) {
		super(message);
	}
	public IllegalAgeException(Throwable cause) {
		super(cause);
	}

}
