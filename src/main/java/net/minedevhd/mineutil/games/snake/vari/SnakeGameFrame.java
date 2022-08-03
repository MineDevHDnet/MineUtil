package net.minedevhd.mineutil.games.snake.vari;

import javax.swing.JFrame;

import net.minedevhd.mineutil.MineUtil;

public class SnakeGameFrame extends JFrame{

	SnakeGamePanel panel;
	
	public SnakeGameFrame(){
		panel = new SnakeGamePanel();
		
		this.add(panel);
		this.setTitle("Snake | Developed by MineDev_HD | MineUtil-b" + MineUtil.getCore().getVersion() + " (Game-Addon)");
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}