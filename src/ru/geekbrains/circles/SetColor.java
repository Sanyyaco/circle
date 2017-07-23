package ru.geekbrains.circles;

import java.awt.*;

/**
 * Created by Administrator on 22.07.2017.
 */
public class SetColor extends Color {
    public SetColor(int r, int g, int b) {
        super(r, g, b);

        try {
            super.getClass().getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


}
