package ru.geekbrains.circles;

import java.awt.*;

/**
 * Created by Administrator on 15.07.2017.
 */
public class Background extends Sprite {


    private float time;
    private static final float AMPLITUDE = 255f/2f;
    private Color color;

    public Background() {

    }

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE * (1 + (float)Math.sin(time)));
        int green = Math.round(AMPLITUDE * (1 + (float)Math.sin(time * 2f)));
        int blue = Math.round(AMPLITUDE * (1 + (float)Math.sin(time * 3f)));
        color = new Color(red,green,blue);

    }

    @Override
    void render(GameCanvas gameCanvas,Graphics g) {
        gameCanvas.setBackground(color);
    }
}
