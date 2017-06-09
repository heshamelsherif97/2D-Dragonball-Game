package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.model.world.World;
import dragonball.view.Dragonballview;

public class gui implements ActionListener {
private Dragonballview d;
	public gui() throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException{
		d=new Dragonballview();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
public static void main(String[]args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException{
new gui();

}
}
