package hm.java01.oo.day01;

public class Cell01 {
    int row;//hang
    int col;//lie
    
    void drop(){
    	row++;
    }
    void moveleft(int n){
    	col-=n;
    }
    String getCellInfo(){
    	return row+","+col;
    }
}
	

