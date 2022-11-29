package net.minedevhd.mineutil.games.pong;

import java.awt.*;
import java.util.*;

public class PongBall extends Rectangle {

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;
	
	PongBall(int x, int y, int width, int height) {
		super(x, y, width, height);
		random = new Random();
		
		int randomXDirection = random.nextInt(2);
		
		if(randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection*initialSpeed);
		
		int randomYDirection = random.nextInt(2);
		
		if(randomYDirection == 0)
			randomYDirection--;

		setYDirection(randomYDirection*initialSpeed);
	}
	
	public void setXDirection(int randomXDirection) {
		this.xVelocity = randomXDirection;
	}
	
	public void setYDirection(int randomYDirection) {
		this.yVelocity = randomYDirection;
	}
	
	public void move() {
		x += this.xVelocity;
		y += this.yVelocity;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}
}