package dragonball.view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

public class Gameover extends JFrame implements MouseListener {
	Game g;
	JButton b;
	JLabel background;
	
public Gameover(Game g){
	this.g=g;
	setTitle("DragonBall Adventures");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	//setLayout(null);
	b=new JButton(new ImageIcon("continue.png"));
	b.setBounds(850,800,250,100);
	b.addMouseListener(this);
	add(b);
	background=new JLabel(new ImageIcon("over.png"));
	add(background);
	setVisible(true);
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
