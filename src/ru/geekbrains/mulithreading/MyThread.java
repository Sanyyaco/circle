package ru.geekbrains.mulithreading;

import static ru.geekbrains.mulithreading.Solution.h;
import static ru.geekbrains.mulithreading.Solution.size;

/**
 * Created by Administrator on 02.08.2017.
 */
public class MyThread extends Thread {

    private float[] arr;
    private int size;
    private int offset;
    private long a;

    public MyThread(float[] arr, int size, int offset) {
        this.arr = arr;
        this.size = size;
        this.offset = offset;
        System.out.println(this.getName()+ ": начал подсчет.");
        start();
        a = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i+offset) / 5) * Math.cos(0.2f + (i+offset) / 5) * Math.cos(0.4f + (i+offset) / 2));
        }
        System.out.println(this.getName()+ ": закончил подсчет за " + (System.currentTimeMillis() - a) + " милсек.");
    }
}
