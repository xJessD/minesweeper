[Project Link](https://github.com/nology-tech/new-zealand-consultancy/tree/main/projects/minesweeper)

# Project: Minesweeper

## Preview

### Game Play - Incorrect Coordinates
![Screenshot](/src/assets/Screenshot_156.png?raw=true "Site Preview")

### Game Play - Game Over
![Screenshot](/src/assets/Screenshot_155.png?raw=true "Site Preview")


## MVP

-   Recreate a simplified version of the game Minesweeper to be played in the java console
x   The game should be able to randomly generate 10 mines in a 10x10 grid
x   The user will be able to enter a command that represents a coordinate to check a location for a mine
x   The application will display a number from 0-8 depending on how many mines surround that location
x   If the user selects a mine, the game will respond "boom!" and the game will be lost
x   If every non-mine square has been revealed, the game is won
x   Render the grid to the console after every user command

## Bonuses (optional)

-   Allow for the user to configure number of mines and grid size via a configuration.json file
-   (Difficult) Discovering an empty square should reveal all squares around it, and cascade into other nearby empty squares