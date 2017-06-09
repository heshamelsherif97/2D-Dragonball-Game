package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.battle.BattleOpponent;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

public class newBattle extends JFrame implements MouseListener {
Game g;
BattleEvent e;
JLabel background=new JLabel(new ImageIcon("battle.png"));
JButton b1=new JButton("");
Battlemode bg;

public newBattle(Game g, BattleEvent e){
	this.g=g;
	this.e=e;
	  setTitle("DragonBall Adventures");
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setExtendedState(JFrame.MAXIMIZED_BOTH); 
	  b1.setBounds(800,700,250,150);
	  b1.setForeground(Color.RED);
	  b1.setFont(new Font("Serif", Font.BOLD,30));
	  b1.addMouseListener(this);
	  b1.setIcon(new ImageIcon("start.png"));
	  add(b1);
	  
	  
	  bg=new Battlemode(g, e);
	  
	  add(background);
	  setVisible(true);
}


@Override
public void mouseClicked(MouseEvent e1) {
	if(e1.getSource()==b1){
		bg.setVisible(true);
		dispose();
	}
	
}


@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

	
	public void onEvent(BattleEvent e){
		
		
			bg.onBattleEvent(e);
		
	}
	
}
