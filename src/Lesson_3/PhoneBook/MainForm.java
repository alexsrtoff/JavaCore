package Lesson_3.PhoneBook;

public class MainForm {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Алекс", "123");
        phoneBook.add("Алекс", "456");
        phoneBook.add("Вася", "789");
        phoneBook.add("Петя", "1011");
        phoneBook.get("Петров");
        phoneBook.get("Вася");
        phoneBook.get("Алекс");
    }
}
