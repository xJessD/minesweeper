package Minesweeper;

import java.util.Scanner;

public class Minesweeper {
	static Game game;
	static int rows;
	static int cols;
	
	static public void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		
		
//		//get user input?
//		System.out.println("Please enter rows and columns");
//		int rows = scanner.nextInt();
//		int cols = scanner.nextInt();
//		System.out.println(rows);
//		System.out.println(cols);
//		
		
		
		// rows + cols
		rows = 10;
		cols = 10;
		
		// create the grid and render the initial cells
		game = new Game(rows, cols);
		
		// create the mines (maybe put this inside Game)
		//game.renderMines();
		
		
		// while player hasn't won or lost
		while(!game.gameLost && !game.gameWon()) {
//			
//			// render grid
			game.render();
			
			// Scanner for user input
			Scanner scanner = new Scanner(System.in); 
			System.out.println("\n\n");
			System.out.println("Please enter coordinates to check");
			
			boolean correctInput = false;
			int x = 0;
			int y = 0;
			
			while (correctInput == false) {
				try {
					x = scanner.nextInt();
					y = scanner.nextInt();
					
					if (x >= 0 && x < rows && y >= 0 && y < cols) 
						correctInput = true;
					
					else {
						System.out.println("Coordinates are not in range. Try again");
					}
				}
				catch (Exception e) {
					scanner.next();
					System.out.println("Please enter the correct coordinates");
				}
			}

			
			
			// check coordinates
			game.check(x, y);
			
			if (game.gameWon()) {
				game.render();
				
				System.out.println();
				System.out.println("You've won!");
				replay(scanner);
				
			}
			
			if (game.gameLost == true) {
				game.render();
				
				System.out.println();
				System.out.println("Game Over!");
				replay(scanner);
								
			}
		}
	}
	
	public static void replay(Scanner scanner) {
		
		System.out.println();
		System.out.println("Would you like to play again? y / n");
		
		if (scanner.hasNext("y")){
			reset(rows, cols);
		} 
		
		else if (scanner.hasNext("n")) {
			
			System.out.println();
			System.out.println("Sure, see you next time.");
		}
		
	}
	
	
	public static void reset(int rows, int cols) {
		System.out.println();
		System.out.println("Lets play again!");
		game = new Game(rows, cols);
	}
}
