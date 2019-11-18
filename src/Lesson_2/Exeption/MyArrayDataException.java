package Lesson_2.Exeption;

public class MyArrayDataException extends NumberFormatException {
    int i, j;

    public MyArrayDataException(int i, int j) {
        super("В ячейке " + i + " " + j + " содержится не число");
//        this.i = i;
//        this.j = j;

    }
}
