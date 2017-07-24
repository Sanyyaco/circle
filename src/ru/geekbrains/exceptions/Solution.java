package ru.geekbrains.exceptions;

/**
 * Created by Administrator on 23.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String[][] str = new String[][]{{"4","2","1","3"},{"4","2","1","3"},{"4","2","1","3"},{"4","2","1","3"}};
        try{
            method1(str);
        }catch (MyArraySizeException e){
            e.printStackTrace();
        } catch(MyArrayDataException e){
            e.printStackTrace();
        }

    }

    public static void method1(String[][] inputStr) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        int n = inputStr.length;
        if(n != 4) throw new MyArraySizeException();
        for (int i = 0; i < n ; i++) {
            int m = inputStr[i].length;
            if( m != 4) throw new MyArraySizeException();

            for (int j = 0; j < m ; j++) {
                try{
                    int number = Integer.parseInt(inputStr[i][j]);
                    sum += number;
                } catch (NumberFormatException e){
                    String message = "String parseInt error at cell: " + i +" "+ j;
                    throw new MyArrayDataException(message);
                }
            }
        }
        System.out.println(sum);
    }
}
