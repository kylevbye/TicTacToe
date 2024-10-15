package edu.lewisu.cs.group3;

/**
 * Facade design pattern that represents the
 * TicTacToe game board.
 * 
 * @author Kevin Nguyen
 */
public class BoardGame {
    
    private final Player[] players;
    private final Square[] squares;
    
    /**
     * Returns both players
     * @return X and O Player
     */
    public Player[] getPlayers() { return players; }
    
    /**
     * Returns all squares that exists on the board.
     * @return every square on the board.
     */
    public Square[] getSquares() { return squares; }
    
    /**
     * Constructs the players used for the game and initializes
     * the board with empty squares.
     */
    public BoardGame() {
        // Initialize players
        players = new Player[2];

        players[0] = new Player(PlayerType.X);
        players[1] = new Player(PlayerType.O);

        // Initialize squares
        squares = new Square[9];
        int squareCount = 0;
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                squares[squareCount] = new Square(row, col);
                ++squareCount;
            }
        }
    }
    
    /**
     * Returns the play based on their PlayerType.
     * 
     * @param playerType X or O
     * @return Player with the provided PlayerTyoe
     */
    public Player getPlayer(PlayerType playerType) {
        Player selectedPlayer = new Player(PlayerType.NULL);
        for (Player player : players) {
            if (player.getPlayerType() == playerType) {
                selectedPlayer = player;
                break;
            }
        }
        return selectedPlayer;
    }
    
    /**
     * Returns the square if it exists based on
     * the row and column values provided. Returns
     * null if the square does not exist.
     * 
     * @param row row coordinate
     * @param column column coordinate
     * @return square with provided row and column or null
     */
    public Square getSquare(int row, int column) {
        // Identified square needs some initialization
        Square identifiedSquare = null;

        for (Square square : squares) {
            if (square.getRowCoordinate() == row && square.getColCoordinate() == column) {
                identifiedSquare = square;
                break;
            }
        }
        return identifiedSquare;
    }

    /**
     * Checks both row or col based on the provided enum
     * if the win condition was met.
     * Returns true if the player won/
     * 
     * @param rowOrCol Determine whether to check rows or columns
     * @param player   The player to check the win condition for
     */
    private boolean checkLinearWinCondition(RowOrCol rowOrCol, Player player) {
        int playerMarkCount = 0;
        for (int i = 1; i <= 3; i++) {
            playerMarkCount = 0;
            if (playerMarkCount >= 3) {
                break;
            }
            for (int j = 1; j <= 3; j++) {
                Square square = rowOrCol == RowOrCol.COL ? getSquare(j, i) : getSquare(i, j);
                PlayerType isOccupiedBy = square.getIsOccupiedBy(), playerType = player.getPlayerType();

                if (isOccupiedBy == playerType) {
                    playerMarkCount++;
                    if (playerMarkCount >= 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks both / or \ diagonals for win conditions.
     * Returns true if the player won through a diagonal.
     * 
     * @param posOrNegDiagonal Determine which diagonal to check. Positive diagonal
     *                         is /, negative diagonal is \
     * @param player           The player to check the win condition for
     * @return true/false
     */
    private boolean checkDiagonalWinCondition(PosOrNegDiagonal posOrNegDiagonal, Player player) {
        int playerMarkCount = 0;
        for (int row = 1; row <= 3; row++) {
            Square square = getSquare(row, posOrNegDiagonal == PosOrNegDiagonal.POS ? 4 - row : row);
            PlayerType isOccupiedBy = square.getIsOccupiedBy(), playerType = player.getPlayerType();

            if (isOccupiedBy == playerType) {
                playerMarkCount++;
                if (playerMarkCount >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks the entire board for a three in a row
     * 
     * @param player The player to check the win condition for
     */
    public boolean checkWinCondition(Player player) {
        
        boolean won = false;
        won |= checkLinearWinCondition(RowOrCol.ROW, player);
        won |= checkLinearWinCondition(RowOrCol.COL, player);
        won |= checkDiagonalWinCondition(PosOrNegDiagonal.POS, player);
        won |= checkDiagonalWinCondition(PosOrNegDiagonal.NEG, player);
        
        if (won) {
            System.out.format("Player %s won!", player.getPlayerType());
        }
        return won;
        
    }
    
    /**
     * Returns true if there exists a square that isn't occupied.
     * @return true/false
     */
    public boolean checkFullCondition() {
        
        for (Square square : squares) {
            if (square.getIsOccupiedBy() == PlayerType.NULL) return false;
        }
        
        return true;
    }

    /**
     * Reset all the squares to be empty
     */
    public void restartGame() {
        for (Square square : squares) {
            square.setIsOccupiedBy(PlayerType.NULL);
        }
    }
}
