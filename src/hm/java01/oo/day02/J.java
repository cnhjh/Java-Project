package hm.java01.oo.day02;

public class J {
	 Cell[] cells;//格子数组
	 J(){
		 this(0,0);
	 }
    J(int row,int col){
   	 this.cells = new Cell[4];//创建格子数组对象
   	 this.cells[0] = new Cell(row,col);
   	 this.cells[1] = new Cell(row+1,col);
   	 this.cells[2] = new Cell(row+2,col);
   	 this.cells[3] = new Cell(row+2,col-1);
    } 
    void drop(){
   	 for(int i=0;i<this.cells.length;i++){//下落后
   		 this.cells[i].row++;
   	 }
    }
    void moveLeft(){
   	 for(int i=0;i<this.cells.length;i++){//左移后
   		 this.cells[i].col--;
   	 }
   	 
    }
    void moveRinght(){
   	 for(int i=0;i<this.cells.length;i++){//右移后
   		 this.cells[i].col++;
        }
    }
    void print(){//输出四个格子的行号和列号
   	 for(int i=0;i<this.cells.length;i++){
   		 String str = this.cells[i].getCellInfo();
   		 System.out.println(str);
   	 }
   	 
    }
}
