package net.minedevhd.mineutil.games.pong;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import net.minedevhd.mineutil.MineUtil;

public class PongGameFrame extends JFrame {

	final PongGamePanel panel;
	
	public PongGameFrame(){
		panel = new PongGamePanel();
		
//		final ImageIcon icon = new ImageIcon("labymod/addons/MineUtil/textures/utillogo.jpg");
//	    this.setIconImage(icon.getImage());
	    
		this.add(panel);
		this.setTitle("Pong | Developed by MineDev_HD | MineUtil-b" + MineUtil.getCore().getVersion() + " (Game-Addon)");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
}