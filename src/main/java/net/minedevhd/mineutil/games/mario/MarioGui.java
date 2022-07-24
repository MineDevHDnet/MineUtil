package net.minedevhd.mineutil.games.mario;

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

public class MarioGui extends GuiScreen {
	
	DrawUtils draw;
    int lengthX,
    	posX,
    	posY,
    	lengthY,
    	speed,
    	score;
    GuiButton quit,
    		  restart;
    Thread thread;
    boolean gameOver;
    ArrayList<Location> terrain;
    double fallDistance;
    int jumpVelocity;
    Location playerLocation;
    int tick;
    
    public MarioGui() {
        this.lengthX = 0;
        this.posX = 1;
        this.posY = 4;
        this.lengthY = 0;
        this.speed = 60;
        this.score = 0;
        this.gameOver = false;
        this.terrain = new ArrayList<Location>();
        this.fallDistance = 0.0;
        this.jumpVelocity = 0;
        this.tick = 0;
        this.draw = LabyMod.getInstance().getDrawUtils();
        this.thread = null;
    }
    
    public boolean collideWithPixelType(final Location loc, final EnumPixelType pixel) {
        for (final Location terrain : this.getTerrain()) {
            if (terrain.collideWith(loc) && terrain.type == pixel) {
                return true;
            }
        }
        return false;
    }
    
    public boolean collideWithBlock(final Location loc) {
        for (final Location terrain : this.getTerrain()) {
            if (terrain.collideWith(loc) && (terrain.type == EnumPixelType.BLOCK || terrain.type == EnumPixelType.TUBE || terrain.type == EnumPixelType.BONUS || terrain.type == EnumPixelType.CLOUDBLOCK)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.quit = new GuiButton(0, 5, 5, 30, 20, "§cQuit");
        this.buttonList.add(this.quit);
        this.lengthX = this.width / 10 - 2;
        this.lengthY = this.height / 10 - 4;
        if (this.gameOver) {
            this.restart = new GuiButton(1, this.width / 2 - 100, this.height - 25, 200, 20, "Play again");
            this.buttonList.add(this.restart);
            super.initGui();
            return;
        }
        if (this.thread == null) {
            this.create();
        }
        super.initGui();
    }
    
    private void create() {
        this.gameOver = false;
        this.buildTerrain();
        this.spawnPlayer();
        this.start();
    }
    
    private void spawnPlayer() {
        this.playerLocation = new Location(5, 2, EnumPixelType.MARIO);
    }
    
    public void moveTerrain(final int x) {
        for (final Location loc : this.getTerrain()) {
            loc.add(x, 0);
        }
        this.getPlayerLocation().add(x, 0);
    }
    
    private void buildTerrain() {
        for (int m = 0; m <= 50; ++m) {
            this.terrain.add(new Location(-1, m, EnumPixelType.BLOCK));
        }
        int x = 0;
        int y = 14;
        for (int i = 0; i <= 400; ++i) {
            if (i == 0) {
                for (int tt = 0; tt <= 20; ++tt) {
                    for (int j = 0; j <= 50; ++j) {
                        this.terrain.add(new Location(0 + x, y + j, EnumPixelType.BLOCK));
                    }
                    ++x;
                }
            }
            for (int k = 0; k <= 50; ++k) {
                this.terrain.add(new Location(0 + x, y + k, EnumPixelType.BLOCK));
            }
            if (new Random().nextInt(20) == 0) {
                this.terrain.add(new Location(0 + x, y - 1, EnumPixelType.BUSH));
            }
            ++x;
            if (new Random().nextInt(10) == 0) {
                for (int t = 0; t <= 3; ++t) {
                    if (new Random().nextBoolean()) {
                        ++x;
                        if (new Random().nextBoolean()) {
                            if (y < 30) {
                                ++y;
                            }
                        }
                        else if (y > 0) {
                            --y;
                        }
                    }
                }
            }
            if (new Random().nextInt(5) == 0) {
                int mt = 0;
                this.terrain.add(new Location(0 + x, y - mt - 1, EnumPixelType.TUBE));
                ++mt;
                for (int t2 = 0; t2 <= 1; ++t2) {
                    if (new Random().nextBoolean()) {
                        this.terrain.add(new Location(0 + x, y - mt - 1, EnumPixelType.TUBE));
                        ++mt;
                    }
                }
            }
            if (new Random().nextInt(3) == 0) {
                int mt = 0;
                if (y - 5 > 0) {
                    final int yy = new Random().nextInt(y - 5);
                    for (int t3 = 0; t3 <= 4; ++t3) {
                        if (new Random().nextBoolean()) {
                            this.terrain.add(new Location(0 + x + mt, yy, EnumPixelType.CLOUD));
                            ++mt;
                        }
                    }
                }
            }
        }
    }
    
    public Location getPlayerLocation() {
        return this.playerLocation;
    }
    
    public Location getPlayerHeadLocation() {
        if (this.getPlayerLocation() != null) {
            final Location loc = this.getPlayerLocation().clone().add(0, -1);
            return loc;
        }
        return null;
    }
    
    public boolean isPlayer() {
        return this.getPlayerLocation() != null;
    }
    
    public ArrayList<Location> getTerrain() {
        return this.terrain;
    }
    
    public boolean isOnGround() {
        return this.fallDistance == 0.0;
    }
    
    public int getFallDistance() {
        return (int)this.fallDistance;
    }
    
    private void start() {
        (this.thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!MarioGui.this.gameOver /*&& MarioGui.this.j.m == MarioGui.this*/) {
                    MarioGui.this.tick();
                    try {
                        synchronized (MarioGui.this.thread) {
                            MarioGui.this.thread.wait(MarioGui.this.speed);
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
//            if (StatsLoader.stats.containsKey("mario")) {
//                list = StatsLoader.stats.get("mario");
//            }
//            if (StatsLoader.isHighScore(this.score, list)) {
//                list.add(0, "" + this.score);
//            }
            if (list.size() > 15) {
                list.remove(15);
            }
//            StatsLoader.stats.put("mario", list);
//            StatsLoader.savestats();
        }
        this.gameOver = true;
        this.gameOver();
    }
    
    private void tick() {
        ++this.fallDistance;
        if (this.collideWithBlock(this.playerLocation.clone().add(0, 1))) {
            this.fallDistance = 0.0;
        }
        if (this.isPlayer()) {
            if (!this.isOnGround() && new Random().nextInt(this.getFallDistance()) != 0 && this.jumpVelocity == 0 && !this.collideWithBlock(this.playerLocation.clone().add(0, 1))) {
                this.playerLocation.add(0, 1);
            }
            if (this.jumpVelocity > 0 && !this.collideWithBlock(this.playerLocation.clone().add(0, -1))) {
                this.playerLocation.add(0, -1);
                --this.jumpVelocity;
            }
            if (this.collideWithPixelType(this.getPlayerLocation(), EnumPixelType.LAVA)) {
                this.gameOver();
            }
            if (this.getPlayerLocation().getX() > 30) {
                this.moveTerrain(-1);
            }
            if (this.getPlayerLocation().getY() > 30) {
                this.gameOver();
            }
        }
        this.handleKeyBoardInput();
        ++this.tick;
    }
    
    @Override
    public void actionPerformed(final GuiButton button) throws IOException {
        if (button.id == 0) {
            this.mc.displayGuiScreen(new GameGui());
        }
        if (button.id == 1) {
            this.mc.displayGuiScreen(new MarioGui());
        }
        super.actionPerformed(button);
    }
    
    @Override
    protected void keyTyped(final char typedChar, final int keyCode) throws IOException {
        if (keyCode == 1) {
            this.mc.displayGuiScreen(new GameGui());
            return;
        }
        super.keyTyped(typedChar, keyCode);
    }
    
    protected void handleKeyBoardInput() {
        if (!this.gameOver) {
            if ((Keyboard.isKeyDown(205) || Keyboard.isKeyDown(32)) && !this.collideWithBlock(this.getPlayerLocation().clone().add(1, 0)) && !this.collideWithBlock(this.getPlayerHeadLocation().clone().add(1, 0))) {
                this.getPlayerLocation().add(1, 0);
                ++this.score;
            }
            if ((Keyboard.isKeyDown(203) || Keyboard.isKeyDown(30)) && !this.collideWithBlock(this.getPlayerLocation().clone().add(-1, 0)) && !this.collideWithBlock(this.getPlayerHeadLocation().clone().add(-1, 0))) {
                this.getPlayerLocation().add(-1, 0);
                --this.score;
            }
            if (Keyboard.isKeyDown(57) && this.isOnGround()) {
                this.jumpVelocity = 3;
            }
        }
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        if (LabyMod.getInstance().isInGame()) {
//            bfl.l();
            this.draw.drawOverlayBackground(0, 32, this.width, this.height - 33);
        }
        else {
//            this.c();
            this.draw.drawOverlayBackground(0, 32, this.width, this.height - 33);
        }
        final DrawUtils draw = this.draw;
        DrawUtils.drawRect(0, 0, this.width, this.height, new java.awt.Color(107, 140, 255).getRGB());
        for (final Location terrain : this.getTerrain()) {
            if (terrain.type == EnumPixelType.CLOUD) {
                this.drawPixel(terrain.getX(), terrain.getY(), java.awt.Color.WHITE.getRGB());
            }
        }
        Location loc = this.getPlayerLocation();
        if (loc != null) {
            this.drawPixel(loc.getX(), loc.getY(), java.awt.Color.BLUE.getRGB());
            loc = this.getPlayerHeadLocation();
            this.drawPixel(loc.getX(), loc.getY(), java.awt.Color.BLUE.getRGB());
        }
        for (final Location terrain2 : this.getTerrain()) {
            if (terrain2.type == EnumPixelType.LAVA) {
                this.drawPixel(terrain2.getX(), terrain2.getY(), java.awt.Color.ORANGE.getRGB());
            }
            if (terrain2.type == EnumPixelType.BLOCK) {
                this.drawPixel(terrain2.getX(), terrain2.getY(), new java.awt.Color(231, 99, 24).getRGB());
            }
            if (terrain2.type == EnumPixelType.TUBE) {
                this.drawPixel(terrain2.getX(), terrain2.getY(), new java.awt.Color(0, 173, 0).getRGB());
            }
            if (terrain2.type == EnumPixelType.BUSH) {
                this.drawPixel(terrain2.getX(), terrain2.getY(), new java.awt.Color(189, 247, 24).getRGB());
            }
            if (terrain2.type == EnumPixelType.CLOUDBLOCK) {
                this.drawPixel(terrain2.getX(), terrain2.getY(), new java.awt.Color(239, 239, 239).getRGB());
            }
            if (terrain2.type == EnumPixelType.BONUS) {
                this.drawPixel(terrain2.getX(), terrain2.getY(), new java.awt.Color(255, 165, 66).getRGB());
            }
        }
        final ArrayList<Location> toRem = new ArrayList<Location>();
        for (final Location lm : this.getTerrain()) {
            if (loc.getX() < 0) {
                toRem.add(loc);
            }
        }
        for (final Location ll : toRem) {
            this.getTerrain().remove(ll);
        }
        if (this.gameOver) {
            GL11.glPushMatrix();
            final int k = 3;
            GL11.glScaled((double)k, (double)k, (double)k);
            this.draw.drawCenteredString("§cGame Over", this.width / 2 / k, (this.height / 4 - 5) / k);
            GL11.glPopMatrix();
//            if (StatsLoader.stats.containsKey("mario")) {
//                final ArrayList<String> list = StatsLoader.stats.get("mario");
//                int i = 1;
//                for (final String sc : list) {
//                    this.draw.drawString(i + ". Place - " + Color.cl("b") + sc + "m", this.l / 2 - 43, this.m / 4 - 5 + i * 10 + 20);
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
        int s = this.score;
        if (s < 0) {
            s = 0;
        }
        this.draw.drawString("Score: " + s + "m", 5.0, this.height - 24);
        super.drawScreen(mouseX, mouseY, partialTicks);
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
        MARIO, 
        LAVA, 
        BLOCK, 
        CLOUD, 
        BUSH, 
        TUBE, 
        BONUS, 
        CLOUDBLOCK;
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
        
        public Location add(final int x, final int y) {
            this.x += x;
            this.y += y;
            return this;
        }
        
        public Location clone() {
            return new Location(this.x, this.y, this.type);
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
        
        public boolean collideWith(final Location loc) {
            return this.getX() == loc.getX() && this.getY() == loc.getY();
        }
    }

}
