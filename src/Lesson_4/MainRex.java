package Lesson_4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Необходимо из консоли считать пароль и проверить валидность,
результат будет true или false

Требования:
1. Пароль должен быть не менее 8ми символов.
2. В пароле должно быть число
3. В пароле должна быть хотя бы 1 строчная буква
4. В пароле должна быть хотя бы 1 заглавная буква
5. Не должно быть пробелов
 */

public class MainRex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Придуматйте пароль\nТребования:\n" +
                "1. Пароль должен быть не менее 8ми символов.\n" +
                "2. В пароле должно быть число\n" +
                "3. В пароле должна быть хотя бы 1 строчная буква\n" +
                "4. В пароле должна быть хотя бы 1 заглавная буква\n" +
                "5. Не должно быть пробелов\n" +
                "Введите придуманный пароль: ");

        String passWord = input.nextLine();
        Boolean result = find(passWord);
        if (result){
            System.out.println("Результат проверки пароля: " + result);
        }else {
            System.out.println("Что-то пошло не так... Ознакомтесь с правилами формирования пароля и попробуйте еще раз");
            System.out.println("Результат проверки пароля: " + result);
        }
    }

    public static boolean find(String str) {

        Pattern p = Pattern.compile("^.*\\s.*$");
        Matcher m = p.matcher(str);
        if(m.matches()){
            System.out.println("Будте внимательны. Пароль содержит пробел");
        return !m.matches();}
        else {
            p = Pattern.compile("[.*[A-Z].+\\d.+|\\w.+\\W+.*]{8,}");
            m = p.matcher(str);
        }
        return m.matches();
    }
}

