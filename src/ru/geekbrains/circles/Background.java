package ru.geekbrains.circles;

import java.awt.*;

/**
 * Created by Administrator on 15.07.2017.
 */
public class Background extends Sprite {

    private int xPos = 0;
    private int yPos = 0;
    private int width = 200;
    private int height = 200;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBackground(GameCanvas gameCanvas, Graphics g, float deltaTime){
        this.render(gameCanvas,g);
        this.update(gameCanvas,deltaTime);
    }

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {
    }

    @Override
    void render(GameCanvas gameCanvas,Graphics g) {
        Color color;
        color = setColor();
        g.setColor(color);
        g.fillRect(xPos,yPos,width,height);
    }

    private Color setColor(){
        return new Color((int) (Math.random() * 256f), (int) (Math.random() * 256f),
                (int) (Math.random() * 256f));
    }
}
