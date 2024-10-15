/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lewisu.cs.group3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;

/**
 * Handles the state of the game of TicTacToe.
 * Manages turn, game board model, win conditions.
 * 
 * @author Kyle Bye
 * @see BoardGame
 * @see Player
 */
public class GameState {
    
    private boolean active;
    private Player turn;
    private Player winner;
    private Player[] players;
    private BoardGame board;
    
    /**
     * Returns the active state flag
     * @return true/false if active/in-active respectively
     */
    public boolean isActive() { return active; }

    /**
     * Returns the turning player's instance. If
     * it is no one's turn, returns null.
     * @return turning player
     */
    public Player getTurn() { return turn; }
    
    /**
     * If game state is active, null is returned.
     * Otherwise, returns the winner of the previously
     * played game.
     * @return player that just won
     */
    public Player getWinner() { return winner; }
    
    /**
     * Sets active flag
     * @param activeFlag true/false if active/in-active respectively
     */
    private final void setActive(boolean activeFlag){ this.active = activeFlag; }
    
    /**
     * Set depending on who's turn it is.
     * @param player turning player
     */
    private final void setTurn(Player player) { this.turn = player;}
    
    /**
     * Sets the winner of the previously played game.
     * @param winner winner of last game
     */
    private final void setWinner(Player winner) { this.winner = winner; }
    
    /**
     * Sets the two participating players
     * @param players Player X and Player Y
     */
    private final void setPlayers(Player[] players) {this.players = players; }
    
    /**
     * Sets the game board
     * @param board gameboard
     */
    private final void setBoard(BoardGame board) { this.board = board; }
    
    /**
     * Sets the game state instance to active. 
     * 
     * Winner is set to null, board is emptied,
     * and turn is set to Player X.
     */
    public void startGame() {
        setTurn(players[0]);
        setActive(true);
        setWinner(null);
        board.restartGame();
    }
    
    /**
     * Finds the square provided by the row and col.
     * 
     * If the square isn't found because row or col is 0, then false
     * is returned and nothing happens.
     * 
     * If a square is found, the function returns true.
     * If the mouse is clicked, and the square is a valid empty square.
     * the turning player takes ownership.
     * 
     * @param row row coordinate of square
     * @param col column coordinate of square
     * @param mouseClicked mouse was clicked during game loop iteration
     * @return true if valid square. false otherwise
     */
    public boolean processSquare(int row, int col, boolean mouseClicked) {
        Square sq = board.getSquare(row, col);
        
        // Invalid square
        if (sq == null) return false;
        
        // Valid empty square, have turning player take ownership
        // if mouse is clicked.
        if (sq.getIsOccupiedBy() == PlayerType.NULL && mouseClicked) {
            sq.setIsOccupiedBy(turn.getPlayerType());
        }
        
        return true;
    }
    
    /**
     * Finds the square provided by the row and col.
     * 
     * If the square isn't found because row or col is 0, then false
     * is returned and nothing happens.
     * 
     * If a square is found, the function returns true.
     * If the mouse is clicked, and the square is a valid empty square.
     * the turning player takes ownership.
     * 
     * @param coords row and column coordinates of square
     * @param mouseClicked mouse was clicked during game loop iteration
     * @return true if valid square. false otherwise
     */
    public boolean processSquare(IntPair coords, boolean mouseClicked) {
        return processSquare(coords.getInt1(), coords.getInt2(), mouseClicked);
    }
    
    /**
     * Increase the turning player's score if there is a winner and set's
     * that player as the winner.
     * If the game is over because the board is full, then no one's
     * score is incremented.
     * 
     * If either of those conditions are met, the game state is set
     * to be in-active and the turn is set to null.
     */
    public void checkWinCondition() {     
        if (board.checkWinCondition(turn)) {
            setWinner(turn);
            turn.addPlayerScore();
            setActive(false);
            setTurn(null);
        }
        else if (board.checkFullCondition()) {
            setWinner(null);
            setActive(false);
            setTurn(null);
        }
    }
    
    /**
     * If the game is not active and the mouse was clicked,
     * then the game is initiated through <code>startGame</code>
     * 
     * Determines the validity of the player choice of the square
     * the mouse is over based on the provided square coordinates.
     * If invalid or not over square, then nothing happens.
     * 
     * If the player is over a square that is empty, then the mouse 
     * cursor is changed to a hand. 
     * 
     * If the mouse was clicked over a valid empty square, 
     * then the square is processed to be owned 
     * by the turning player.
     * 
     * Checks for win conditions and changes turn if necessary.
     * 
     * @param coords square coords mouse is over
     * @param mouseClicked if mouse was clicked during game loop
     * @see startGame()
     * @see squareValid()
     */
    public void update(IntPair coords, boolean mouseClicked) {
        if (!active && mouseClicked) {
            startGame();
            return;
        }  
        boolean squareValid = processSquare(coords, mouseClicked);
        if (squareValid) {
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
            if (mouseClicked) {
                checkWinCondition();
                changeTurns();
            }
        }
    }
    
    /**
     * Swaps the player's turns. 
     * If it is no one's turn, then nothing happens.
     */
    private void changeTurns() {
        if (turn == null) {
            return;
        }
        
        if (turn.getPlayerType() == PlayerType.X) {
            setTurn(players[1]);
        }
        else setTurn(players[0]);
    }
    
    /**
     * Constructs the state of the game using the provided
     * game board. 
     * 
     * Set in-active by default. Must be initiated by calling
     * <code>startGame()</code>
     * 
     * @param board game board
     */
    public GameState(BoardGame board) {
        setActive(false);
        setBoard(board);
        setPlayers(board.getPlayers());
        setWinner(null);
    }
    
}
