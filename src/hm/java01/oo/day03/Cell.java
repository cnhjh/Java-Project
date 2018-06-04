package hm.java01.oo.day03;

public class Cell {
    int row;//
    int col;//
    Cell(){
	  this(0); 
    }
    Cell(int n){
    	this(n,n);
    };
    Cell(int row,int col){
    	this.row = row;
    	this.col = col;
    };
    void drop(){ //下落一格
		row++;
	}
    void moveLeft(){//左移一格
    	col--;
    }
    void drop(int n){
    	row+=n;
    }
    void moveLeft(int n){
    	col-=n;
    }
    void moveRingh(){
    	col++;
    }
    void moveRingh(int n){
    	col+=n;
    }
    String getCellInfo(){
    	return row+","+col;  
    }
     
     
}
