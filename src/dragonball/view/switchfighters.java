package dragonball.view;

import java.awt.GridLayout;
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
import javax.swing.JPanel;

import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.game.Game;

public class switchfighters extends JFrame implements MouseListener {
Game g;
JLabel background;
JPanel k;
ArrayList<JButton> j;

	public switchfighters(Game g){
		setTitle("DragonBall Adventures");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1600,900);
		this.g=g;
		j=new ArrayList<JButton>();
		ArrayList<PlayableFighter> a=g.getPlayer().getFighters();
		k=new JPanel(new GridLayout(0,3));
		addBtn(a);
		add(k);
		
		setVisible(true);
	}
public void addBtn(ArrayList<PlayableFighter> a){
	for(int i=0;i<a.size();i++){
		String name=a.get(i).getName();
		int lvl=a.get(i).getLevel();
		String t="Name :-  "+name+"   Level :-   "+lvl;
		JButton f=new JButton(t);
		k.add(f);
		f.addMouseListener(this);
		j.add(f);
	}
}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton t=(JButton)e.getSource();
		int index=j.indexOf(t);
		g.getPlayer().setActiveFighter(g.getPlayer().getFighters().get(index));
		try {
			Map q=new Map(g);
		} catch (IOException | UnsupportedAudioFileException
				| LineUnavailableException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dispose();
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
