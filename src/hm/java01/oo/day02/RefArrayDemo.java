package hm.java01.oo.day02;
//引用类型数组
public class RefArrayDemo {
    public static void main(String[] args) { 
    	Cell[] cells = new Cell[4];
    	cells[0] = new Cell(2,5);
    	cells[1] = new Cell(2,6);
    	cells[2] = new Cell(2,7);
    	cells[3] = new Cell(3,6);
    	
    	Cell[] cs = new Cell[]{
    			new Cell(2,5),
    			new Cell(2,6),
    			new Cell(2,7),
    			new Cell(3,6),
    	}; 
//    	System.out.println(cs[0].col);
//    	System.out.println(cs[1].col);
//    	System.out.println(cs[2].row);
//    	System.out.println(cs[3].row);
    
    	
    	int[][] arr = new int[3][];
    	arr[0] = new int[2];
    	arr[1] = new int[3];
    	arr[2] = new int[2];
    	
    	int[][] as = new int[3][4];
    	for(int i=0;i<as.length;i++){
    		for(int j=0;j<as[i].length;j++){
    			as[i][j]=100;
    			System.out.println(as[i][j]+","+i+","+j);
    		}
    	}
    	
	}

}
