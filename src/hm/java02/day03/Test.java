package hm.java02.day03;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 程序启动后，要求用户输入自己的生日，格式为:
 * 1992-08-05
 * 然后经过程序计算，输出到今天为止活了多少天。
 * 
 * 若没有活够10000天，则输出，达成生存10000天成就的
 * 日期为:xxxx-xx-xx
 * 若够了，则查看20000天纪念日
 * 
 * @author adminitartor
 *
 */
public class Test {
	public static void main(String[] args)throws ParseException {
		System.out.println("请输入您的生日:(yyyy-mm-dd)");
		Scanner scanner = new Scanner(System.in);
		String birthStr = scanner.nextLine();
		//将生日转换为Date
		SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd");
		Date birth = sdf.parse(birthStr);
		//当前系统时间
		Date now = new Date();
		//计算相差的毫秒
		long time = now.getTime()-birth.getTime();
		//换算为天
		time = time/1000/60/60/24;
		
		System.out.println("恭喜您，已经活了:"+time+"天！请继续保持呦!");
		
		
		//判断是否达到10000天
		if(10000-time>0){
			printDate(birth,10000);
		}else{
			printDate(birth,20000);
		}			
	}
	public static void printDate(Date birth,int days){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long time = birth.getTime()+1000L*60*60*24*days;
		Date date = new Date(time);
		String str = sdf.format(date);
		System.out.println("出生"+days+"天纪念日为:"+str);

	}
}
