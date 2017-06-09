package dragonball.view;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dragonball.model.attack.Attack;
import dragonball.model.attack.MaximumCharge;
import dragonball.model.attack.SuperSaiyan;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.game.Game;

public class atttack extends JFrame implements MouseListener {
	
	Battle b;
	JComboBox<String>  c;
	ArrayList<JLabel> o;
	ArrayList<Attack> a;
	JButton b1=new JButton("Attack");
	JButton b2=new JButton("Back");
	String [] s;
	BattleEvent e;
	
	
	public atttack(Battle b,BattleEvent e){
		this.b=b;
		this.e=e;
		setTitle("DragonBall Adventures");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600,400);
		setLayout(null);
		 c=new JComboBox<String>();
		 o=new ArrayList<JLabel>();
		 a=b.getAssignedAttacks();
		 s=new String[a.size()];
		
		addattacks();
		c.addMouseListener(this);
		c.setBounds(0,25,300,100);
		c.setFont(new Font("Serif", Font.BOLD,20));
		
		
		b1.setBounds(200,200,150,50);
		b1.setFont(new Font("Serif", Font.BOLD,20));
		
		
		b2.setBounds(200,300,150,50);
		b2.setFont(new Font("Serif", Font.BOLD,20));
		
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		
		add(b1);
		add(b2);
		add(c);
		
		
		//setVisible(true);
	}
	
	public void addattacks(){
		for(int i=0;i<a.size();i++){
			String j=a.get(i).getName()+"  "+a.get(i).getAppliedDamage(b.getAttacker());
			s[i]=j;
		}
		
		for(int i=0;i<s.length;i++){
			c.addItem(s[i]);
		}
		
		
	//	j.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==b1){
			int u=c.getSelectedIndex();
			try {
				b.attack(b.getAssignedAttacks().get(u));
				
				
				dispose();
				Fighter f1=(Fighter) b.getMe();
				Fighter f2=(Fighter) b.getFoe();
				if(!(f1.getHealthPoints()==0||f2.getHealthPoints()==0)){
				computer();
				}
			} catch (NotEnoughKiException e1) {
				
				JOptionPane.showMessageDialog(null, "You dont have enough KI to use this Attack","Inane error",
					    JOptionPane.ERROR_MESSAGE);
	
			}
		}
		else if (e.getSource()==b2){
			dispose();
		}
	}

	
public void computer(){
	
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	try {
		        			b.play();
		        		}  catch (NotEnoughKiException e) {
		        			try {
		        				b.attack(b.getAssignedAttacks().get(0));
		        			} catch (NotEnoughKiException e1) {
		        				
		        			}
		        		}
		            }
		        }, 
		        3000
		);
	
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
