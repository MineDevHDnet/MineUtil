package net.minedevhd.mineutil.games.tictactoe;

import javax.swing.JFrame;

import net.minedevhd.mineutil.MineUtil;

public class TicTacToeGame extends JFrame{
	
	TicTacToe ttt;
	
	public TicTacToeGame() {
		ttt = new TicTacToe();
		this.add(ttt);
	}

}
