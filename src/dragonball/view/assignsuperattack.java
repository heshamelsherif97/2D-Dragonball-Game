package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import dragonball.model.attack.Attack;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.exceptions.DuplicateAttackException;
import dragonball.model.exceptions.MaximumAttacksLearnedException;
import dragonball.model.exceptions.NotASaiyanException;
import dragonball.model.game.Game;

public class assignsuperattack extends JFrame implements MouseListener {
	Game g;
	JLabel background;
	JPanel k;
	JPanel k2;
	JPanel k3;
	JPanel k4;
	JPanel k5;

	ButtonGroup g2=new ButtonGroup();
	ButtonGroup g1=new ButtonGroup();
	
	JButton b1=new JButton("Assign Attack");
	JButton b2=new JButton("Uncheck Selections");
	JButton b3=new JButton("Back");

	ArrayList<JRadioButton> pp=new ArrayList<JRadioButton>();
	ArrayList<JRadioButton> ii=new ArrayList<JRadioButton>();
	ArrayList<SuperAttack> y;
	ArrayList<SuperAttack> s;


	JLabel l1=new JLabel("Current Attacks");
	JLabel l2=new JLabel("List of Attacks");
public assignsuperattack(Game g){
	this.g=g;
	setTitle("DragonBall Adventures");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	b3.setIcon(new ImageIcon("backb2.png"));
	b1.setBounds(1500,100,250, 100);
	b2.setBounds(1500,350,250, 100);
	b3.setBounds(1500,600,250, 100);
	
	b1.setIcon(new ImageIcon("assign.png"));
	b2.setIcon(new ImageIcon("uncheck.png"));
	k5=new JPanel();
	b1.addMouseListener(this);
	b2.addMouseListener(this);
	b3.addMouseListener(this);
	add(b1);
	add(b2);
	add(b3);
	
	
	s=g.getPlayer().getActiveFighter().getSuperAttacks();
	y=g.getPlayer().getSuperAttacks();
	
	k=new JPanel();
	k.setLayout(new BoxLayout(k, BoxLayout.Y_AXIS));
	k2=new JPanel();
	k2.setLayout(new BoxLayout(k2, BoxLayout.Y_AXIS));
	k3=new JPanel();
	k3.setLayout(new BoxLayout(k3, BoxLayout.Y_AXIS));
	l1.setFont(new Font("Serif", Font.BOLD,30));
	l2.setFont(new Font("Serif", Font.BOLD,30));
	k.add(l1);
	k2.add(l2);
	addattacks();
	k4=new JPanel();
	k4.add(k2);
	k4.add(k3);
	add(k,BorderLayout.WEST);
	add(k4,BorderLayout.CENTER);

	
	
	setVisible(true);
}

public void addattacks(){
	
	
	
	

	for(int i=0;i<s.size();i++){
		JRadioButton o=new JRadioButton(s.get(i).getName()+"  "+s.get(i).getDamage());
		o.setForeground(Color.BLUE);
		o.setFont(new Font("Serif", Font.BOLD,20));
		k.add(o);
		o.addMouseListener(this);
		g1.add(o);
		pp.add(o);
	}
	
	
	int i;
	for(i=0;i<y.size()/2;i++){
		JRadioButton o=new JRadioButton(y.get(i).getName()+"  "+y.get(i).getDamage());
		o.setForeground(Color.RED);
		o.setFont(new Font("Serif", Font.BOLD,20));
		k2.add(o);
		o.addMouseListener(this);
		g2.add(o);
		ii.add(o);
	}
	for(int j=i;j<y.size();j++){
		JRadioButton o=new JRadioButton(y.get(j).getName()+"  "+y.get(j).getDamage());
		o.setForeground(Color.RED);
		o.setFont(new Font("Serif", Font.BOLD,20));
		k3.add(o);
		o.addMouseListener(this);
		g2.add(o);
		ii.add(o);
	}
}



@Override
public void mouseClicked(MouseEvent e) {
	if(e.getSource()==b1){
		if(g2.getSelection()==null) {
			JOptionPane.showMessageDialog(null, "Error You didnt choose any New Attack");
		}
		else if(g1.getSelection()==null && g2.getSelection()!=null){
			
			
			/*Enumeration<AbstractButton> allRadioButton=g2.getElements(); 
			 JRadioButton temp=null;
		    while(allRadioButton.hasMoreElements())  
		    {  
		        temp=(JRadioButton)allRadioButton.nextElement();  
		       
		    } 
			
		
			
			int index1=ii.indexOf(temp);*/
			
			int i;
		
			for(i=0;i<ii.size();i++){
				if(ii.get(i).isSelected()){
					break;
				}
			}
			
			
	
			SuperAttack ua=y.get(i);
			try {
				g.getPlayer().assignAttack(g.getPlayer().getActiveFighter(), ua,null);
				dispose();
				try {
					Map u=new Map(g);
				} catch (IOException | UnsupportedAudioFileException
						| LineUnavailableException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (MaximumAttacksLearnedException e2 ) {
				JOptionPane.showMessageDialog(null, "You have maxiumum number of attacks learned","Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
			catch(DuplicateAttackException e3){
				JOptionPane.showMessageDialog(null, "You already Have this Attack","Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
			catch(NotASaiyanException e4){
				JOptionPane.showMessageDialog(null, "Your Fighter is not a Saiyan to assign this attack","Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(g1.getSelection()!=null && g2.getSelection()!=null){
			
			int i;
			
			for(i=0;i<ii.size();i++){
				if(ii.get(i).isSelected()){
					break;
				}
			}
			
			
int j;
			
			for(j=0;j<ii.size();j++){
				if(pp.get(j).isSelected()){
					break;
				}
			}
			
			
			
			
			
			SuperAttack old= s.get(j);
			SuperAttack newq=y.get(i);
			try {
				g.getPlayer().assignAttack(g.getPlayer().getActiveFighter(), newq, old);
				dispose();
				try {
					Map u=new Map(g);
				} catch (IOException | UnsupportedAudioFileException
						| LineUnavailableException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (MaximumAttacksLearnedException e2 ) {
				JOptionPane.showMessageDialog(null, "You have maxiumum number of attacks learned","Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
			catch(DuplicateAttackException e3){
				JOptionPane.showMessageDialog(null, "You already Have this Attack","Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
			catch(NotASaiyanException e4){
				JOptionPane.showMessageDialog(null, "Your Fighter is not a Saiyan to assign this attack","Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	else if (e.getSource()==b2){
		g1.clearSelection();
		g2.clearSelection();
	}
	else if(e.getSource()==b3){
		try {
			dispose();
			Map o=new Map(g);
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
