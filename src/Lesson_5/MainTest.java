package Lesson_5;
import Lesson_5.ManyThreads.ManyThreads;
import Lesson_5.ManyThreads.MyNumThreadExeption;
import Lesson_5.ManyThreads.MyNumThreadNullExeption;

import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {
        OneThread one = new OneThread();
        TwoThreads two = new TwoThreads();
        ManyThreads many = new ManyThreads();

        System.out.println("Время выполнения одного потока:");
        long a = System.currentTimeMillis();
        one.check();
        System.out.println(System.currentTimeMillis() - a);
        System.out.println();

        System.out.println("Время выполнения двух потоков:");
        long b = System.currentTimeMillis();
        two.check();
        System.out.println(System.currentTimeMillis() - b);
        System.out.println("Сравнение первоначального массива и полученного: " + Arrays.equals(one.getArr(),two.getArr()));
        System.out.println();

        System.out.println("Выполнение нескольких потоков:");
        long c = System.currentTimeMillis();
        try {
            many.check(4);
        } catch (MyNumThreadExeption e) {
            System.out.println( e.getMessage());
        }catch (MyNumThreadNullExeption e) {
            System.out.println( e.getMessage());
        }
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - c));
        System.out.println("Сравнение первоначального массива и полученного: " +Arrays.equals(one.getArr(),many.getArr()));
    }
}

