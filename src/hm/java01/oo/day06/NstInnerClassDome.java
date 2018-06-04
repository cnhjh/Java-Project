package hm.java01.oo.day06;

//匿名内部类演示

public class NstInnerClassDome {
	
	public static void main(String[] args) {
		
		Inter3 o1 = new Inter3(){
		
		};
		
		//final int num = 5;
		
	    Inter4 o3 = new Inter4(){
	    	public void show(){
	    		System.out.println("showshow");
	    		System.out.println(num);
	    	}
		};
		o3.show();

	}
}



interface Inter3{
	
}
interface Inter4{
	int num = 5;
	void show();
}