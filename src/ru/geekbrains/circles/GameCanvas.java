package ru.geekbrains.circles;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas extends JPanel {

    private long lastFrameTime;
    private final GameWindow gameWindow;
    private Background background;

    public GameCanvas(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        lastFrameTime = System.nanoTime();
        background = new Background();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked");
                addBall();
            }
        });
    }

    private void addBall(){
        gameWindow.addBall();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 1e-9f;
        lastFrameTime = currentTime;

        background.setWidth(this.getWidth());
        background.setHeight(this.getHeight());
        background.setBackground(this,g,deltaTime);
        gameWindow.onDrawFrame(this, g,deltaTime);


        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getRight(){
        return getWidth() -1;
    }

    public int getLeft(){
        return 0;
    }

    public int getTop(){
        return 0;
    }

    public int getBottom(){
        return getHeight()-1;
    }

}
