# Three-Letter-Game

The Three-Letter Game is a **two-player** game played alternately. The game is played on a **3x3** grid, where each cell can contain one of **three letters:** ***C, S, or E***.
  
  Players take turns placing one of the letters in an empty cell of the grid. The goal of the game is for one of the players to form one of the two final triplets: ***'CSE'*** or ***'ESC'***. Final triplets can be formed horizontally, vertically, or diagonally in       consecutive grid positions.The game starts from an initial state where either an 'S' is mandatory in either the left or right position of the middle row.

  The computer plays optimally by executing the **MINIMAX algorithm** with the current state as the root to decide on each move. The implementation of MINIMAX is done using recursion.
 ### **How to play**
1. Initialization: The game board is initialized with one random cell containing the letter 'S'.
   
2. Player Turn: The user plays first and is prompted to provide the following details for their move:
      - Enter the row (0-2):
          - *Choose between 0-2 for first , second or third row, respectively*
      - Enter the column (0-2):
          - *Choose between 0-2 for first , second or third column, respectively*
      - Enter your move ('C', 'S', or 'E'):
          - *Choose which letter you will play*
3. Computer Move: After the user’s move, the computer decides its next move using the MINIMAX algorithm. The algorithm evaluates the current state of the game and selects the optimal move.
   
4. Game Continuation: The game continues until one player completes the formation of either ***'CSE'*** or ***'ESC'***.

