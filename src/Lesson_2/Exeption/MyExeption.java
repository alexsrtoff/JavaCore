package Lesson_2.Exeption;

import java.util.Random;

public class MyExeption {
    static String[][] array;

    //массив только с числами
    public static void createArray(int x, int y){
        if (x != 4 || y != 4) throw new MyArraySizeException("Массив должен иметь размерность 4 на 4");
        array = new String[x][y];
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                double z = Math.random()*10;
                array[i][j] = String.valueOf((int)z);
            }
        }
        showArray();
        sumArray();
    }

// массив с одной буквой
    public static void createArray(int x, int y, String str){
        if (x != 4 || y != 4) throw new MyArraySizeException("Массив должен иметь размерность 4 на 4");
        array = new String[x][y];
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                double z = Math.random()*10;
                array[i][j] = String.valueOf((int)z);
            }
           array[1][1] = str;
        }
        showArray();
        sumArray();
    }

    public static void showArray(){
        System.out.println("Массив для проверки:");
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void sumArray()  {
        int sum = 0;
        int x = 0;

            for(int i = 0; i < array.length; i++){
                for (int j = 0; j < array[i].length; j++){
                    try {
                    x = Integer.valueOf(array[i][j]);
                    } catch (NumberFormatException e){
                        throw new MyArrayDataException(i, j);
                    }
                    sum += x;
                }
            }
        System.out.println("Сумма чисел в массиве: " + sum);
    }

    public static void main(String[] args) {
        try {
            createArray(4, 4);
//            createArray(4,4, "s");

        }catch (MyArraySizeException e){
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }


}
