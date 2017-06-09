package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.cell.Cell;
import dragonball.model.cell.Collectible;
import dragonball.model.cell.FoeCell;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.MapIndexOutOfBoundsException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.model.world.World;

public class Map extends JFrame  implements GameListener,MouseListener, KeyListener {
JPanel jb;
JPanel k;
JPanel O;
JPanel q;


int tmp1;
int tmp2;

newBattle bg;

JButton b1=new JButton(new ImageIcon("up.png"));
JButton b2=new JButton(new ImageIcon("down.png"));
JButton b3=new JButton(new ImageIcon("right.png"));
JButton b4=new JButton(new ImageIcon("left.png"));

JTextArea n;

JButton b5=new JButton("Create a New Fighter");
JButton b6=new JButton("Switch Between Fighters");
JButton b7=new JButton("Upgrade Your Fighter");
JButton b8=new JButton("Assign a Super Attack");
JButton b9=new JButton("Assign an Ultimate Attack");
JButton b10=new JButton("Save Game");
JButton b11=new JButton("Exit");
JLabel l0;
JLabel l1;
JLabel l2;
JLabel l3;
JLabel l4;
JLabel l5;
JLabel l6;
Game g;
JButton[][] lo=new JButton[10][10];
ImageIcon foe;
ImageIcon player;
ImageIcon grass=new ImageIcon("grass2.png");


public Map(Game g) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
		
	this.g=g;
	this.g.setListener(this);
	setTitle("DragonBall Adventures");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	jb=new JPanel(new GridLayout(10,10));
	tmp1=9;
	tmp2=9;
for(int i=0;i<10;i++){
	for(int j=0;j<10;j++){
		lo[i][j]=new JButton(grass);
		lo[i][j].addKeyListener(this);
		jb.add(lo[i][j]);
	}
}
jb.addKeyListener(this);
setplayericon();
setfoeicon();

	add(jb,BorderLayout.CENTER);
	k= new JPanel();
	
	k.setLayout(new BorderLayout());
	n=new JTextArea();
	n.setEditable(false);
	settexting();
	k.add(n);
	k.addKeyListener(this);
	
	n.addKeyListener(this);
	O=new JPanel();
	O.addKeyListener(this);
	O.setLayout(new BorderLayout());
	O.add(b1,BorderLayout.NORTH);
	O.add(b2,BorderLayout.CENTER);
	O.add(b3,BorderLayout.EAST);
	O.add(b4,BorderLayout.WEST);
	q=new JPanel();
	q.setLayout(new BoxLayout(q, BoxLayout.Y_AXIS));
	q.addKeyListener(this);
	b5.setFont(new Font("Serif", Font.BOLD,20));
	b6.setFont(new Font("Serif", Font.BOLD,20));
	b7.setFont(new Font("Serif", Font.BOLD,20));
	b8.setFont(new Font("Serif", Font.BOLD,20));
	b9.setFont(new Font("Serif", Font.BOLD,20));
	b10.setFont(new Font("Serif", Font.BOLD,20));
	b11.setFont(new Font("Serif", Font.BOLD,20));
	
	q.add(b5);
	q.add(b6);
	q.add(b7);
	q.add(b8);
	q.add(b9);
	q.add(b10);
	q.add(b11);
	
	k.add(q,BorderLayout.EAST);
	
	k.add(O,BorderLayout.SOUTH);
	
	
	
	add(k,BorderLayout.EAST);
	b1.addMouseListener(this);
	b2.addMouseListener(this);
	b3.addMouseListener(this);
	b4.addMouseListener(this);
	b5.addMouseListener(this);
	b6.addMouseListener(this);
	b7.addMouseListener(this);
	b8.addMouseListener(this);
	b9.addMouseListener(this);
	b10.addMouseListener(this);
	b11.addMouseListener(this);
	
	
	
	
	
	b1.addKeyListener(this);
	b2.addKeyListener(this);
	b3.addKeyListener(this);
	b4.addKeyListener(this);
	
	b5.addKeyListener(this);
	b6.addKeyListener(this);
	b7.addKeyListener(this);
	b8.addKeyListener(this);
	b9.addKeyListener(this);
	b10.addKeyListener(this);
	b11.addKeyListener(this);

	
	setVisible(true);
	validate();
	repaint();
}
@Override
public void onDragonCalled(Dragon dragon) {
	Dragonmode q=new Dragonmode(g,dragon);
	dispose();
}
@Override
public void onCollectibleFound(Collectible collectible) {
	if(collectible==Collectible.SENZU_BEAN){
		JOptionPane.showMessageDialog(null, "Congratulations You have earned A Senzu Bean");
		
	}
	else{
		JOptionPane.showMessageDialog(null, "Congratulations You have earned A DragonBall");
	}
}
@Override
public void onBattleEvent(BattleEvent e) {
	if(e.getType()==BattleEventType.STARTED){
		bg=new newBattle(g, e);	
		dispose();
	}
	
	else {
		bg.onEvent(e);
	}
}

public void setplayericon(){
	int row=g.getWorld().getPlayerRow();
	int column=g.getWorld().getPlayerColumn();
	Fighter f=g.getPlayer().getActiveFighter();
	if(f instanceof Saiyan){
		player =new ImageIcon("saiyan1.png");
	}
	else if(f instanceof Earthling){
		player =new ImageIcon("earthling1.png");
	}
	else if(f instanceof Namekian){
		player =new ImageIcon("namekin1.png");
	}
	else if(f instanceof Majin){
		player =new ImageIcon("majin1.png");
	}
	else if(f instanceof Frieza){
		player =new ImageIcon("frieza1.png");
	}
	lo[row][column].setIcon(player);
	if(!(tmp1==row&&tmp2==column)){
		lo[tmp1][tmp2].setIcon(grass);
		tmp1=row;
		tmp2=column;
	}
	repaint();
	validate();
}
public void setfoeicon(){
	FoeCell c=(FoeCell) g.getWorld().getMap()[0][0];
	Fighter f=c.getFoe();
	String name=f.getName();
	if(name.equalsIgnoreCase("Goku")){
		foe=new ImageIcon("goku1.png");
	}
	else if(name.equalsIgnoreCase("Vegeta")){
		foe=new ImageIcon("vegeta1.png");
	}
else if(name.equalsIgnoreCase("Jinkoumen")){
	foe=new ImageIcon("jinkoman1.png");
	}
else if(name.equalsIgnoreCase("Gohan (Kid)")){
	foe=new ImageIcon("gohan1.png");
}
else if(name.equalsIgnoreCase("Krillin")){
	foe=new ImageIcon("earthling1.png");
}	
else if(name.equalsIgnoreCase("Yamcha")){
	foe=new ImageIcon("yamcha1.png");
}
else if(name.equalsIgnoreCase("Tien")){
	foe=new ImageIcon("tien1.png");
}
else if(name.equalsIgnoreCase("Piccolo")){
	foe=new ImageIcon("namekin1.png");
}
else if(name.equalsIgnoreCase("Raditz")){
	foe=new ImageIcon("raditz1.png");
}
else if(name.equalsIgnoreCase("Nappa")){
	foe=new ImageIcon("nappa1.png");
}
else if(name.equalsIgnoreCase("Saibaman")){
	foe=new ImageIcon("saibaman1.png");
}
else if(name.equalsIgnoreCase("Tennenmen")){
	foe=new ImageIcon("tenaman1.png");
}
else if(name.equalsIgnoreCase("Orlen")){
	foe=new ImageIcon("orlen1.png");
}
else if(name.equalsIgnoreCase("Raspberry")){
	foe=new ImageIcon("rasberry1.png");
}
else if(name.equalsIgnoreCase("Navel")){
	foe=new ImageIcon("navel1.png");
}
else if(name.equalsIgnoreCase("Monre")){
	foe=new ImageIcon("monre1.png");
}
else if(name.equalsIgnoreCase("Ramon")){
	foe=new ImageIcon("ramon1.png");
}
else{
	foe=new ImageIcon("vegeta1.png");
}
	lo[0][0].setIcon(foe);
	repaint();
	validate();
}
public void settexting(){
	n.setText("Player Name :- "+g.getPlayer().getName()+
			"\n\nFighter Name :- "+g.getPlayer().getActiveFighter().getName()+
			"\n\nFighter Level :- "+g.getPlayer().getActiveFighter().getLevel()+
			"\n\nYour Dragonballs :- "+g.getPlayer().getDragonBalls()+
			"\n\nYour AbilityPoints :- "+g.getPlayer().getActiveFighter().getAbilityPoints()+
			"\n\nYour SenzuBeans :- "+g.getPlayer().getSenzuBeans()+
			"\n\nPhysical Damage :- "+g.getPlayer().getActiveFighter().getPhysicalDamage()+
			"\n\nBlast Damage :- "+g.getPlayer().getActiveFighter().getBlastDamage()+
			"\n\nMaximum HP :- "+g.getPlayer().getActiveFighter().getMaxHealthPoints()+
			"\n\nMaximum Stamina :- "+g.getPlayer().getActiveFighter().getMaxStamina()+
			"\n\nMaximum KI :- "+g.getPlayer().getActiveFighter().getMaxKi()+
			"\n\nXP :- "+g.getPlayer().getActiveFighter().getXp()+
			"\n\nTarget Xp :- "+g.getPlayer().getActiveFighter().getTargetXp()+
			"\n\n Explored Maps :- "+g.getPlayer().getExploredMaps()
			);
	
n.setFont(new Font("Serif", Font.BOLD,20));
n.setForeground(Color.RED);
}
@Override
public void mouseClicked(MouseEvent e) {
	if(e.getSource()==b1){
		
		g.getWorld().moveUp();
		settexting();
		setplayericon();
	
	}
	else if(e.getSource()==b2){
		
		g.getWorld().moveDown();
		settexting();
		setplayericon();
		

	}
else if(e.getSource()==b3){
	
		g.getWorld().moveRight();
		settexting();
		setplayericon();
	
		
	}
else if(e.getSource()==b4){

	g.getWorld().moveLeft();
	settexting();
	setplayericon();
	
}
else if(e.getSource()==b5){
	try {
		Createfighter y=new Createfighter(g);
		dispose();
	} catch (IOException | UnsupportedAudioFileException
			| LineUnavailableException | InterruptedException e1) {
		
	}
}
else if(e.getSource()==b6){
	switchfighters f=new switchfighters(g);
	dispose();
}
else if(e.getSource()==b7){
	upgradefighter u=new upgradefighter(g);
	dispose();
}
else if(e.getSource()==b8){
	assignsuperattack u=new assignsuperattack(g);
	dispose();
}
else if(e.getSource()==b9){
	assignultimateattack u=new assignultimateattack(g);
	dispose();
}
else if(e.getSource()==b10){
	int selectedOption = JOptionPane.showConfirmDialog(null, 
            "Are you Sure you want to save the Game?", 
            "Choose", 
            JOptionPane.YES_NO_OPTION);
	if (selectedOption == JOptionPane.YES_OPTION) {
		try {
			g.save("save");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
}
else if(e.getSource()==b11){
	int selectedOption = JOptionPane.showConfirmDialog(null, 
            "Are you Sure you want to close the Game?", 
            "Choose", 
            JOptionPane.YES_NO_OPTION); 
if (selectedOption == JOptionPane.YES_OPTION) {
System.exit(0);
}
}
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
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_UP){
		g.getWorld().moveUp();
		settexting();
		setplayericon();
	}
	else if(e.getKeyCode()==KeyEvent.VK_DOWN){
		g.getWorld().moveDown();
		settexting();
		setplayericon();
	}
	else if(e.getKeyCode()==KeyEvent.VK_LEFT){
		g.getWorld().moveLeft();
		settexting();
		setplayericon();
	}
	else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
		g.getWorld().moveRight();
		settexting();
		setplayericon();
	}
}
@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

}
