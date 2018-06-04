package hm.java01.oo.day04;

public class J extends Tetromino {
	J() {
		this(0, 0);
	}

	J(int row, int col) {
		this.cells[0] = new Cell(row, col);
		this.cells[1] = new Cell(row + 1, col);
		this.cells[2] = new Cell(row + 2, col);
		this.cells[3] = new Cell(row + 2, col - 1);

	}
	void print() {
		 System.out.println("I am a J:");
			super.print();
	}
}
