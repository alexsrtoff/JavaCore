package Lesson_2.Exeption;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException(String msg) {
        super(msg);
    }
}
