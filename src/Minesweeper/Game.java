package Minesweeper;

public class Game {
	Cell[][] field;
	int rows;
	int cols;
	int mineNum;
	
	public Game(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		
		// Create the field based on user given rows & columns
		field = new Cell[rows][cols];
		mineNum = rows + cols/2;
		
		// Populate the field with cells;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				field[i][j] = new Cell();
			}
		}
	}
	
	public void render() {
		
		// Displays all the cells + formatting
		for (int i = 0; i <= rows+2; i++) {
			if (i < rows) {
				System.out.println();
				
				for (int j = 0; j < cols; j++) {
					System.out.print("  " + field[i][j].getValue());
				}
				
				// Display number of rows
				System.out.println("   | " + i); 
			}
			
			else if (i == rows) {
				System.out.println();
			}
			
			else if (i == rows+1) {
				for (int j = 0; j < cols; j++) {
					System.out.print("   - ");
				}
			}
			
			else  {
				// Space between cells + col title
				System.out.println();
				System.out.println();
				
				for (int j = 0; j < cols; j++) {
					// Display each column
					System.out.print("   " + j + " ");
				}
			}
			
		}
	}
	
	public void renderMines() {
		int mines = mineNum;
		 
		
		// While the mines have not been assigned
		while (mines > 0) {
			
			// random x, y co-ords from 0 - rows / cols
			int mineX = (int)(Math.random()*rows);
			int mineY = (int)(Math.random()*cols);	
			
			// set the position to is a mine
			field[mineX][mineY].isMine = true;
			
			
			// set the neighbors counts
			setNeighbors(mineX, mineY);
			
			mines--;
		}
	}

	private void setNeighbors(int mineX, int mineY) {
		
		// checks to see if we are able to set +1 or -1 on positions without error
		if (mineX < rows - 1) {
			field[mineX + 1][mineY].countOfNeighborMines++;
			
			if (mineY < cols - 1) {
				field[mineX][mineY + 1].countOfNeighborMines++;
				field[mineX + 1][mineY + 1].countOfNeighborMines++;
			}
			
			if (mineY > 0) {
				field[mineX][mineY - 1].countOfNeighborMines++;
				field[mineX + 1][mineY - 1].countOfNeighborMines++;
			}
		}
		
		if (mineX > 0) {
			field[mineX - 1][mineY].countOfNeighborMines++;
			
			if (mineY > 0) {
				field[mineX - 1][mineY - 1].countOfNeighborMines++;
			}
			
			if (mineY < cols - 1) {
				field[mineX - 1][mineY + 1].countOfNeighborMines++;
			}
		}
		
	}

}
