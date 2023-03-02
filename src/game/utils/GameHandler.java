package game.utils;

import gfx.assets.Display;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

import game.states.*;

public class GameHandler {

    private BufferStrategy bufferStrategy;
    private Graphics g;

    private Display display;

    public static final int SCREEN_WIDTH = 1200;
    public static final int SCREEN_HEIGHT = 800;
    private final String GAME_TITLE = "School Appropriate Game Title";

    State currentState = new GameState();
    public static void main(String[] args) {
        GameHandler game = new GameHandler();
        game.init();
    }

    private void init() {
        display = new Display(GAME_TITLE, SCREEN_HEIGHT, SCREEN_WIDTH);
        run();
    }

    private void tick() {

    }

    private void render(Graphics g) {
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bufferStrategy.getDrawGraphics();
        g.clearRect(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);

        currentState.render(g);

        bufferStrategy.show();
        g.dispose();
    }

    private void run() {
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(true){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render(g);
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
    }


}
