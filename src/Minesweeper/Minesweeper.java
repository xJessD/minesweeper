package Minesweeper;

public class Minesweeper {
	
	static public void main(String[] args) {
		
		// get user input
		
		// rows + cols
		int rows = 10;
		int cols = 10;
		
		// create the grid and render the initial cells
		Game game= new Game(rows, cols);
		
		// create the mines (maybe keep this inside Game)
		game.renderMines();
		
		// render displays the cells based on condition
		game.render();
		
		// while player hasn't won or lost
//		while(!game.over) {
//			
//			// render grid
//			game.Render();
//			
//			// get move
//			// check move
//			PlayerGuess playerGuess = new PlayerGuess();
//			playerGuess.GetGuess();
//			game.Guess(playerGuess);
//		}
		
		
		
		
		
		
			
			
			
		
	}
}
