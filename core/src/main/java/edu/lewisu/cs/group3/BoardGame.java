package edu.lewisu.cs.group3;

// Board game class will serve as a facade
public class BoardGame {
    private final Player[] players;
    private final Square[] squares;

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
            }
        }
    }

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

    public Square getSquare(int row, int column) {
        // Identified square needs some initialization
        Square identifiedSquare = new Square(0, 0);

        for (Square square : squares) {
            if (square.getRowCoordinate() == row && square.getColCoordinate() == column) {
                identifiedSquare = square;
                break;
            }
        }
        return identifiedSquare;
    }

    /**
     * Checks both / and \ diagonals for win conditions
     * 
     * @param rowOrCol Determine whether to check rows or columns
     * @param player   The player to check the win condition for
     */
    private void checkLinearWinCondition(RowOrCol rowOrCol, Player player) {
        int playerMarkCount = 0;
        for (int i = 1; i <= 3; i++) {
            if (playerMarkCount >= 3) {
                break;
            }
            for (int j = 1; j <= 3; j++) {
                Square square = rowOrCol == RowOrCol.COL ? getSquare(j, i) : getSquare(i, j);
                PlayerType isOccupiedBy = square.getIsOccupiedBy(), playerType = player.getPlayerType();

                if (isOccupiedBy == playerType) {
                    playerMarkCount++;
                    if (playerMarkCount >= 3) {
                        System.out.printf("Player %s wins!", playerType.name());
                        player.addPlayerScore();
                        break;
                    }
                }
            }
        }
    }

    /**
     * Checks both / or \ diagonals for win conditions
     * 
     * @param posOrNegDiagonal Determine which diagonal to check. Positive diagonal
     *                         is /, negative diagonal is \
     * @param player           The player to check the win condition for
     */
    private void checkDiagonalWinCondition(PosOrNegDiagonal posOrNegDiagonal, Player player) {
        int playerMarkCount = 0;
        for (int row = 1; row <= 3; row++) {
            Square square = getSquare(row, posOrNegDiagonal == PosOrNegDiagonal.POS ? 4 - row : row);
            PlayerType isOccupiedBy = square.getIsOccupiedBy(), playerType = player.getPlayerType();

            if (isOccupiedBy == playerType) {
                playerMarkCount++;
                if (playerMarkCount >= 3) {
                    System.out.printf("Player %s wins!", playerType.name());
                    player.addPlayerScore();
                    break;
                }
            }
        }
    }

    /**
     * Checks the entire board for a three in a row
     * 
     * @param player The player to check the win condition for
     */
    public void checkWinCondition(Player player) {
        checkLinearWinCondition(RowOrCol.ROW, player);
        checkLinearWinCondition(RowOrCol.COL, player);
        checkDiagonalWinCondition(PosOrNegDiagonal.POS, player);
        checkDiagonalWinCondition(PosOrNegDiagonal.NEG, player);
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
