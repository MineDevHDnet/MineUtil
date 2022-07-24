package net.minedevhd.mineutil.games;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.games.mario.MarioGui;
import net.minedevhd.mineutil.games.pong.PongGameFrame;
import net.minedevhd.mineutil.games.puzzle.Puzzle;
import net.minedevhd.mineutil.games.snake.vari.SnakeGameFrame;
import net.minedevhd.mineutil.games.tictactoe.TicTacToe;
import net.minedevhd.mineutil.games.tictactoe.TicTacToeGame;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.RenderUtils;

public class GameGui extends GuiScreen {
	
	GuiButton closeButton,
			  pongButton,
			  snakeButton,
			  marioButton,
			  tictactoeButton,
			  tetrisButton/*,
			  puzzleButton*/;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		RenderUtils.renderNewGuiBackground();
		RenderUtils.drawSizedString(this, "Game Library", -1, 5, true, MineUtil.CLIENT_COLOR);
//		this.drawCenteredString(this.fontRendererObj, "Game Library", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
//        this.drawCenteredString(this.fontRendererObj, "This Function is in development (betamode)", this.width / 2, 18, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(this.pongButton = new ModButton(110, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Pong"));
		this.buttonList.add(this.snakeButton = new ModButton(120, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Snake"));
		this.buttonList.add(this.marioButton = new ModButton(130, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Mario"));
		this.buttonList.add(this.tictactoeButton = new ModButton(140, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "TicTacToe"));
//		this.buttonList.add(this.puzzleButton = new ModButton(150, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Puzzle"));
		this.buttonList.add(this.closeButton = new ModButton(100, this.width / 2 - 50, ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth() - 10, ModButton.API.getButtonHeight(), "Close"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		try {
			switch (button.id) {
			case 100:
				this.mc.thePlayer.closeScreen();
				break;
			case 110:
				PongGameFrame frame = new PongGameFrame();
				break;
			case 120:
				SnakeGameFrame frame2 = new SnakeGameFrame();
				break;
			case 130:
				this.mc.displayGuiScreen(new MarioGui());
				break;
			case 140:
				TicTacToeGame tictactoe = new TicTacToeGame();
				break;
//			case 150:
//				Puzzle puzzle = new Puzzle();
//				break;
			default:
				break;
			}
		} catch (Exception exception) {}
		super.actionPerformed(button);
	}
	
	@Override
	public void confirmClicked(boolean result, int id) {
		super.confirmClicked(result, id);
	}
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return super.doesGuiPauseGame();
	}

}
