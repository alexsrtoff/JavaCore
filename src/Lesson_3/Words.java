package Lesson_3;

import java.util.*;

public class Words {
    public static void main(String[] args) {
        String[] words = {"A","B","C","D","E",
                        "R","D","A","F","E",
                        "Q","W","E","C","A",
                        "W","Q","G","F","D",
                        "H","T","R","E","W",};

        Map<String, Integer> wordMap = new LinkedHashMap<>();
        for (int i = 0; i < words.length; i++) {
            Integer w = wordMap.get(words[i]);
            wordMap.put(words[i], w == null? 1 : w + 1);
        }
        System.out.println("Уникальны слова и количество их повторений:\n" + wordMap);
    }
}
