package Lesson_5;

public class OneThread {
    static final int SIZE = 10_000_000;

    public float[] getArr() {
        return arr;
    }

    float[] arr = new float[SIZE];


    public void check(){
        for (int i = 0; i < SIZE; i++){
            arr[i] = 1;
        }
        for (int i = 0; i < SIZE; i++){
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
