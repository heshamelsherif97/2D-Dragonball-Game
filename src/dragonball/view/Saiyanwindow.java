package dragonball.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Saiyanwindow extends JFrame implements MouseListener {

	JLabel back=new JLabel(new ImageIcon("saiyyyan.jpg"));
	JButton j1=new JButton(new ImageIcon("continue.png"));
	
	
	public Saiyanwindow(){
		setTitle("DragonBall Adventures");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		j1.setBounds(850,850,250,100);
		j1.addMouseListener(this);
		add(j1);
		
		add(back);
		setVisible(true);
		
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==j1){
			dispose();
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
	public static void main(String[]args){
		new Saiyanwindow();
	}
	
}
