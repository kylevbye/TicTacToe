package edu.lewisu.cs.group3;

public class BoardGame {
    private final Player playerX, playerO;
    private final Square[] squares;

    public BoardGame() {
        // Initialize players
        playerX = new Player(PlayerType.X);
        playerO = new Player(PlayerType.O);

        // Initialize squares
        squares = new Square[9];
        int squareCount = 0;
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                squares[squareCount] = new Square(row, col);
            }
        }
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
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

    private void checkLinearWinCondition(RowOrCol rowOrCol) {
        int playerXCount = 0, playerOCount = 0;
        for (int i = 1; i <= 3; i++) {
            if (playerXCount >= 3 || playerOCount >= 3) {
                break;
            }
            for (int j = 1; j <= 3; j++) {
                Square square = rowOrCol == RowOrCol.COL ? getSquare(j, i) : getSquare(i, j);
                PlayerType isOccupiedBy = square.getIsOccupiedBy();
                switch (isOccupiedBy) {
                    case X:
                        playerXCount++;
                        if (playerXCount >= 3) {
                            System.out.println("X Wins");
                            playerX.addPlayerScore();
                            break;
                        }
                        continue;
                    case O:
                        playerOCount++;
                        if (playerOCount >= 3) {
                            System.out.println("O Wins");
                            playerO.addPlayerScore();
                            break;
                        }
                        continue;
                    default:
                        continue;
                }
            }
        }
    }

    private void checkDiagonalWinCondition(PosOrNegDiagonal posOrNegDiagonal) {
        int playerXCount = 0, playerOCount = 0;
        for (int row = 1; row <= 3; row++) {
            Square square = getSquare(row, posOrNegDiagonal == PosOrNegDiagonal.POS ? 4 - row : row);
            PlayerType isOccupiedBy = square.getIsOccupiedBy();
            switch (isOccupiedBy) {
                case X:
                    playerXCount++;
                    if (playerXCount >= 3) {
                        System.out.println("X Wins");
                        playerX.addPlayerScore();
                        break;
                    }
                    continue;
                case O:
                    playerOCount++;
                    if (playerOCount >= 3) {
                        System.out.println("O Wins");
                        playerO.addPlayerScore();
                        break;
                    }
                    continue;
                default:
                    continue;
            }
        }
    }

    public void checkWinCondition() {
        checkLinearWinCondition(RowOrCol.ROW);
        checkLinearWinCondition(RowOrCol.COL);
        checkDiagonalWinCondition(PosOrNegDiagonal.POS);
        checkDiagonalWinCondition(PosOrNegDiagonal.NEG);
    }
}
