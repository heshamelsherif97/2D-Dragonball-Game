package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

public class winn extends JFrame implements MouseListener {
	Game g;
	JButton b;
	JLabel background;
	int oldtarget;
	int oldap;
	int lvl;
	int size1;
	int size2;
	
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	
public winn(Game g,int oldtarget,int oldap,int lvl,int size1,int size2){
	this.g=g;
	this.oldtarget=oldtarget;
	this.oldap=oldap;
	this.lvl=lvl;
	this.size1=size1;
	this.size2=size2;
	
	l1=new JLabel();
	l2=new JLabel();
	l3=new JLabel();
	l4=new JLabel();
	l5=new JLabel();
	l6=new JLabel();
	
	l1.setBounds(0,50,600,100);
	l2.setBounds(0,200,600,100);
	l3.setBounds(0,350,600,100);
	l4.setBounds(0,500,600,100);
	l5.setBounds(0,650,600,100);
	l6.setBounds(0,800,600,100);
	
	l1.setFont(new Font("Serif", Font.BOLD,25));
	l2.setFont(new Font("Serif", Font.BOLD,25));
	l3.setFont(new Font("Serif", Font.BOLD,25));
	l4.setFont(new Font("Serif", Font.BOLD,25));
	l5.setFont(new Font("Serif", Font.BOLD,25));
	l6.setFont(new Font("Serif", Font.BOLD,25));
	
	l1.setForeground(Color.WHITE);
	l2.setForeground(Color.WHITE);
	l3.setForeground(Color.WHITE);
	l4.setForeground(Color.WHITE);
	l5.setForeground(Color.WHITE);
	l6.setForeground(Color.WHITE);
	
	settexting();
	
	
	setTitle("DragonBall Adventures");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	b=new JButton(new ImageIcon("continue.png"));
	b.setBounds(850,850,250,100);
	b.addMouseListener(this);
	add(b);
	background=new JLabel(new ImageIcon("win.png"));
	add(l1);
	add(l2);
	add(l3);
	add(l4);
	add(l5);
	add(l6);
	add(background);
	setVisible(true);

}

public void settexting(){
	int difftarget=g.getPlayer().getActiveFighter().getTargetXp()-oldtarget;
	int difflvl=g.getPlayer().getActiveFighter().getLevel()-lvl;
	int diffap=g.getPlayer().getActiveFighter().getAbilityPoints()-oldap;
	
	if(difftarget!=0){
		l6.setText("Your New Target XP is  "+g.getPlayer().getActiveFighter().getTargetXp());
	}
	else{
		l6.setText("Your Target XP is still the Same  " +g.getPlayer().getActiveFighter().getTargetXp());
	}
	
	if(diffap!=0){
		l5.setText("You have gained "+diffap+" AbilityPoints Now You have "+g.getPlayer().getActiveFighter().getAbilityPoints());
	}
	else{
		l5.setText("You havn't gained any Ability Points");
	}
	
	if(difflvl!=0){
		l2.setText("You Have Leveled up Now You are level  "+g.getPlayer().getActiveFighter().getLevel());
	}
	else{
		l2.setText("You are still level  "+g.getPlayer().getActiveFighter().getLevel());
	}
	
	l1.setText("You Now have  "+g.getPlayer().getActiveFighter().getXp()+" Xp");
	
	
	int sadiff=g.getPlayer().getSuperAttacks().size()-size1;
	int uadiff=g.getPlayer().getUltimateAttacks().size()-size2;
	
	
	
	if(sadiff!=0){
		l3.setText("You have learnt "+sadiff+" new Super Attacks");
	}
	else{
		l3.setText("You havn't learnt any new Super Attacks");
	}
	
if(uadiff!=0){
	l4.setText("You have learnt "+uadiff+" new Ultimate Attacks");
	}
	else{
		l4.setText("You havn't learnt any new Ultimate Attacks");
	}
	
	
	
}
@Override
public void mouseClicked(MouseEvent e) {
	if(e.getSource()==b){
		try {
			Map i=new Map(g);
			dispose();
		} catch (IOException | UnsupportedAudioFileException
				| LineUnavailableException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

}
