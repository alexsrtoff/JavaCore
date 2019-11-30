package Lesson_5;

public class TwoThreads {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];
    float[] arr1 = new float[HALF];
    float[] arr2 = new float[HALF];

    public float[] getArr() {
        return arr;
    }

    public void check(){
        for (int i = 0; i < SIZE; i++){
            arr[i] = 1;
        }

        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++ ){
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(arr1, 0, arr, 0, HALF);

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++ ){
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (i + HALF ) / 5) * Math.cos(0.2f + (i + HALF ) / 5) * Math.cos(0.4f + (i + HALF ) / 2));
                }
                System.arraycopy(arr2, 0, arr, HALF, HALF);

            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
