package Lesson_3.PhoneBook;

import java.util.*;

public class PhoneBook {
    Map<String, Set<String>> phoneBook = new TreeMap<>();

    void add(String name, String phoneNum){
        Set<String> phones = phoneBook.get(name);
        if (phones == null){
            phones = new TreeSet<>();
            phoneBook.put(name, phones);
        }
        phones.add(phoneNum);
    }

    void get(String name){
        if (phoneBook.get(name) == null){
            System.out.println("Записи с фамилией " + name + " нет");
        }else {
        System.out.println("Фамилия: " + name + ". Номера телефонов: " + phoneBook.get(name));
        }
    }
}
