package Minesweeper;

public class Cell {
	
	boolean isMine = false;
	boolean isChecked = false;
	int countOfNeighborMines = 0;
	
	public Cell() {}
	
	public String getValue() {
		// if !isChecked == ?
		// if isChecked && isMine = lose / game over
		// if isChecked && !isMine -> display surrounding cells = !isMine
		
		
		
			if (this.isMine) {
			return " m ";
		}
			
			else if (countOfNeighborMines == 0) {
				return "   " ;
			}
			return String.format(" %s ", countOfNeighborMines);
		
	}
	
	
	
	
}
