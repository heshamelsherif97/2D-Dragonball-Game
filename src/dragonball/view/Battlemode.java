package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dragonball.model.attack.Attack;
import dragonball.model.attack.MaximumCharge;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.SuperSaiyan;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.cell.Collectible;
import dragonball.model.cell.FoeCell;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;

public class Battlemode extends JFrame implements MouseListener  {
Game g;
BattleEvent e;

JPanel k1;
JPanel k2;
JPanel k3;
JPanel k4;

JLabel l1;

JTextArea t1;
JTextArea t2;

Fighter f1;
Fighter f2;
Battle b;

JButton b1;
JButton b2;
JButton b3;

int oldtarget;
int oldlvl;
int oldap;
int size1;
int size2;

JLabel luo=new JLabel("                          \n\n");
atttack ac;
	
	public Battlemode(Game g,BattleEvent e){
		this.g=g;
		this.e=e;
		b=(Battle) e.getSource();
		f1=(Fighter) b.getMe();
		f2=(Fighter) b.getFoe();
		
		ac=new atttack(b,e);
		
		oldtarget=g.getPlayer().getActiveFighter().getTargetXp();
		oldlvl=g.getPlayer().getActiveFighter().getLevel();
		oldap=g.getPlayer().getActiveFighter().getAbilityPoints();
		size1=g.getPlayer().getSuperAttacks().size();
		size2=g.getPlayer().getUltimateAttacks().size();
		
		
		
		
		setTitle("DragonBall Adventures");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		t1=new JTextArea();
		t2=new JTextArea();
		t1.setEditable(false);
		t2.setEditable(false);
		l1=new JLabel();
		t1.setSize(400,200);
		
		
		
		
		
		k1=new JPanel();
		k2=new JPanel();
		
		
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		
		
		
		b1.setText("Attack");
		b2.setText("Block");
		b3.setText("Use");
		
		b1.setFont(new Font("Serif", Font.BOLD, 40));
		b2.setFont(new Font("Serif", Font.BOLD, 40));
		b3.setFont(new Font("Serif", Font.BOLD, 40));
		
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		b3.addMouseListener(this);
		
		
	
		
		
		
		settexting();
		k1.add(t1);
		k2.add(t2);
		
		
		k3=new JPanel();
		k3.setLayout(new BoxLayout(k3, BoxLayout.Y_AXIS));
		
		luo.setFont(new Font("Serif", Font.BOLD, 40));
		luo.setForeground(Color.RED);
		
		
		
		k3.add(b1);
		k3.add(b2);
		k3.add(b3);
		
		k4=new JPanel();
		k4.setLayout(new BoxLayout(k4, BoxLayout.Y_AXIS));
		k4.add(k1);
		k4.add(k3);
		
		add(l1,BorderLayout.NORTH);
		
		add(k4,BorderLayout.WEST);
		add(k2,BorderLayout.EAST);
		
		//add(luo,BorderLayout.CENTER);
		
		
		JPanel k7=new JPanel();
		JPanel k8=new JPanel();
		JPanel k9=new JPanel();
		JPanel k10=new JPanel();
		
		
		
		
		
		JLabel background=new JLabel(new ImageIcon("batttle.gif"));
		
		k7.setLayout(new BoxLayout(k7, BoxLayout.Y_AXIS));
		
		
		k7.add(luo);
		k7.add(background);
		add(k7,BorderLayout.CENTER);
		
		
		//add(background,BorderLayout.CENTER);
		

		
	}

public void settexting(){
	
	
	boolean f1block=b.isMeBlocking();
	
	boolean f2block=b.isFoeBlocking();
	
	if(f1 instanceof Saiyan  ){
	
	if(f1block==true){
	t1.setText("Name :-  "+f1.getName()+
			"\n\nLevel :-  "+f1.getLevel()+
			"\n\nCurrent HP :-  "+f1.getHealthPoints()+
			"\n\nMax HP :-  "+f1.getMaxHealthPoints()+
			"\n\nCurrent Stamina :-  "+f1.getStamina()+
			"\n\nMax Stamina :-  "+f1.getMaxStamina()+
			"\n\nCurrent Ki :-  "+f1.getKi()+
			"\n\nMax Ki :-  "+f1.getMaxKi()+
			"\n\nState :-  Blocking"+
			"\n\nSenzuBeans :- "+g.getPlayer().getSenzuBeans()
			+
					"\n\nSuperSaiyan :-"+((Saiyan)g.getPlayer().getActiveFighter()).isTransformed()
			);
	
	

	
	t2.setText("Name :-  "+f2.getName()+
			"\n\nLevel :-  "+f2.getLevel()+
			"\n\nCurrent HP :-  "+f2.getHealthPoints()+
			"\n\nMax HP :-  "+f2.getMaxHealthPoints()+
			"\n\nCurrent Stamina :-  "+f2.getStamina()+
			"\n\nMax Stamina :-  "+f2.getMaxStamina()+
			"\n\nCurrent Ki :-  "+f2.getKi()+
			"\n\nMax Ki :-  "+f2.getMaxKi()+
			"\n\nState :- Not Blocking"
			);
	}
	else if(f2block==true){
		t1.setText("Name :-  "+f1.getName()+
				"\n\nLevel :-  "+f1.getLevel()+
				"\n\nCurrent HP :-  "+f1.getHealthPoints()+
				"\n\nMax HP :-  "+f1.getMaxHealthPoints()+
				"\n\nCurrent Stamina :-  "+f1.getStamina()+
				"\n\nMax Stamina :-  "+f1.getMaxStamina()+
				"\n\nCurrent Ki :-  "+f1.getKi()+
				"\n\nMax Ki :-  "+f1.getMaxKi()+
				"\n\nState :-  Not Blocking"+
						"\n\nSenzuBeans :- "+g.getPlayer().getSenzuBeans()+
						"\n\nSuperSaiyan :-"+((Saiyan)g.getPlayer().getActiveFighter()).isTransformed()
				);
		
		

		
		t2.setText("Name :-  "+f2.getName()+
				"\n\nLevel :-  "+f2.getLevel()+
				"\n\nCurrent HP :-  "+f2.getHealthPoints()+
				"\n\nMax HP :-  "+f2.getMaxHealthPoints()+
				"\n\nCurrent Stamina :-  "+f2.getStamina()+
				"\n\nMax Stamina :-  "+f2.getMaxStamina()+
				"\n\nCurrent Ki :-  "+f2.getKi()+
				"\n\nMax Ki :-  "+f2.getMaxKi()+
				"\n\nState :-  Blocking"
				);
		}
	else{
		t1.setText("Name :-  "+f1.getName()+
				"\n\nLevel :-  "+f1.getLevel()+
				"\n\nCurrent HP :-  "+f1.getHealthPoints()+
				"\n\nMax HP :-  "+f1.getMaxHealthPoints()+
				"\n\nCurrent Stamina :-  "+f1.getStamina()+
				"\n\nMax Stamina :-  "+f1.getMaxStamina()+
				"\n\nCurrent Ki :-  "+f1.getKi()+
				"\n\nMax Ki :-  "+f1.getMaxKi()+
				"\n\nState :-  Not Blocking" +
						"\n\nSenzuBeans :- "+g.getPlayer().getSenzuBeans()+
						"\n\nSuperSaiyan :-"+((Saiyan)g.getPlayer().getActiveFighter()).isTransformed()
				);
		
		

		
		t2.setText("Name :-  "+f2.getName()+
				"\n\nLevel :-  "+f2.getLevel()+
				"\n\nCurrent HP :-  "+f2.getHealthPoints()+
				"\n\nMax HP :-  "+f2.getMaxHealthPoints()+
				"\n\nCurrent Stamina :-  "+f2.getStamina()+
				"\n\nMax Stamina :-  "+f2.getMaxStamina()+
				"\n\nCurrent Ki :-  "+f2.getKi()+
				"\n\nMax Ki :-  "+f2.getMaxKi()+
				"\n\nState :-  Not Blocking"
				);
	}
	}
	else{
		if(f1block==true){
			t1.setText("Name :-  "+f1.getName()+
					"\n\nLevel :-  "+f1.getLevel()+
					"\n\nCurrent HP :-  "+f1.getHealthPoints()+
					"\n\nMax HP :-  "+f1.getMaxHealthPoints()+
					"\n\nCurrent Stamina :-  "+f1.getStamina()+
					"\n\nMax Stamina :-  "+f1.getMaxStamina()+
					"\n\nCurrent Ki :-  "+f1.getKi()+
					"\n\nMax Ki :-  "+f1.getMaxKi()+
					"\n\nState :-  Blocking"+
					"\n\nSenzuBeans :- "+g.getPlayer().getSenzuBeans()
					
							
					);
			
			

			
			t2.setText("Name :-  "+f2.getName()+
					"\n\nLevel :-  "+f2.getLevel()+
					"\n\nCurrent HP :-  "+f2.getHealthPoints()+
					"\n\nMax HP :-  "+f2.getMaxHealthPoints()+
					"\n\nCurrent Stamina :-  "+f2.getStamina()+
					"\n\nMax Stamina :-  "+f2.getMaxStamina()+
					"\n\nCurrent Ki :-  "+f2.getKi()+
					"\n\nMax Ki :-  "+f2.getMaxKi()+
					"\n\nState :- Not Blocking"
					);
			}
			else if(f2block==true){
				t1.setText("Name :-  "+f1.getName()+
						"\n\nLevel :-  "+f1.getLevel()+
						"\n\nCurrent HP :-  "+f1.getHealthPoints()+
						"\n\nMax HP :-  "+f1.getMaxHealthPoints()+
						"\n\nCurrent Stamina :-  "+f1.getStamina()+
						"\n\nMax Stamina :-  "+f1.getMaxStamina()+
						"\n\nCurrent Ki :-  "+f1.getKi()+
						"\n\nMax Ki :-  "+f1.getMaxKi()+
						"\n\nState :-  Not Blocking"+
								"\n\nSenzuBeans :- "+g.getPlayer().getSenzuBeans()
						);
				
				

				
				t2.setText("Name :-  "+f2.getName()+
						"\n\nLevel :-  "+f2.getLevel()+
						"\n\nCurrent HP :-  "+f2.getHealthPoints()+
						"\n\nMax HP :-  "+f2.getMaxHealthPoints()+
						"\n\nCurrent Stamina :-  "+f2.getStamina()+
						"\n\nMax Stamina :-  "+f2.getMaxStamina()+
						"\n\nCurrent Ki :-  "+f2.getKi()+
						"\n\nMax Ki :-  "+f2.getMaxKi()+
						"\n\nState :-  Blocking"
						);
				}
			else{
				t1.setText("Name :-  "+f1.getName()+
						"\n\nLevel :-  "+f1.getLevel()+
						"\n\nCurrent HP :-  "+f1.getHealthPoints()+
						"\n\nMax HP :-  "+f1.getMaxHealthPoints()+
						"\n\nCurrent Stamina :-  "+f1.getStamina()+
						"\n\nMax Stamina :-  "+f1.getMaxStamina()+
						"\n\nCurrent Ki :-  "+f1.getKi()+
						"\n\nMax Ki :-  "+f1.getMaxKi()+
						"\n\nState :-  Not Blocking" +
								"\n\nSenzuBeans :- "+g.getPlayer().getSenzuBeans()
						);
				
				

				
				t2.setText("Name :-  "+f2.getName()+
						"\n\nLevel :-  "+f2.getLevel()+
						"\n\nCurrent HP :-  "+f2.getHealthPoints()+
						"\n\nMax HP :-  "+f2.getMaxHealthPoints()+
						"\n\nCurrent Stamina :-  "+f2.getStamina()+
						"\n\nMax Stamina :-  "+f2.getMaxStamina()+
						"\n\nCurrent Ki :-  "+f2.getKi()+
						"\n\nMax Ki :-  "+f2.getMaxKi()+
						"\n\nState :-  Not Blocking"
						);
			}
	}
	if(b.getAttacker()==b.getMe()){
		l1.setText("Your Turn");
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
	}
	else{
		l1.setText("Opponent's Turn");
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
	}
	l1.setFont(new Font("Serif", Font.BOLD,40));
	
	t1.setFont(new Font("Serif", Font.BOLD, 25));
	t2.setFont(new Font("Serif", Font.BOLD, 25));
	t1.setForeground(Color.BLUE);
	t2.setForeground(Color.RED);
}

	



	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==b2&&b2.isEnabled()){
			b.block();
			settexting();
			if(!(f1.getHealthPoints()==0||f2.getHealthPoints()==0)){
				computer();
				}
		}
		else if(e.getSource()==b3&&b3.isEnabled()){
			try {
				b.use(g.getPlayer(), Collectible.SENZU_BEAN);
				settexting();
				if(!(f1.getHealthPoints()==0||f2.getHealthPoints()==0)){
					computer();
					}
				
			} catch (NotEnoughSenzuBeansException e1) {
				JOptionPane.showMessageDialog(null, "You dont have enough Senzu Beans to Use","Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==b1&&b1.isEnabled()){
			ac.setVisible(true);
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
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		
		
		
	}

public void setbuttons(){
	b1.setEnabled(false);
	b2.setEnabled(false);
	b3.setEnabled(false);
}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	


	/*public void onBattleEvent(BattleEvent e) {
	 if(e.getType()==BattleEventType.ENDED){
		if(e.getWinner()==b.getMe()){
			winn w=new winn(g);
			dispose();
		}
		
		else{
			Gameover v=new Gameover(g);
			dispose();
		}
	}
	 else if(e.getType()==BattleEventType.ATTACK){
		 settexting();
			if(e.getAttack() instanceof SuperSaiyan){
				Saiyanwindow q=new Saiyanwindow();
			}
			Battle i=(Battle)e.getSource();
			 if(i.getAttacker()==i.getFoe()){
				 computer();
			 }
			 settexting();
			
		}
	 else{
		 settexting();
		 Battle i=(Battle)e.getSource();
		 if(i.getAttacker()==i.getFoe()){
			 computer();
		 }
		 settexting();
	 }
	
	}*/
	
	
	public void reset(){
		
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	luo.setText("                          \n\n");
		            }
		        }, 
		        3000
		);
		
		
	}
	
	public void onBattleEvent(BattleEvent e) {
		 if(e.getType()==BattleEventType.ENDED){
			if(e.getWinner()==b.getMe()){
				winn w=new winn(g,oldtarget,oldap,oldlvl,size1,size2);
				dispose();
			}
		 }
		  if(f1.getHealthPoints()==0){
				Gameover v=new Gameover(g);
				dispose();
			}
			
			else if(e.getType()==BattleEventType.ATTACK && b.getAttacker()==b.getFoe()){
				luo.setText("The Opponent attacked you with  "+e.getAttack().getName());
					reset();
			}
		  
			else if(e.getType()==BattleEventType.BLOCK && b.getAttacker()==b.getFoe()){
				luo.setText("The Opponent Blocked");
				
				reset();
			}
			else if(e.getType()==BattleEventType.USE && b.getAttacker()==b.getFoe()){
				luo.setText("The Opponent used Senzu Bean");
				
				reset();
			}
			else if(e.getType()==BattleEventType.ATTACK && b.getAttacker()==b.getMe() && e.getAttack() instanceof MaximumCharge){
				
			}
else if(e.getType()==BattleEventType.ATTACK && b.getAttacker()==b.getMe() && e.getAttack() instanceof SuperSaiyan){
				Saiyanwindow oi=new Saiyanwindow();
			}
			 settexting();
		 
			 
		 }
		 
		 
		 
		}
	
	

