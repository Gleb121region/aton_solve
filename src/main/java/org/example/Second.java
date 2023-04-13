package org.example;

import java.util.HashMap;
import java.util.Random;

public class Second {

    public static String createRandomNumber() {
        Random rand = new Random();
        String digits = "1234567890";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int index = rand.nextInt(digits.length());
            sb.append(digits.charAt(index));
        }
        return sb.toString();
    }

    public static String createRandomName() {
        Random rand = new Random();
        String digits = "qwertyuiopasdfghjklzxcvbnmйцукенгшщзхъфывапролджэёячсмитттттьбю";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            int index = rand.nextInt(digits.length());
            sb.append(digits.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(createRandomNumber());
//        System.out.println(createRandomName());
//        0(1) -> HASHMAP
//         79 в РОССИИ ПО УМОЛЧАНИЮ
        int size = 18_758_328;
        HashMap<String, String> phone2Fio = new HashMap<>(size);

        while (phone2Fio.size() != size) {
            phone2Fio.put(createRandomNumber(), createRandomName());
        }

        System.out.println(phone2Fio.size());

    }

}
