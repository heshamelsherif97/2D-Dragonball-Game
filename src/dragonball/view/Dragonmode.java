package dragonball.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWish;
import dragonball.model.dragon.DragonWishType;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

public class Dragonmode extends JFrame implements MouseListener {
Game g;
Dragon d;
JLabel background;

ArrayList<JButton> j;
DragonWish[] q;
JPanel k;

	
public Dragonmode(Game g,Dragon d){
	this.d=d;
	this.g=g;
	setTitle("DragonBall Adventures");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);	
	background=new JLabel(new ImageIcon("dragon.png"));
	k=new JPanel();
	j=new ArrayList<JButton>();
	
	
	
	setting();
	add(background);
	

   
	
	setVisible(true);
}


public void setting(){
	 q=d.getWishes();
	 int x=20;
	 int y=520;
	 int w=250;
	 int h=200;
	for(int i=0;i<q.length;i++){
		JButton b=new JButton();
		b.setBounds(x, y, w, h);
		b.addMouseListener(this);
		
		
		if(q[i].getType()==DragonWishType.SENZU_BEANS){
			b.setIcon(new ImageIcon("senzuu.png"));
			
		}
		else if(q[i].getType()==DragonWishType.ABILITY_POINTS){
			b.setIcon(new ImageIcon("ap.png"));
		}
		
		else if(q[i].getType()==DragonWishType.SUPER_ATTACK){
			b.setIcon(new ImageIcon("sa.png"));
		}
		
	else if(q[i].getType()==DragonWishType.ULTIMATE_ATTACK){
		b.setIcon(new ImageIcon("ua.png"));
}
		b.setFont(new Font("Serif", Font.BOLD,25));
		add(b);
		x+=400;
		j.add(b);
	}
	
	
}

@Override
public void mouseClicked(MouseEvent e) {
	JButton u=(JButton) e.getSource();
	int index=j.indexOf(u);
	g.getPlayer().chooseWish(q[index]);
	if(q[index].getType()==DragonWishType.SENZU_BEANS){
		 JOptionPane.showMessageDialog(null, "You have chosen Senzu Beans\nNow you have  "+g.getPlayer().getSenzuBeans());
	}
	else if(q[index].getType()==DragonWishType.ABILITY_POINTS){
		JOptionPane.showMessageDialog(null, "You have chosen Ability Points\nNow you have  "+g.getPlayer().getActiveFighter().getAbilityPoints());
	}
	else if(q[index].getType()==DragonWishType.SUPER_ATTACK){
		 JOptionPane.showMessageDialog(null, "Congrarulations You have unlocked the "+q[index].getSuperAttack().getName()+" Super Attack");
	}
	else if(q[index].getType()==DragonWishType.ULTIMATE_ATTACK){
		 JOptionPane.showMessageDialog(null, "Congrarulations You have unlocked the "+q[index].getUltimateAttack().getName()+" Ultimate Attack");
}
	dispose();
	try {
		Map i=new Map(g);
	} catch (IOException | UnsupportedAudioFileException
			| LineUnavailableException | InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
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
	public static void main(String[]args) throws MissingFieldException, UnknownAttackTypeException{
		Game g=new Game();
		Dragon d=new Dragon("Hossam", new ArrayList<SuperAttack>(), new ArrayList<UltimateAttack>() ,
				7, 8);
		new Dragonmode(g,d);
	}
}
