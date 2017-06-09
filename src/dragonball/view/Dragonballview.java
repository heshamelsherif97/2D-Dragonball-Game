package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
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

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import com.sun.istack.internal.localization.NullLocalizable;

import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class Dragonballview extends JFrame implements ActionListener {
	 JButton j1;
	 JButton j2;
	 JLabel background;
	 JFrame f1;
	 Game g;
	 
	 
	 
	public Dragonballview() throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException{
	page1();
}

	public void page1() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException{
		    f1=new JFrame();
		    g=new Game();
		    f1.setTitle("DragonBall Adventures");
			f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f1.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		    j1=new JButton();
			j2=new JButton();
			j1.setBounds(550, 485, 300, 150);
			j2.setBounds(550,775, 300, 150);
			j1.addActionListener(this);
			j2.addActionListener(this);
			background = new JLabel(new ImageIcon("back.png"));
			j1.setOpaque(false);
			j1.setContentAreaFilled(false);
			j1.setBorderPainted(false);
			j2.setOpaque(false);
			j2.setContentAreaFilled(false);
			j2.setBorderPainted(false);
		    f1.add(j1);
			f1.add(j2);
			f1.add(background);
			
			
		   f1.setVisible(true);
		 /* AudioInputStream inputStream2 = AudioSystem.getAudioInputStream(new File("warriors.wav"));
		    Clip clip = AudioSystem.getClip();
		    clip.open(inputStream2);
		    clip.loop(0);
		    */
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==j1){
			f1.dispose();
			
			try {
				NewGameWindow w=new NewGameWindow(g);
			} catch (IOException | UnsupportedAudioFileException
					| LineUnavailableException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==j2){
			if(!(g.getLastSavedFile().equals(""))){
			try {
			
				g.load("save");
			} catch (ClassNotFoundException | IOException e1) {
				JOptionPane.showMessageDialog(null, "You dont have any saved game","Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
			try {
				Map i=new Map(g);
				f1.dispose();
			} catch (IOException | UnsupportedAudioFileException
					| LineUnavailableException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			
		}
		
	}

	

	


	

	
}