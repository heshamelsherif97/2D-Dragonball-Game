package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.NotEnoughAbilityPointsException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

public class upgradefighter extends JFrame implements MouseListener {
Game g;

JLabel background;


JPanel k1;




JButton b1;

JLabel l1;

JButton r1;
JButton r2;
JButton r3;
JButton r4;
JButton r5;



JLabel l2=new JLabel();
JLabel l3=new JLabel();
JLabel l4=new JLabel();
JLabel l5=new JLabel();
JLabel l6=new JLabel();

	public upgradefighter(Game g){
		this.g=g;
		background=new JLabel(new ImageIcon("back4.png"));
		
		setTitle("DragonBall Adventures");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	//    setLayout(null);
	    b1=new JButton();
		r1=new JButton();
		r2=new JButton();
		r3=new JButton();
		r4=new JButton();
		r5=new JButton();
		r1.setBounds(600, 50, 300, 150);
		r2.setBounds(600, 200, 300, 150);
		r3.setBounds(600,350, 300, 150);
		r4.setBounds(600, 500, 300,150);
		r5.setBounds(600, 650, 300, 150);
		b1.setBounds(1500,800,300,150);
		b1.setIcon(new ImageIcon("backb1.png"));
		l1=new JLabel();
		l1.setBounds(700,750,600,300);
		settingtext();
		
		
		l2.setBounds(0,50,600,100);
		l3.setBounds(0,200,600,100);
		l4.setBounds(0,350,600,100);
		l5.setBounds(0,500,600,100);
		l6.setBounds(0,650,600,100);
		
		l1.setFont(new Font("Serif", Font.BOLD,25));
		l2.setFont(new Font("Serif", Font.BOLD,25));
		l3.setFont(new Font("Serif", Font.BOLD,25));
		l4.setFont(new Font("Serif", Font.BOLD,25));
		l5.setFont(new Font("Serif", Font.BOLD,25));
		l6.setFont(new Font("Serif", Font.BOLD,25));
		
		add(l1);
		add(b1);
		
		r1.setText("Health Points");
		r2.setText("Blast Damage");
		r3.setText("Physical Damage");
		r4.setText("KI");
		r5.setText("Stamina");
		
		r1.setFont(new Font("Serif", Font.BOLD,25));
		r2.setFont(new Font("Serif", Font.BOLD,25));
		r3.setFont(new Font("Serif", Font.BOLD,25));
		r4.setFont(new Font("Serif", Font.BOLD,25));
		r5.setFont(new Font("Serif", Font.BOLD,25));
		
		r1.setForeground(Color.BLACK);
		r2.setForeground(Color.BLACK);
		r3.setForeground(Color.BLACK);
		r4.setForeground(Color.BLACK);
		r5.setForeground(Color.BLACK);
		add(r1);
		add(r2);
		add(r3);
		add(r4);
		add(r5);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		//l2.setBounds();
		
		b1.addMouseListener(this);
		r1.addMouseListener(this);
		r2.addMouseListener(this);
		r3.addMouseListener(this);
		r4.addMouseListener(this);
		r5.addMouseListener(this);
		
		
		add(background);
		setVisible(true);
	}

public void settingtext(){
	l1.setText("Your current Ability Points :-   "+g.getPlayer().getActiveFighter().getAbilityPoints());
	
	l2.setText("You can upgrade your Max Health  "+g.getPlayer().getActiveFighter().getMaxHealthPoints()+" +50");
	l3.setText("You can upgrade your Blast Damage  "+g.getPlayer().getActiveFighter().getBlastDamage()+" +50");
	l4.setText("You can upgrade your Physical Damage  "+g.getPlayer().getActiveFighter().getPhysicalDamage()+"  +50");
	l5.setText("You can upgrade your Max KI  "+g.getPlayer().getActiveFighter().getMaxKi()+"  +1");
	l6.setText("You can upgrade your Max Stamina  "+g.getPlayer().getActiveFighter().getMaxStamina()+" +1");
}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==b1){
			dispose();
			try {
				Map i=new Map(g);
			} catch (IOException | UnsupportedAudioFileException
					| LineUnavailableException | InterruptedException e1) {
			
			}
		}
		
		else if(e.getSource()==r1){
			try {
				g.getPlayer().upgradeFighter(g.getPlayer().getActiveFighter(), 'H');
				settingtext();
			} catch (NotEnoughAbilityPointsException e1) {
				JOptionPane.showMessageDialog(null, "You dont have enough Ability Points");
			}
		}
		else if(e.getSource()==r2){
			try {
				g.getPlayer().upgradeFighter(g.getPlayer().getActiveFighter(), 'B');
				settingtext();
			} catch (NotEnoughAbilityPointsException e1) {
				JOptionPane.showMessageDialog(null, "You dont have enough Ability Points");
			}
		}
		else if(e.getSource()==r3){
			try {
				g.getPlayer().upgradeFighter(g.getPlayer().getActiveFighter(), 'P');
				settingtext();
			} catch (NotEnoughAbilityPointsException e1) {
				JOptionPane.showMessageDialog(null, "You dont have enough Ability Points");
			}
		}
		else if(e.getSource()==r4){
			try {
				g.getPlayer().upgradeFighter(g.getPlayer().getActiveFighter(), 'K');
				settingtext();
			} catch (NotEnoughAbilityPointsException e1) {
				JOptionPane.showMessageDialog(null, "You dont have enough Ability Points");
			}
		}
		else if(e.getSource()==r5){
			try {
				g.getPlayer().upgradeFighter(g.getPlayer().getActiveFighter(), 'S');
				settingtext();
			} catch (NotEnoughAbilityPointsException e1) {
				JOptionPane.showMessageDialog(null, "You dont have enough Ability Points");
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
