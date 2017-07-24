package ru.geekbrains.collections;

import java.util.*;

/**
 * Created by Administrator on 24.07.2017.
 */
public class Solution2 {
    static class PhoneBook {
        private String name;
        private Set<String> phoneList;
        private static Map<String,Set<String>> phoneBook =new HashMap<>();

        public void add(String name, String phoneNumber){
            phoneList = new HashSet<>();
            phoneList.add(phoneNumber);

           if (phoneBook.get(name) == null) phoneBook.put(name,phoneList);
                else{
                    phoneList = phoneBook.get(name);
                    phoneList.add(phoneNumber);
                    phoneBook.put(name,phoneList);
                }

        }

        public void get(String name){

            Set<String> list = phoneBook.get(name);

            for(String e: list){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Петя","123132");
        phoneBook.add("Петя","54897");
        phoneBook.add("Петя","98713214");
        phoneBook.add("Рома","12346");

        phoneBook.get("Петя");
    }
}
