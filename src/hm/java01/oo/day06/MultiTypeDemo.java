package hm.java01.oo.day06;

import java.util.concurrent.SynchronousQueue;

//多态的演示
public class MultiTypeDemo {
	public static void main(String[] args) {
	Aoo o1 = new Boo();//向上造型
	Aoo o2 = o1;//
	Interl o3 =(Interl)o1;
	Boo o4 =(Boo)o1;
	//Coo o5 = (Coo)o1;
	if(o1 instanceof Coo){
		Coo o6 = (Coo)o1;
	}
    System.out.println("over");
	}
}
interface Interl{}
class Aoo{}
class Boo extends Aoo implements Interl{}
class Coo extends Aoo{}