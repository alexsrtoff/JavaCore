package Lesson_5.ManyThreads;

public class ManyThreads {
    static final int SIZE = 10_000_000;
    float[] arr = new float[SIZE];

    public float[] getArr() {
        return arr;
    }

    public void check(int numThreads) throws MyNumThreadExeption, MyNumThreadNullExeption {
        checkNumTreads(numThreads);
        System.out.println("Количество потоков: " + numThreads);

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < SIZE; i++) arr[i] = 1;

        for(int j = 0; j < numThreads; j++){
            float[] arrTemp = new float[SIZE / numThreads];
            int count = j;
            int a = SIZE/numThreads*j;
            System.arraycopy(arr,a, arrTemp, 0, SIZE / numThreads);
            threads[j] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < SIZE / numThreads; i++) {
                                arrTemp[i] = (float) (arrTemp[i] * Math.sin(0.2f + ((i+a) / 5)) *
                                        Math.cos(0.2f + ((i+a) / 5)) * Math.cos(0.4f + ((i+a) / 2)));

                    }
                    System.arraycopy(arrTemp, 0, arr, a, SIZE/numThreads);
                }
            });
        }

        for (Thread o:threads) {
            o.start();

        }

        for (Thread o:threads) {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkNumTreads(int num) throws MyNumThreadExeption {

        if (num == 0){
            throw new MyNumThreadExeption("Количествопотоков не может быть равно нулю");
        }
        if(SIZE % num != 0) {
            throw new MyNumThreadNullExeption("Количество потоков должно быть кратно размеру массива " + SIZE);
        }
    }
}
