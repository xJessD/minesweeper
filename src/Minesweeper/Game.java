package Minesweeper;

import java.util.Scanner;

public class Game {
	Cell[][] field;
	int rows;
	int cols;
	int mineNum;
	boolean gameLost;
	
	public Game(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		
		// Create the field based on user given rows & columns
		field = new Cell[rows][cols];
		
		// about 1 / 10 of the whole field.
		mineNum = rows * cols / 10; 
		
		// Populate the field with cells;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				field[i][j] = new Cell();
			}
		}
		
		renderMines();
	}
	
	public void render() {
		System.out.println("\n");
		
		// Displays all the cells + formatting
		for (int i = 0; i <= rows+2; i++) {
			if (i < rows) {
				System.out.println();
				
				System.out.print(" ");
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
		
		System.out.println();
	}
	
	public void renderMines() {
		int mines = mineNum;
		 
		
		// While the mines have not been assigned
		// Doesn't really matter if we try to place a mine already on another mine (actually matters in this case, was bugging out neighbor count should we double add mine to a single position)
		while (mines > 0) {
			
			// random x, y co-ords from 0 - rows / cols
			int mineX = (int)(Math.random()*rows);
			int mineY = (int)(Math.random()*cols);	
			
			// set the position to is a mine
			
			if (field[mineX][mineY].isMine) {
				continue;
			} 
			
			else {
				field[mineX][mineY].isMine = true;
				
				
				// set the neighbors counts
				setNeighborsCount(mineX, mineY);
				
				mines--;
			}
			
		}
	}
	
	// goes and sets all neighbor counts after setting mines.
	private void setNeighborsCount(int mineX, int mineY) {
		
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
	
	
	private void displayNeighbors(int mineX, int mineY) {
		
		// checks to see if we are able to set +1 or -1 on positions without error
		if (mineX < rows - 1) {
			if (!field[mineX + 1][mineY].isMine && field[mineX + 1][mineY].countOfNeighborMines != 0) 
				field[mineX + 1][mineY].isChecked = true;
			
			if (mineY < cols - 1) {
				if (!field[mineX][mineY + 1].isMine && field[mineX][mineY + 1].countOfNeighborMines !=0)
						field[mineX][mineY + 1].isChecked = true;
				
				if (!field[mineX + 1][mineY + 1].isMine && field[mineX + 1][mineY + 1].countOfNeighborMines != 0)
					field[mineX + 1][mineY + 1].isChecked = true;
			}
			
			if (mineY > 0) {
				if (!field[mineX][mineY - 1].isMine && field[mineX][mineY - 1].countOfNeighborMines != 0) 
					field[mineX][mineY - 1].isChecked = true;
				
				if (!field[mineX + 1][mineY - 1].isMine && field[mineX + 1][mineY - 1].countOfNeighborMines != 0)
					field[mineX + 1][mineY - 1].isChecked = true;
			}
		}
		
		if (mineX > 0) {
			if (!field[mineX - 1][mineY].isMine && field[mineX - 1][mineY].countOfNeighborMines != 0)
				field[mineX - 1][mineY].isChecked = true;
			
			if (mineY > 0) {
				if (!field[mineX - 1][mineY - 1].isMine && field[mineX - 1][mineY - 1].countOfNeighborMines != 0)
					field[mineX - 1][mineY - 1].isChecked = true;
			}
			
			if (mineY < cols - 1) {
				if (!field[mineX - 1][mineY + 1].isMine && field[mineX - 1][mineY + 1].countOfNeighborMines != 0)
					field[mineX - 1][mineY + 1].isChecked = true;
			}
		}
		
	}
	
	public void guess (int x, int y) {
		check(x, y);
	}
	
	// to check the cells
	public void check (int x, int y) {
		 field[x][y].isChecked = true;
		 
		 if (field[x][y].isMine == true) {
			 this.gameLost = true;
		 }
		 
		 displayEmptyNeighbors(x, y);

	}
	
	// To display all empty neighbors from current coordinate until we find a mine or first cell with
	// more than 0 neighbors
	public void displayEmptyNeighbors(int x, int y) {
		
		// looking at all NSEW directions
  		boolean foundS = false;
		boolean foundW = false;
		boolean foundE = false;
		boolean foundN = false;
		
		for (int i = x; i < rows && !foundS; i++) {
			for (int j = y; j < cols && !foundW; j++) {
					if (!field[i][j].isMine && field[i][j].countOfNeighborMines == 0) {
						field[i][j].isChecked = true;
						displayNeighbors(i, j);
					} else if (!field[i][j].isMine){
						foundW = true;
						foundS = true;
					}
				
			}
			
			for (int j = y; j > 0 && !foundE; j--) {
				if (!field[i][j].isMine && field[i][j].countOfNeighborMines == 0) {
					field[i][j].isChecked = true;
					displayNeighbors(i, j);
				} else if (!field[i][j].isMine){
					foundE = true;
					foundS = true;
				}
		}
			
			foundW = false;
			foundE = false;
		}
		
		
		for (int i = x; i > 0; i--) {
			for (int j = y; j < cols && !foundW; j++) {
				if (!field[i][j].isMine && field[i][j].countOfNeighborMines == 0) {
					field[i][j].isChecked = true;
					displayNeighbors(i, j);
				} else if (!field[i][j].isMine){
					foundW = true;
					foundN = true;
				}
			
		}
		
		for (int j = y; j > 0 && !foundE; j--) {
			if (!field[i][j].isMine && field[i][j].countOfNeighborMines == 0) {
				field[i][j].isChecked = true;
				displayNeighbors(i, j);
			} else if (!field[i][j].isMine){
				foundE = true;
				foundN = true;
			} 
		}
		
		foundW = false;
		foundE = false;
			
		}
	}
	
	// If all non mines are marked as checked, return true for gameWon.
	public boolean gameWon() {
		boolean allShown = true;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!field[i][j].isChecked && !field[i][j].isMine) {
					allShown = false;
				}
			}
		}

		return allShown;
	}

}
