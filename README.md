# Three-Letter-Game

The Three-Letter Game is a **two-player** game played alternately. The game is played on a **3x3** grid, where each cell can contain one of **three letters:** ***C, S, or E***.

Players take turns placing one of the letters in an empty cell of the grid. The goal of the game is for one of the players to form one of the two final triplets: ***'CSE'*** or ***'ESC'***. Final triplets can be formed horizontally, vertically, or diagonally in consecutive grid positions.The game starts from an initial state where either an 'S' is mandatory in either the left or right position of the middle row.

The computer plays optimally by executing the **MINIMAX algorithm** with the current state as the root to decide on each move. The implementation of MINIMAX is done using recursion.


