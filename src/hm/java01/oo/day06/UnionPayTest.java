package hm.java01.oo.day06;

import java.util.Scanner;

public class UnionPayTest {
	public static void main(String[] args) {
	    ABCATM atm = new ABCATM();//atm机对象
	    UnionPay card = new ABCImpl(2000,"123456");//银联卡
	    atm.insertCard(card);//插卡
	    atm.payTelBill();//点击支付电话费按钮
	}
}	
class ABCATM{//农行ATM机
	private UnionPay card;//银联卡
	public void insertCard(UnionPay card){//插卡
		this.card = card;
	}
	public void payTelBill(){//支付话费按钮
		Scanner input = new Scanner(System.in); 
		if(card instanceof ABC){//是农行卡
			ABC abcCard = (ABC)card;//强转农行卡
			System.out.println("请输入电话号码:");
			String telNum = input.next();
			System.out.println("请输入缴费金额：");
			double sum = input.nextDouble();
			if(abcCard.payTelBill(telNum,sum)){
				System.out.println("缴费成功");
			}else{
				System.out.println("缴费失败");
			}
			
		}else{
			System.out.println("您的卡不是农行卡，不能支付电话费");
		}
	}
	private void showBalance(){
		System.out.println("当前余额是："+card.getBalance());
	}
	private void takeMoney(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入取款数目：");
		double number = input.nextDouble();
		if(card.drawMoney(number)){
			System.out.println("取款成功");
		}else{
			System.out.println("取款失败");
		}
	}
	

}









interface UnionPay{//银联
	double getBalance();//查询余额
	boolean drawMoney(double number);//取钱
	boolean checkPwd(String imput);//验证密码
}
interface ICBC extends UnionPay{
	void payOnline(double number);//在线支付功能
	     
}
interface ABC extends UnionPay{
    boolean  payTelBill(String phoneNum,double s);//支付电话费
}

class ICBCImpl implements ICBC{
	private double money;
	private String pwd;
	public ICBCImpl(double money,String pwd){
		this.money = money;
		this.pwd = pwd;
	}
	public double getBalance(){ 
	   System.out.println(money);
		return money; 
	}
	public boolean drawMoney(double number){
		if(number<=money){
			money-=number;
			//System.out.println(money);
			return true;
		}else{
			return false;
		}	
	}
	public void payOnline(double number){
		if(number<money){
			money -= number;
			System.out.println(money);
		}else{
			System.out.println("输入错误！");
		}
	};
	public boolean checkPwd(String imput){
		if(pwd.equals(imput)){
			return true;
		}else{
			return false;
		}
	}
}


class ABCImpl implements ABC{
	private double balance;
	private String password;
	public ABCImpl(double balance,String password){
		this.balance = balance;
		this.password = password;
	}
	public double getBalance(){
		return balance;
	}
	public boolean drawMoney(double number){
		if((balance-number)>=-2000){
			balance-=number;
			System.out.println(balance);
			return true;
		}else{
			return false;
		}
	}
	public boolean checkPwd(String imput){
	if(password.equals(imput))	{
		return true;
	}else{
		return false;
	}
	}
	public boolean  payTelBill(String phoneNum,double sum){
		if(phoneNum.length()==11 && (balance-sum)>=-2000){
			balance-=sum;
			return true;
		}else{
			return false;
		}
	}
}

