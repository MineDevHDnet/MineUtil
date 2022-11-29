package net.minedevhd.mineutil.games.snake;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.labymod.main.LabyMod;
import net.labymod.utils.DrawUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minedevhd.mineutil.games.GameGui;

public class SnakeGui extends GuiScreen {
	
	DrawUtils draw;
    int lengthX;
    int posX;
    int posY;
    int lengthY;
    int speed;
    int powerUpAmount;
    boolean cooldown;
    GuiButton quit,
    		  restart;
    int score;
    Thread thread;
    boolean gameOver;
    EnumDirection snakeDirection;
    ArrayList<Location> points;
    ArrayList<Location> snake;
    
    public SnakeGui() {
        this.lengthX = 0;
        this.posX = 1;
        this.posY = 4;
        this.lengthY = 0;
        this.speed = 120;
        this.powerUpAmount = 40;
        this.cooldown = false;
        this.score = 0;
        this.gameOver = false;
        this.snakeDirection = EnumDirection.DOWN;
        this.points = new ArrayList<Location>();
        this.snake = new ArrayList<Location>();
        this.draw = LabyMod.getInstance().getDrawUtils();
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.quit = new GuiButton(0, 5, 5, 30, 20, "§cQuit");
        this.buttonList.add(this.quit);
        this.lengthX = this.width / 10 - 2;
        this.lengthY = this.height / 10 - 4;
        this.restart = new GuiButton(1, this.width / 2 - 100, this.height - 25, 200, 20, "Play again");
        if (this.gameOver) {
            this.buttonList.add(this.restart);
            super.initGui();
            return;
        }
        if (this.thread == null) {
            this.create();
        }
        else {
            this.points.clear();
            this.addPoint();
            if (this.getHead().x > this.lengthX || this.getHead().y > this.lengthY) {
                this.expand(this.lengthX / 2, this.lengthY / 2);
            }
        }
        super.initGui();
    }
    
    private void create() {
        this.score = 0;
        this.snakeDirection = EnumDirection.DOWN;
        this.gameOver = false;
        this.snake.clear();
        for (int i = 0; i < 3; ++i) {
            this.expand(this.lengthX / 2, this.lengthY / 2 + i);
        }
        this.addPoint();
        this.start();
    }
    
    private void start() {
        (this.thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!SnakeGui.this.gameOver /*&& SnakeGui.this.j.m == SnakeGui.this*/) {
                    SnakeGui.this.tick();
                    try {
                        synchronized (SnakeGui.this.thread) {
                            SnakeGui.this.thread.wait(SnakeGui.this.speed);
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        })).start();
    }
    
    private void gameOver() {
        if (!this.gameOver) {
            ArrayList<String> list = new ArrayList<String>();
//            if (StatsLoader.stats.containsKey("snake")) {
//                list = StatsLoader.stats.get("snake");
//            }
//            if (StatsLoader.isHighScore(this.score, list)) {
//                list.add(0, "" + this.score);
//            }
            if (list.size() > 15) {
                list.remove(15);
            }
//            StatsLoader.stats.put("snake", list);
//            StatsLoader.savestats();
        }
        this.gameOver = true;
        this.gameOver();
    }
    
    private void tick() {
        boolean devalue = true;
        if (this.snakeDirection == EnumDirection.UP) {
            final Location head = this.getHead();
            if (head.y < this.posY) {
                head.y = this.lengthY;
            }
            devalue = this.expand(head.x, head.y - 1);
        }
        if (this.snakeDirection == EnumDirection.DOWN) {
            final Location head = this.getHead();
            if (head.y > this.lengthY) {
                head.y = this.posY;
            }
            devalue = this.expand(head.x, head.y + 1);
        }
        if (this.snakeDirection == EnumDirection.RIGHT) {
            final Location head = this.getHead();
            if (head.x > this.lengthX) {
                head.x = this.posX;
            }
            devalue = this.expand(head.x + 1, head.y);
        }
        if (this.snakeDirection == EnumDirection.LEFT) {
            final Location head = this.getHead();
            if (head.x < this.posX) {
                head.x = this.lengthX;
            }
            devalue = this.expand(head.x - 1, head.y);
        }
        if (devalue) {
            this.devalue();
        }
        this.cooldown = false;
    }
    
    private Location getHead() {
        final ArrayList<Location> s = this.getSnake();
        if (s.size() == 0) {
            return new Location(0, 0, EnumPixelType.PIXEL);
        }
        return s.get(s.size() - 1);
    }
    
    private void devalue() {
        if (this.snake != null) {
            this.snake.remove(0);
        }
    }
    
    private void setSpeed(int speed) {
        if (speed > 300) {
            speed = 300;
        }
        if (speed < 10) {
            speed = 10;
        }
        this.speed = speed;
    }
    
    private boolean expand(final int x, final int y) {
        final Location l = new Location(x, y, EnumPixelType.SNEAK);
        for (final Location a : this.getSnake()) {
            if (a == null) {
                continue;
            }
            if (a.x == x && a.y == y) {
                this.gameOver();
                return false;
            }
        }
        for (final Location a : this.points) {
            if (a == null) {
                continue;
            }
            if (a.x == x && a.y == y) {
                this.addScore();
                this.addPoint();
                if (a.type == EnumPixelType.MOREFRUITS) {
                    this.addScore();
                    this.addPoint();
                }
                if (a.type == EnumPixelType.INCREASESPEED) {
                    this.addScore();
                    this.setSpeed(this.speed - new Random().nextInt(50));
                }
                if (a.type == EnumPixelType.DECREASESPEED) {
                    this.addScore();
                    this.setSpeed(this.speed + new Random().nextInt(50));
                }
                this.snake.add(l);
                this.points.remove(a);
                return false;
            }
        }
        this.snake.add(l);
        return true;
    }
    
    private void addScore() {
        this.score += 10;
    }
    
    public void addPoint() {
        EnumPixelType type = EnumPixelType.FRUIT;
        final int i = new Random().nextInt(this.powerUpAmount);
        if (i == 0) {
            type = EnumPixelType.INCREASESPEED;
        }
        if (i == 1) {
            type = EnumPixelType.DECREASESPEED;
        }
        if (i == 2) {
            type = EnumPixelType.MOREFRUITS;
        }
        final Location l = new Location(new Random().nextInt(this.lengthX - this.posX) + this.posX, new Random().nextInt(this.lengthY - this.posY) + this.posY, type);
        for (final Location a : this.points) {
            if (a == null) {
                continue;
            }
            if (a.x == l.x && a.y == l.y) {
                this.addPoint();
                return;
            }
        }
        this.points.add(l);
    }
    
    @Override
    public void actionPerformed(final GuiButton button) throws IOException {
        if (button.id == 0) {
            this.mc.displayGuiScreen(new GameGui());
        }
        if (button.id == 1) {
        	this.mc.displayGuiScreen(new SnakeGui());
        }
        super.actionPerformed(button);
    }
    
    @Override
    protected void keyTyped(final char typedChar, final int keyCode) throws IOException {
        if (keyCode == 1) {
//        	this.mc.displayGuiScreen(new GuiGames());
            return;
        }
        if (!this.gameOver && !this.cooldown) {
            boolean boost = true;
            if ((keyCode == 200 || keyCode == 17) && this.snakeDirection != EnumDirection.DOWN && this.snakeDirection != EnumDirection.UP) {
                this.snakeDirection = EnumDirection.UP;
                this.cooldown = true;
                boost = false;
            }
            if ((keyCode == 208 || keyCode == 31) && this.snakeDirection != EnumDirection.UP && this.snakeDirection != EnumDirection.DOWN) {
                this.snakeDirection = EnumDirection.DOWN;
                this.cooldown = true;
                boost = false;
            }
            if ((keyCode == 205 || keyCode == 32) && this.snakeDirection != EnumDirection.LEFT && this.snakeDirection != EnumDirection.RIGHT) {
                this.snakeDirection = EnumDirection.RIGHT;
                this.cooldown = true;
                boost = false;
            }
            if ((keyCode == 203 || keyCode == 30) && this.snakeDirection != EnumDirection.RIGHT && this.snakeDirection != EnumDirection.LEFT) {
                this.snakeDirection = EnumDirection.LEFT;
                this.cooldown = true;
                boost = false;
            }
            if (boost && new Random().nextInt(3) == 0) {
                this.tick();
            }
        }
        super.keyTyped(typedChar, keyCode);
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        if (LabyMod.getInstance().isInGame()) {
//            bfl.l();
            this.draw.drawOverlayBackground(0, 32, this.width, this.height - 33);
        }
        else {
//            this.c();
            this.draw.drawDimmedOverlayBackground(0, 32, this.width, this.height - 33);
        }
        for (final Location loc : this.getSnake()) {
            if (loc == null) {
                continue;
            }
            this.drawPixel(loc.x, loc.y, java.awt.Color.WHITE.getRGB());
        }
        for (final Location loc : this.getPoints()) {
            if (loc == null) {
                continue;
            }
            if (loc.type == EnumPixelType.FRUIT) {
                this.drawPixel(loc.x, loc.y, java.awt.Color.RED.getRGB());
            }
            if (loc.type == EnumPixelType.MOREFRUITS) {
                this.drawPixel(loc.x, loc.y, java.awt.Color.ORANGE.getRGB());
            }
            if (loc.type == EnumPixelType.INCREASESPEED) {
                this.drawPixel(loc.x, loc.y, java.awt.Color.CYAN.getRGB());
            }
            if (loc.type != EnumPixelType.DECREASESPEED) {
                continue;
            }
            this.drawPixel(loc.x, loc.y, java.awt.Color.BLUE.getRGB());
        }
        if (this.gameOver) {
            GL11.glPushMatrix();
            final int k = 3;
            GL11.glScaled((double)k, (double)k, (double)k);
            this.draw.drawCenteredString("§cGame Over", this.width / 2 / k, (this.height / 4 - 5) / k);
            GL11.glPopMatrix();
//            if (StatsLoader.stats.containsKey("snake")) {
//                final ArrayList<String> list = StatsLoader.stats.get("snake");
//                int i = 1;
//                for (final String sc : list) {
//                    this.draw.drawString(i + ". Place - §b" + sc + " Points", this.width / 2 - 50, this.height / 4 - 5 + i * 10 + 20);
//                    if (++i > 10) {
//                        break;
//                    }
//                }
//            }
//            else {
                this.draw.drawCenteredString("§fNo stats found", this.width / 2, this.height / 4 - 5 + 30);
//            }
        }
//        bfl.k();
        this.draw.drawOverlayBackground(0, 32);
        this.draw.drawOverlayBackground(this.height - 33, this.height);
        this.draw.drawString("Score: " + this.score, 5.0, this.height - 24);
        this.draw.drawString("Speed: " + this.speed / 1000.0 + " pixel/s", 5.0, this.height - 13);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    private ArrayList<Location> getSnake() {
        final ArrayList<Location> s = new ArrayList<Location>();
        s.addAll(this.snake);
        return s;
    }
    
    private ArrayList<Location> getPoints() {
        final ArrayList<Location> s = new ArrayList<Location>();
        s.addAll(this.points);
        return s;
    }
    
    public void drawPixel(final int x, final int y, final int color) {
        final DrawUtils draw = this.draw;
        DrawUtils.drawRect(x * 10, y * 10, (x + 1) * 10, (y + 1) * 10, color);
    }
    
    enum EnumDirection
    {
        UP, 
        RIGHT, 
        DOWN, 
        LEFT;
    }
    
    enum EnumPixelType
    {
        PIXEL, 
        SNEAK, 
        FRUIT, 
        INCREASESPEED, 
        DECREASESPEED, 
        MOREFRUITS;
    }
    
    class Location
    {
        int x;
        int y;
        EnumPixelType type;
        
        public Location(final int x, final int y, final EnumPixelType type) {
            this.x = 0;
            this.y = 0;
            this.type = EnumPixelType.PIXEL;
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

}
