# Fun tictactoe
making tic tac toe have the least amount of draws possible 


# Changes to the rules
- made the grid 5x5 (changing only one constant ``` GRID_SIZE ``` in the ```BoardView Class``` will change the grid to be any n x n grid)
- the player with the most 3 in a row (diagonal, vertical or horizontal) combinations wins the game
- 4 in a row are counted as 2 points and 5 in a row are counted as 3 points (if you are using a 9 x 9 grid for example a 9 in row combination would be 7 points!!)
- if the 2 players got the exact same number of combinations then it's a draw :(
