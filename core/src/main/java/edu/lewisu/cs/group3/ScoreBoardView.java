/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lewisu.cs.group3;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * The Graphical View model of the scoreboard that contains
 * labels for displaying X's score, O's score, and who had
 * just won.
 * 
 * @author Kyle Bye
 */
public class ScoreBoardView implements Drawable {
    
    private Label xScoreLabel;
    private Label oScoreLabel;
    private Label wonLabel;
    private Player[] players;
    
    public final void setXScoreLabel(Label xScoreLabel) { this.xScoreLabel = xScoreLabel; }
    public final void setOScoreLabel(Label oScoreLabel) { this.oScoreLabel = oScoreLabel; }
    public final void setWonLabel(Label wonLabel) {this.wonLabel = wonLabel;}
    public final void setPlayers(Player[] players) { this.players = players; }
    
    public Label getXScoreLabel() { return xScoreLabel; }
    public Label getOScoreLabel() { return oScoreLabel; }
    public Label getWonLabel() { return wonLabel; }
    public Player[] getPlayers() { return players; }
    
    /**
     * Based on what's given, this will set the win text label
     * to display who had just won the round. If null is given,
     * then it is assumed that no one won.
     * 
     * @param player player who won or null (no one won) 
     */
    public void setWinText(Player player) {
        if (player != null) {
            String winFormat = "%s won!";
            wonLabel.setText(String.format(winFormat, player.getPlayerType()));
        }
        else wonLabel.setText("No one wins!");
    }
    
    /**
     * Updates the score labels
     */
    public void update() {
        
        String scoreFormat = "%s:%d";
        xScoreLabel.setText(
                String.format(scoreFormat, players[0].getPlayerType(), players[0].getPlayerScore())
        );
        oScoreLabel.setText(
                String.format(scoreFormat, players[1].getPlayerType(), players[1].getPlayerScore())
        );
    }

    /**
     * Draws the labels to the batch.
     * 
     * Won label is only drawn if it is visible.
     * 
     * @param batch batch to draw on
     * @param parentAlpha opacity
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        xScoreLabel.draw(batch, parentAlpha);
        oScoreLabel.draw(batch, parentAlpha);
        if (wonLabel.isVisible()) wonLabel.draw(batch, parentAlpha);
    }
    
    /**
     * Initializes the view with the provided labels and players
     * to figure out who is x and who is o.
     * 
     * @param xScoreLabel player x's score
     * @param oScoreLabel player o's score
     * @param wonLabel displays who won 
     * @param players playing players
     */
    public ScoreBoardView(Label xScoreLabel, Label oScoreLabel, Label wonLabel, Player[] players) {
        setXScoreLabel(xScoreLabel);
        setOScoreLabel(oScoreLabel);
        setWonLabel(wonLabel);
        setPlayers(players);
        positionLabels();
    }
    
    /**
     * Positions score labels to the top left
     * and positions the won label to the top middle.
     */
    private void positionLabels() {
        xScoreLabel.setPosition(30,420);
        oScoreLabel.setPosition(30,380);
        
        // WonLabel needs center, so we do that.
        wonLabel.setPosition(640*0.5f, 480*0.5f);
        wonLabel.setFontScale(1.5f);
        wonLabel.setAlignment(Align.center);
        
    }
    
    
}
