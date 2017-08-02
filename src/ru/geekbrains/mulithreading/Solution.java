package ru.geekbrains.mulithreading;

import java.util.Arrays;

/**
 * Created by Administrator on 31.07.2017.
 */
public class Solution {

    static final int size = 10;
    static final int h = size / 2;
    static float[] arr1 = new float[size];
    static float[] arr2 = new float[size];

    public static void main(String[] args) {
        method1();
        method2();

        if (Arrays.equals(arr1,arr2)) System.out.println("Массивы одинаковы");
        else System.out.println("Массивы разные");
    }

    static void method1(){

        for (int i = 0; i < size ; i++) {
            arr1[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < size ; i++) {
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    static void method2(){

        for (int i = 0; i < size ; i++) {
            arr2[i] = 1;
        }
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr2, 0, a1, 0, h);
        System.arraycopy(arr2, h, a2, 0, h);

        MyThread myThread = new MyThread(a1, h,0);
        MyThread myThread2 = new MyThread(a2, h,h);


        try {
            myThread.join();
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr2, 0, h);
        System.arraycopy(a2, 0, arr2, h, h);

        System.out.println(System.currentTimeMillis() - a);
    }
}
