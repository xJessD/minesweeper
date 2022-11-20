package Minesweeper;

public class Cell {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BLUE = "\u001B[34m";
	
	boolean isMine = false;
	boolean isChecked = false;
	int countOfNeighborMines = 0;
	boolean flagged = false;
	
	public Cell() {}
	
	public String getValue() {
		// if !isChecked == ?
		// if isChecked && isMine = lose / game over
		// if isChecked && !isMine -> display surrounding cells = !isMine
		
		
		
		if (this.isChecked) {
			if (!this.isMine) {
				if (this.countOfNeighborMines == 0) {
					return "   ";
				}
				
				else {
					return ANSI_GREEN + String.format (" %s ", this.countOfNeighborMines) + ANSI_RESET ;
				}
			}
			
			else if (this.isMine) {
				return ANSI_RED + " * " + ANSI_RESET;
			}
					
		} else if (!this.isChecked) {
			
//			// testing purposes
//			if (this.isMine) {
//				return " m ";
//			} else if (!this.isMine) {
//					return " x ";
//				}
			
			return " x ";
			}
		
		
//			if (flagged) {
//				return " f ";
//			}
		
//			if (isChecked && !isMine) {
//				return "   ";
//			}
//			
//			else if (this.isMine) {
////				return " m ";
//				return " x ";
//			}
//			else if (isChecked && isMine) {
//				return " m ";
//			}
//			
//			
//			else if (isChecked && countOfNeighborMines == 0) {
////				return "   " ;
//				return " x ";
//			}
			
			//return String.format(" %s ", countOfNeighborMines);
			
			return " y ";
		
	}
	
	
	
	
}
