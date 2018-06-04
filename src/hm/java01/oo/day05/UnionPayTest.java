package hm.java01.oo.day05;

public class UnionPayTest {
	public static void main(String[] args) {
		ICBCImp1 o1 = new ICBCImp1();
		ABCImp1 o2 = new ABCImp1(); 

	}
}
interface UnionPay{//银联接口
	public double getBalance();//查询余额
	public boolean drawMoney(double number);//取钱
	public boolean chevkPwd(String input);//验证密码
}
interface ICBC extends UnionPay{//工行卡接口
	public void payOnline(double number);//支付
}
interface ABC extends UnionPay{//农行卡接口
    public boolean payTelBill(String phoneNum,double s);//电话
} 

class ICBCImp1 implements UnionPay{//工行卡
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean chevkPwd(String input){return true;}
	public void payOnIine(double number){};
}
class ABCImp1 implements UnionPay{//农行卡
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean chevkPwd(String input){return true;}
	public boolean payTe1Bi11(String phoneNum,double s){return true;}
}

	
	
