package ru.geekbrains.mulithreading;

import static ru.geekbrains.mulithreading.Solution.h;

/**
 * Created by Administrator on 02.08.2017.
 */
public class MyThread extends Thread {

    float[] arr = new float[h];

    public MyThread(float[] arr) {
        this.arr = arr;
        System.out.println(this.getName()+ ": начал подсчет.");
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < h ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
