package hm.java02.day02;
/**
 * 网络用语和谐
 * @author soft01
 *
 */
public class Test1 {
	public static void main(String[] args) {
		
	String regex = "(wqnmlgb|cnm|mdzz|sb|tmd|ctm|nc|djb)";
	String message = "wqnmlgb！你这个djb！你怎么这么nc！cnm！mdzz！sb！tmd！ctm";
	message = message.replaceAll(regex, "***");
	System.out.println(message);
			

	}
}
