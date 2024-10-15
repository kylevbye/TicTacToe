/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lewisu.cs.group3;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
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
    
    public void setWinText(Player player) {
        if (player != null) {
            String winFormat = "%s won!";
            wonLabel.setText(String.format(winFormat, player.getPlayerType()));
        }
        else wonLabel.setText("No one wins!");
    }
    
    public void update() {
        
        String scoreFormat = "%s:%d";
        xScoreLabel.setText(
                String.format(scoreFormat, players[0].getPlayerType(), players[0].getPlayerScore())
        );
        oScoreLabel.setText(
                String.format(scoreFormat, players[1].getPlayerType(), players[1].getPlayerScore())
        );
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        xScoreLabel.draw(batch, parentAlpha);
        oScoreLabel.draw(batch, parentAlpha);
        if (wonLabel.isVisible()) wonLabel.draw(batch, parentAlpha);
    }
    
    public ScoreBoardView(Label xScoreLabel, Label oScoreLabel, Label wonLabel, Player[] players) {
        setXScoreLabel(xScoreLabel);
        setOScoreLabel(oScoreLabel);
        setWonLabel(wonLabel);
        setPlayers(players);
        positionLabels();
    }
    
    private void positionLabels() {
        xScoreLabel.setPosition(30,420);
        oScoreLabel.setPosition(30,380);
        
        // WonLabel needs center, so we do that.
        wonLabel.setPosition(640*0.5f, 480*0.5f);
        wonLabel.setFontScale(1.5f);
        wonLabel.setAlignment(Align.center);
        
    }
    
    
}
