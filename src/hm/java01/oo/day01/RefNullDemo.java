package hm.java01.oo.day01;
//引用类型null的演示
public class RefNullDemo {
    public static void main(String[] args){
    	//引用类型之间画=
    	Cell c = new Cell();
    	Cell cc = c;//指向了同一个对象
    	c.row = 2;
    	//cc.row = 5;
    	System.out.println(c.row);
    	//基本类型之间画=
    	int a = 5;//
    	int b = a;
    	    b = 8;
    	    System.out.println(b);
    	    
    	    Cell ccc = new Cell();
    	    ccc.row = 5;
    	    ccc = null;//空，没有指向任何对象
    	    ccc.row = 2;
    	    
    	
    	
    	
	}

}
