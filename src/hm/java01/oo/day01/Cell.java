package hm.java01.oo.day01;

public class Cell {
	int row;//行号
	int col;//列号
	void drop(){//下落一格
		row++;
	}
	void moveleft(int n){//左移动n格
		col-=n;
	}
	String getCellInfo(){//获取行号和列号
		return row+","+col;
	}
	


	
}
