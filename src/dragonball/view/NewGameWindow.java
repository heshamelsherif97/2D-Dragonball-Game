package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.player.Player;

public class NewGameWindow extends JFrame implements MouseListener  {
JTextField t1;
JTextField t2;
Game g;
Map m;

JLabel background;

JRadioButton k1;
JRadioButton k2;
JRadioButton k3;
JRadioButton k4;
JRadioButton k5;
ButtonGroup group;

JButton j1;
JButton j2;
JButton j3;
JButton j4;
JButton j5;
JButton j6;
JButton j7;


JButton j8;
JButton j9;
JButton j10;
JButton j11;
JButton j12;



public NewGameWindow(Game g)throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
	setTitle("DragonBall Adventures");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.g=g;
	//setLayout(null);
	j1=new JButton();
	j1.setBounds(1100, 100, 300, 100);
	j1.setIcon(new ImageIcon("create.png"));
	j1.addMouseListener(this);
	add(j1);
	Font myFont = new Font("Serif", Font.BOLD, 58);
	j1.setFont(myFont);
	j1.setForeground(Color.BLUE);
	Font myFont2 = new Font("Serif", Font.BOLD, 48);
	
	j2=new JButton("");
	j2.setBounds(1600, 100, 300, 100);
	j2.setIcon(new ImageIcon("backb1.png"));
	j2.addMouseListener(this);
	add(j2);
	
	
	
	
	t1=new JTextField();
	t2=new JTextField();
	t1.setBounds(300, 120, 500 ,50);
	t2.setBounds(300, 240, 500 ,50);
	//t1.addMouseListener(this);
	//t2.addMouseListener(this);
	t1.setFont(myFont2);
	t2.setFont(myFont2);
	add(t1);
	add(t2);
	
	
	k1=new JRadioButton();
	k2=new JRadioButton();
	k3=new JRadioButton();
	k4=new JRadioButton();
	k5=new JRadioButton();
	k1.setBounds(150, 350, 150,50);
	k2.setBounds(600, 350, 160,50);
	k3.setBounds(1000, 350, 150,50);
	k4.setBounds(1400, 350, 150,50);
	k5.setBounds(1700, 350, 150,50);
	k1.setText("Saiyan");
	k2.setText("Namekian");
	k3.setText("Majin");
	k4.setText("Frieza");
	k5.setText("Earthling");
	
	k1.setFont(new Font("Serif", Font.BOLD,30));
	k2.setFont(new Font("Serif", Font.BOLD,30));
	k3.setFont(new Font("Serif", Font.BOLD,30));
	k4.setFont(new Font("Serif", Font.BOLD,30));
	k5.setFont(new Font("Serif", Font.BOLD,30));
	k1.addMouseListener(this);
	k2.addMouseListener(this);
	k3.addMouseListener(this);
	k4.addMouseListener(this);
	k5.addMouseListener(this);
	 group = new ButtonGroup();

	group.add(k1);
	group.add(k5);
	group.add(k4);
	group.add(k3);
	group.add(k2);
	add(k1);
	add(k2);
	add(k3);
	add(k4);
	add(k5);
	
	 
	 
	background=new JLabel(new ImageIcon("back2.png"));
	add(background);
	setVisible(true);	
}

@Override
public void mouseClicked(MouseEvent e) {
	
	 if(e.getSource()==j1 && t1.getText().equals("")){
		 JOptionPane.showMessageDialog(null, "Error You didnt choose a Player Name","Inane error",
				    JOptionPane.ERROR_MESSAGE);
	 }
	 else if(e.getSource()==j1 && t2.getText().equals("")){
		 JOptionPane.showMessageDialog(null, "Error You didnt choose a Character Name","Inane error",
				    JOptionPane.ERROR_MESSAGE);
	 }
	else if(e.getSource()==j1 && !(t2.getText().equals("")) && !(t1.getText().equals("")) && group.getSelection()!=null){
		try {
			g.getPlayer().setName(t1.getText());
			if(k1.isSelected()){
				g.getPlayer().createFighter('S', t2.getText());
			}
			else if(k2.isSelected()){
				g.getPlayer().createFighter('N', t2.getText());
				}
			else if(k3.isSelected()){
				g.getPlayer().createFighter('M', t2.getText());
				}
			else if(k4.isSelected()){
				g.getPlayer().createFighter('F', t2.getText());
				}
			else if(k5.isSelected()){
				g.getPlayer().createFighter('E', t2.getText());
				}
			setVisible(false);
			m=new Map(g);
		} catch (MissingFieldException e1) {
		} catch (UnknownAttackTypeException e1) {
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
}
	else if(e.getSource()==j1 && !(t2.getText().equals("")) && !(t1.getText().equals("")) && group.getSelection()==null){
		 JOptionPane.showMessageDialog(null, "Error You didnt choose a Race","Inane error",
				    JOptionPane.ERROR_MESSAGE);
	}
	else if(e.getSource()==j2){
		dispose();
		try {
			Dragonballview v=new Dragonballview();
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
